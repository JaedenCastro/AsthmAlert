// In TFT eSPI's User_Setup.h, you must disable the TFT_BL for the backlight control to work

#include <TFT_eSPI.h>
#include "FS.h"
#include "SPIFFS.h"
#include "TableHeap.h"
#include "Free_Fonts.h"
#include "BluetoothSerial.h"
#include <Arduino.h>
#include <SensirionI2CSen5x.h>
#include <Wire.h>
// Pins
const byte LEDB = 17;
const byte LEDG = 16;
const byte LEDR = 4;
const byte LCD_BL_PIN = 27;
const byte LDR_PIN = 34;
const byte MOTOR_PIN = 35; // not sure if this works or is the right pin; works on an uno

// Initialize touchsreen, display and motor state
TFT_eSPI tft = TFT_eSPI();
uint16_t backcolor = TFT_BLACK;
SensirionI2CSen5x sen5x;
BluetoothSerial SerialBT;
bool motor_state = LOW;

const int tempDeltaTime = 10; // Time interval (in seconds) between the two temperature averages being compared 
const int tempArrayLength = (tempDeltaTime * 2) + 2;
double tempArray[tempArrayLength];

int reportingPeriod = 1000; 
uint32_t lastReport = 0;
int aqiPm25 = 0;
int aqiPm10 = 0;

#define TFT_GREY 0x2104 // Dark grey 16-bit colour
#define vibration_duration 1000  
#define VIBRATE_INTERVAL 1000 

// Initialize Sen55
#define MAXBUF_REQUIREMENT 48
#define I2C_SDA 21 // Change to your SDA pin
#define I2C_SCL 22  // Change to your SCL pin

#if (defined(I2C_BUFFER_LENGTH) &&                 \
     (I2C_BUFFER_LENGTH >= MAXBUF_REQUIREMENT)) || \
    (defined(BUFFER_LENGTH) && BUFFER_LENGTH >= MAXBUF_REQUIREMENT)
#define USE_PRODUCT_INFO
#endif

// constants for the table
const int numRows = 4;
const int numCols = 2;
const int cellWidth = 100; //wide
const int cellHeight = 75; // tall
const int startX = 10;
const int startY = 10;

// Measured values for the Sen55
float massConcentrationPm1p0 = 0;
float massConcentrationPm2p5 = 0;
float massConcentrationPm4p0 = 0;
float massConcentrationPm10p0 = 0;
float ambientHumidity = 0;
float ambientTemperature = 0;
float temperatureChange = 0;
float vocIndex = 0;
float noxIndex = 0;

// Define the character arrays to hold the formatted float values
char vocIndexStr[10];
char noxIndexStr[10];
char pm2p5Str[10];
char pm10Str[10];

// Create the 2D array to hold the string representations
const char* elements[4][2] = {
    {"VOC", vocIndexStr},
    {"NOx", noxIndexStr},
    {"PM 2.5", pm2p5Str},
    {"PM 10", pm10Str}
};

