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
const byte MOTOR_PIN = 35; 

// Initialize touchsreen, display and motor state
TFT_eSPI tft = TFT_eSPI();
uint16_t backcolor = TFT_BLACK;
BluetoothSerial SerialBT;
bool motor_state = LOW;

#define TFT_GREY 0x2104 // Dark grey 16-bit colour
#define VIBRATE_INTERVAL 1000 

// Initialize Sen55
#define MAXBUF_REQUIREMENT 48
#define I2C_SDA 2 // Change to your SDA pin
#define I2C_SCL 3  // Change to your SCL pin

#if (defined(I2C_BUFFER_LENGTH) &&                 \
     (I2C_BUFFER_LENGTH >= MAXBUF_REQUIREMENT)) || \
    (defined(BUFFER_LENGTH) && BUFFER_LENGTH >= MAXBUF_REQUIREMENT)
#define USE_PRODUCT_INFO
#endif

SensirionI2CSen5x sen5x;

// constants for the table
const int numRows = 4;
const int numCols = 2;
const int cellWidth = 100; //wide
const int cellHeight = 75; // tall
const int startX = 10;
const int startY = 10;
// Temp, Humidity, VOC Index, PM (any)
String elements[4][2] = {{"Temp", "Val1"}, {"Humidity", "Val2"}, {"VOC", "Val3"}, {"PM", "Val4"}};
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
void drawText() {
  tft.setTextSize(2); 
  tft.setCursor(260, 275);
  tft.print("Moderate");
  tft.setTextSize(1);
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

void operateSen55() {
  uint16_t error;
  char errorMessage[256];
  float massConcentrationPm1p0;
  float massConcentrationPm2p5;
  float massConcentrationPm4p0;
  float massConcentrationPm10p0;
  float ambientHumidity;
  float ambientTemperature;
  float vocIndex;
  float noxIndex;

  error = sen5x.readMeasuredValues(
      massConcentrationPm1p0, massConcentrationPm2p5, massConcentrationPm4p0,
      massConcentrationPm10p0, ambientHumidity, ambientTemperature, vocIndex,
      noxIndex);

  if (error) {
      Serial.print("Error trying to execute readMeasuredValues(): ");
      errorToString(error, errorMessage, 256);
      Serial.println(errorMessage);
  } else {
      Serial.print("MassConcentrationPm1p0:");
      Serial.print(massConcentrationPm1p0);
      Serial.print("\t");
      Serial.print("MassConcentrationPm2p5:");
      Serial.print(massConcentrationPm2p5);
      Serial.print("\t");
      Serial.print("MassConcentrationPm4p0:");
      Serial.print(massConcentrationPm4p0);
      Serial.print("\t");
      Serial.print("MassConcentrationPm10p0:");
      Serial.print(massConcentrationPm10p0);
      Serial.print("\t");
      Serial.print("AmbientHumidity:");
      if (isnan(ambientHumidity)) {
          Serial.print("n/a");
      } else {
          Serial.print(ambientHumidity);
      }
      Serial.print("\t");
      Serial.print("AmbientTemperature:");
      if (isnan(ambientTemperature)) {
          Serial.print("n/a");
      } else {
          Serial.print(ambientTemperature);
      }
      Serial.print("\t");
      Serial.print("VocIndex:");
      if (isnan(vocIndex)) {
          Serial.print("n/a");
      } else {
          Serial.print(vocIndex);
      }
      Serial.print("\t");
      Serial.print("NoxIndex:");
      if (isnan(noxIndex)) {
          Serial.println("n/a");
      } else {
          Serial.println(noxIndex);
      }
  }
}
int temperatureColors(int temp) {
  if (temp > 52)
    return 0xF800;      // Red
  if (temp >= 42)
    return 0xFA00;      // Dark orange
  if (temp >= 33)
    return 0xFC00;      // Orange
  if (temp >= 27)
    return 0xFFE0;      // Yellow
  else
    return 0x07E0;      // Green
}

int temperatureColors2(int temp) {
  if (temp > 92)
    return 0xF800;      // Red
  if (temp >= 67)
    return 0xFA00;      // Dark orange
  if (temp >= 45)
    return 0xFC00;      // Orange
  if (temp >= 30)
    return 0xFFE0;      // Yellow
  else
    return 0x07E0;      // Green
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
  drawRingMeter(0,  150,  145, 245,   0,  110, "*AQI", temperatureColors(0), TFT_GREY, TFT_WHITE, TFT_BLACK);
  drawTable();
  drawText();
  
  //Initialize Bluetooth and Touchscreen
  Serial.begin(115200);

  //Initialize Sen55
  Wire.setPins(I2C_SDA, I2C_SCL); // SDA = 2, SCL = 3
  Wire.begin();
  setupSen55();
  SerialBT.begin("AsthmAlert"); //Bluetooth device name
  delay(1000);
}

unsigned long previousMillis = 0;
void loop() {
  unsigned long currentMillis = millis(); //Initialize milils for vibration motor
  // Draw UI elements
  // drawRingMeter(Thi, xval, yval, x, y, r, "*AQI", temperatureColors(Thi), TFT_GREY, TFT_WHITE, TFT_BLACK);
  drawText();
  drawRingMeter(0,  150,  145, 245,   0,  110, "*AQI", temperatureColors(0), TFT_GREY, TFT_WHITE, TFT_BLACK);
  drawTable();
  SerialBT.print("125|1,2,3,4,5,6,7,8");
  
  if (currentMillis-previousMillis >= VIBRATE_INTERVAL){
    previousMillis = currentMillis;
    Serial.print("TEST \n");
    motor_state = !motor_state;
    digitalWrite(MOTOR_PIN, motor_state);
  }

  operateSen55();
  delay(1000);
}