// Temp, Humidity, VOC Index, PM (any)
void drawTable() {
  tft.setTextSize(1);
  tft.setTextColor(TFT_BLACK);
  
  // Draw table grid
  for (int row = 0; row <= numRows; row++) {
    int y = startY + row * cellHeight;
    tft.drawLine(startX, y, startX + numCols * cellWidth, y, TFT_WHITE); // Draw horizontal lines
  }
  
  for (int col = 0; col <= numCols; col++) {
    int x = startX + col * cellWidth;
    tft.drawLine(x, startY, x, startY + numRows * cellHeight, TFT_WHITE); // Draw vertical lines
  }

  // Add text to cells
  tft.setTextSize(1.5); 
  for (int row = 0; row < numRows; row++) {
    for (int col = 0; col < numCols; col++) {
      int x = startX + col * cellWidth + 5; // Add some padding
      int y = startY + row * cellHeight + 28; // Add some padding
      tft.setCursor(x, y);
      tft.setTextColor(TFT_WHITE);
      tft.print(elements[row][col]);
    }
  }
}
// This is created in reference to the wikipedia AQI thresholds
// See https://en.wikipedia.org/wiki/Air_quality_index
void updateBottomText(int pm2p5, int pm10) {  
  tft.setTextSize(2); 
  tft.setCursor(260, 275);
  if (pm2p5 >= 225 || pm10 >= 425) 
    tft.setCursor(260, 275);
    tft.print("Hazardous");
  if (pm2p5 >= 125 || pm10 >= 355)
    tft.setCursor(260, 275);
    tft.setTextSize(1);
    tft.print("Very Unhealthy");
    tft.setTextSize(2); 
  if (pm2p5 >= 55 || pm10 >= 155)
    tft.setCursor(260, 275);
    tft.print("Unhealthy");
  if (pm2p5 >= 35 || pm10 >= 155)
    tft.setCursor(260, 275);
    tft.print("Unhealthy");
  if (pm2p5 >= 9 || pm10 >= 55) {
    tft.setCursor(260, 275);
    tft.print("Moderate");
  } else {
    tft.setCursor(260, 275);
    tft.print("Good");
  tft.setTextSize(1); 
  }
}

void printModuleVersions() {
    uint16_t error;
    char errorMessage[256];

    unsigned char productName[32];
    uint8_t productNameSize = 32;

    error = sen5x.getProductName(productName, productNameSize);

    if (error) {
        Serial.print("Error trying to execute getProductName(): ");
        errorToString(error, errorMessage, 256);
        Serial.println(errorMessage);
    } else {
        Serial.print("ProductName:");
        Serial.println((char*)productName);
    }

    uint8_t firmwareMajor;
    uint8_t firmwareMinor;
    bool firmwareDebug;
    uint8_t hardwareMajor;
    uint8_t hardwareMinor;
    uint8_t protocolMajor;
    uint8_t protocolMinor;

    error = sen5x.getVersion(firmwareMajor, firmwareMinor, firmwareDebug,
                             hardwareMajor, hardwareMinor, protocolMajor,
                             protocolMinor);
    if (error) {
        Serial.print("Error trying to execute getVersion(): ");
        errorToString(error, errorMessage, 256);
        Serial.println(errorMessage);
    } else {
        Serial.print("Firmware: ");
        Serial.print(firmwareMajor);
        Serial.print(".");
        Serial.print(firmwareMinor);
        Serial.print(", ");

        Serial.print("Hardware: ");
        Serial.print(hardwareMajor);
        Serial.print(".");
        Serial.println(hardwareMinor);
    }
}

void setupSen55(){
  sen5x.begin(Wire);
    uint16_t error;
    char errorMessage[256];
    error = sen5x.deviceReset();
    if (error) {
        Serial.print("Error trying to execute deviceReset(): ");
        errorToString(error, errorMessage, 256);
        Serial.println(errorMessage);
    }
  ///////
  // Print SEN55 module information if i2c buffers are large enough
  #ifdef USE_PRODUCT_INFO
      printSerialNumber();
      printModuleVersions();
  #endif

    // set a temperature offset in degrees celsius
    // Note: supported by SEN54 and SEN55 sensors
    // By default, the temperature and humidity outputs from the sensor
    // are compensated for the modules self-heating. If the module is
    // designed into a device, the temperature compensation might need
    // to be adapted to incorporate the change in thermal coupling and
    // self-heating of other device components.
    //
    // A guide to achieve optimal performance, including references
    // to mechanical design-in examples can be found in the app note
    // “SEN5x – Temperature Compensation Instruction” at www.sensirion.com.
    // Please refer to those application notes for further information
    // on the advanced compensation settings used
    // in `setTemperatureOffsetParameters`, `setWarmStartParameter` and
    // `setRhtAccelerationMode`.
    //
    // Adjust tempOffset to account for additional temperature offsets
    // exceeding the SEN module's self heating.
    float tempOffset = 0.0;
    error = sen5x.setTemperatureOffsetSimple(tempOffset);
    if (error) {
        Serial.print("Error trying to execute setTemperatureOffsetSimple(): ");
        errorToString(error, errorMessage, 256);
        Serial.println(errorMessage);
    } else {
        Serial.print("Temperature Offset set to ");
        Serial.print(tempOffset);
        Serial.println(" deg. Celsius (SEN54/SEN55 only");
    }

    // Start Measurement
    error = sen5x.startMeasurement();
    if (error) {
        Serial.print("Error trying to execute startMeasurement(): ");
        errorToString(error, errorMessage, 256);
        Serial.println(errorMessage);
    }
}

float calcAqi(float concentration, String pollutant) {
    float cLow[8], cHigh[8], iLow[8], iHigh[8];
    
    if (pollutant == "PM2.5") {
        float cLowPm25[] = {0, 9.1, 35.5, 55.5, 125.5, 225.5, 325.5, 500.5};
        float cHighPm25[] = {9.0, 35.4, 55.4, 125.4, 225.4, 325.4, 500.4, 1000.0};
        float iLowPm25[] = {0, 51, 101, 151, 201, 301, 401, 501};
        float iHighPm25[] = {50, 100, 150, 200, 300, 400, 500, 9999};
        
        memcpy(cLow, cLowPm25, sizeof(cLowPm25));
        memcpy(cHigh, cHighPm25, sizeof(cHighPm25));
        memcpy(iLow, iLowPm25, sizeof(iLowPm25));
        memcpy(iHigh, iHighPm25, sizeof(iHighPm25));
    }
    else if (pollutant == "PM10") {
        float cLowPm10[] = {0, 55, 155, 255, 355, 425, 505, 605};
        float cHighPm10[] = {54, 154, 254, 354, 424, 504, 604, 999.0};
        float iLowPm10[] = {0, 51, 101, 151, 201, 301, 401, 501};
        float iHighPm10[] = {50, 100, 150, 200, 300, 400, 500, 9999};
        
        memcpy(cLow, cLowPm10, sizeof(cLowPm10));
        memcpy(cHigh, cHighPm10, sizeof(cHighPm10));
        memcpy(iLow, iLowPm10, sizeof(iLowPm10));
        memcpy(iHigh, iHighPm10, sizeof(iHighPm10));
    } else {
        Serial.println("Invalid pollutant type");
        return -1; // Error case
    }

    for (int i = 0; i < 8; i++) {
        if (concentration >= cLow[i] && concentration <= cHigh[i]) {
            float aqi = ((iHigh[i] - iLow[i]) / (cHigh[i] - cLow[i])) * (concentration - cLow[i]) + iLow[i];
            return round(aqi);
        }
    }

    if (concentration > cHigh[7]) {
        float aqi = ((iHigh[7] - iLow[7]) / (cHigh[7] - cLow[7])) * (concentration - cLow[7]) + iLow[7];
        return round(aqi); 
    }
    
    Serial.println("Input concentration is below AQI scale");
    return -1; // Error case
}

void operateSen55() {
uint16_t error;
    char errorMessage[256];
    double tempAveThen = 0;
    double tempAveNow = 0;
    double tempChange;
 
    error = sen5x.readMeasuredValues(
        massConcentrationPm1p0, massConcentrationPm2p5, massConcentrationPm4p0,
        massConcentrationPm10p0, ambientHumidity, ambientTemperature, vocIndex,
        noxIndex);
    // Convert float values to C-style strings and store them in arrays
    sprintf(vocIndexStr, "%.2f", vocIndex);
    sprintf(noxIndexStr, "%.2f", noxIndex);
    sprintf(pm2p5Str, "%.2f", massConcentrationPm2p5);
    sprintf(pm10Str, "%.2f", massConcentrationPm10p0);
    if (error) {
        Serial.print("Error trying to execute readMeasuredValues(): ");
        errorToString(error, errorMessage, 256);
        Serial.println(errorMessage);
    } else {}
        if (isnan(vocIndex)) { // VOC Index
            Serial.print("n/a");
            SerialBT.print("n/a");
        } else {
            Serial.print(vocIndex);
            SerialBT.print(vocIndex);
        }
        Serial.print(",");
        SerialBT.print(",");
        if (isnan(noxIndex)) {
            Serial.print("n/a");
            SerialBT.print("n/a");
        } else {
            Serial.print(noxIndex);
            SerialBT.print(noxIndex);
        }
        Serial.print(",");
        SerialBT.print(",");
        if (isnan(ambientTemperature)) {
            Serial.print("n/a");
            SerialBT.print("n/a");
        } else {
            Serial.print(ambientTemperature);
            SerialBT.print(ambientTemperature);

            if (millis() - lastReport > reportingPeriod) {
              // Add temperature data to tempArray
              for (int i = 0; i < tempArrayLength - 1; i++) {
                tempArray[i] = tempArray[i + 1];
              }
            tempArray[tempArrayLength - 1] = ambientTemperature;

            // Get average temperature values for then (10 seconds ago) and now
            for (int i = 0; i < 5; i++) {
              tempAveThen += tempArray[i];
              tempAveNow += tempArray[tempArrayLength - (i + 1)];
            }
            tempAveThen = tempAveThen/5;
            tempAveNow = tempAveNow/5;

            // Calculate average temperature change
            tempChange = abs(tempAveNow - tempAveThen);

            Serial.print(",");
            SerialBT.print(",");
            Serial.print(tempChange);
            SerialBT.print(tempChange);
        }
        Serial.print(",");
        SerialBT.print(",");
        if (isnan(ambientHumidity)) {
            Serial.print("n/a");
            SerialBT.print("n/a");
        } else {
            Serial.print(ambientHumidity);
            SerialBT.print(ambientHumidity);
        }
        Serial.print(",");
        SerialBT.print(",");
        Serial.print(massConcentrationPm1p0);
        SerialBT.print(massConcentrationPm1p0);
        Serial.print(",");
        SerialBT.print(",");
        Serial.print(massConcentrationPm2p5);
        SerialBT.print(massConcentrationPm2p5);
        Serial.print(",");
        SerialBT.print(",");
        Serial.print(massConcentrationPm4p0);
        SerialBT.print(massConcentrationPm4p0);
        Serial.print(",");
        SerialBT.print(",");
        Serial.println(massConcentrationPm10p0);
        SerialBT.println(massConcentrationPm10p0);

        delay(500);

        aqiPm25 = calcAqi(massConcentrationPm2p5, "PM2.5");
        aqiPm10 = calcAqi(massConcentrationPm10p0, "PM10");

        // Output the larger AQI value
        if (aqiPm25 >= aqiPm10) {
            Serial.print(aqiPm25);
            SerialBT.print(aqiPm25);
        } else {
            Serial.print(aqiPm10);
            SerialBT.print(aqiPm10);
        }

        Serial.print("|");
        SerialBT.print("|");
    }
}
// This is created in reference to the wikipedia AQI thresholds
// See https://en.wikipedia.org/wiki/Air_quality_index

int aqiColors(int pm2p5, int pm10) { 
  if (pm2p5 >= 225 || pm10 >= 425) 
    return 0x8024;      // Maroon
  if (pm2p5 >= 125 || pm10 >= 355)
    return 0x91F2;      // Purple
  if (pm2p5 >= 55 || pm10 >= 155)
    return 0xF820;      // Red
  if (pm2p5 >= 35 || pm10 >= 155)
    return 0xFC00;      // Orange
  if (pm2p5 >= 9 || pm10 >= 55)
    return 0xFFE0;      // Yellow
  else
    return 0x07E0;      // Green
}

void drawText(const char* text, int x, int y, int textSize = 1, uint16_t textColor = TFT_WHITE, uint16_t backColor = TFT_BLACK) {
    // Set the text size and color
    tft.setTextSize(textSize);
    tft.setTextColor(textColor, backColor);
    tft.setTextDatum(MC_DATUM); // Center text

    // Draw the text
    tft.setTextPadding(0);
    tft.drawString(text, x, y);
}

void printSerialNumber() {
    uint16_t error;
    char errorMessage[256];
    unsigned char serialNumber[32];
    uint8_t serialNumberSize = 32;

    error = sen5x.getSerialNumber(serialNumber, serialNumberSize);
    if (error) {
        Serial.print("Error trying to execute getSerialNumber(): ");
        errorToString(error, errorMessage, 256);
        Serial.println(errorMessage);
    } else {
        Serial.print("SerialNumber:");
        Serial.println((char*)serialNumber);
    }
}
// 1. Fill a rectangle  using black
// 2. Draw Text 1

void drawText(const char* text, int x, int y, int textSize = 1, uint16_t textColor = TFT_WHITE, uint16_t backColor = TFT_BLACK) {
    // Calculate the text width and height
    int16_t textWidth = tft.textWidth(text);
    int16_t textHeight = tft.fontHeight();

    // Erase the previous text area
    tft.fillRect(x - textWidth / 2, y - textHeight / 2, textWidth, textHeight, backColor);

    // Set the text size and color
    tft.setTextSize(textSize);
    tft.setTextColor(textColor, backColor);
    tft.setTextDatum(MC_DATUM); // Center text

    // Draw the new text
    tft.drawString(text, x, y);
}

void setup() {
  // Configure and turn off the RGB LED
  pinMode(LEDR, OUTPUT);
  pinMode(LEDG, OUTPUT);
  pinMode(LEDB, OUTPUT);

  digitalWrite(LEDR, HIGH);
  digitalWrite(LEDG, HIGH);
  digitalWrite(LEDB, HIGH);

  // Configure backlight
  pinMode(LCD_BL_PIN, OUTPUT);
  digitalWrite(LCD_BL_PIN, HIGH);

  // Configure the LDR
  pinMode(LDR_PIN, ANALOG);
  analogReadResolution(12);         // 12 bits
  analogSetWidth(12);               // 12 bits
  analogSetPinAttenuation(LDR_PIN, ADC_6db);   // Maximum voltage of 1350mV

  // Initialize LCD
  tft.begin();
  tft.invertDisplay(0);
  tft.setRotation(3); // This line messes with the rotation of the display
  //calibrateTouchscreen(false);
  tft.fillScreen(backcolor);
  tft.setTextColor(TFT_WHITE, backcolor);
  tft.setFreeFont(FSS12);
  tft.setTextSize(1);
  tft.setTextDatum(TL_DATUM);

  // Initialize the Motor
  pinMode(MOTOR_PIN, OUTPUT);

  // Draw UI elements
  drawRingMeter(0,  150,  145, 245,   0,  110, "*AQI", aqiColors(0,0), TFT_GREY, TFT_WHITE, TFT_BLACK);
  drawTable();
  updateBottomText((int)aqiPm25, (int)aqiPm10);
  
  //Initialize Bluetooth and Touchscreen
  Serial.begin(115200);

  //Initialize Sen55
  Wire.begin();
  setupSen55();
  SerialBT.begin("AsthmAlert"); //Bluetooth device name
  //delay(1000);
}
uint32_t elapsed_time = 0;
void loop() {
  // Draw UI elements
  // int value, int vMin, int vMax, int x, int y, int r, const char *units, int graphColor (current color), int graphColor2 (non lit up part), int textColor, int backColor
  updateBottomText((int)aqiPm25, (int)aqiPm10);
  drawRingMeter(aqiPm25,  150,  145, 245,   0,  110, "*AQI", aqiColors((int)aqiPm25, (int)aqiPm10), TFT_GREY, TFT_WHITE, TFT_BLACK);
  drawTable();
    
  if(millis() >= elapsed_time + vibration_duration) {
    elapsed_time += vibration_duration;
    motor_state = !motor_state;
    digitalWrite(MOTOR_PIN, motor_state);
  }
  operateSen55();
  Serial.println(aqiPm25);
  Serial.println(aqiPm10);
  //delay(1000);
}