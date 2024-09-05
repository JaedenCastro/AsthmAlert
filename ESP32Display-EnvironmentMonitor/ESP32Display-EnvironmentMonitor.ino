// In TFT eSPI's User_Setup.h, you must disable the TFT_BL for the backlight control to work

#include <TFT_eSPI.h>
#include "FS.h"
#include "SPIFFS.h"
#include "TableHeap.h"
#include "Free_Fonts.h"
#include "BluetoothSerial.h"
#include <Arduino.h>
#include <TAMC_GT911.h>

// Pins
const byte LEDB = 17;
const byte LEDG = 16;
const byte LEDR = 4;
const byte LCD_BL_PIN = 27;
const byte LDR_PIN = 34;
const byte MOTOR_PIN = 0; 

// Heat index constants from https://en.wikipedia.org/wiki/Heat_index
const float c1 = -8.78469475556;
const float c2 = 1.61139411;
const float c3 = 2.33854883889;
const float c4 = -0.14611605;
const float c5 = -0.012308094;
const float c6 = -0.0164248277778;
const float c7 = 2.211732E-3;
const float c8 = 7.2546E-4;
const float c9 = -3.582E-6;

// Initialize touchsreen and display
TFT_eSPI tft = TFT_eSPI();
BluetoothSerial SerialBT;

#define TFT_GREY 0x2104 // Dark grey 16-bit colour
#define VIBRATE_INTERVAL 1000 
bool motor_state = LOW;

bool range_error = false;

uint16_t backcolor = TFT_BLACK;

byte counter = 0;

//float sumRH = -40.0;
#include "TAMC_GT911.h"

#define TOUCH_SDA  4
#define TOUCH_SCL  5
#define TOUCH_INT 25
#define TOUCH_RST 26
#define TOUCH_WIDTH  320
#define TOUCH_HEIGHT 240

TAMC_GT911 tp = TAMC_GT911(TOUCH_SDA, TOUCH_SCL, TOUCH_INT, TOUCH_RST, TOUCH_WIDTH, TOUCH_HEIGHT);

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
/* #I'm not gonna remove this yet, in case we do touchscreen at all
void calibrateTouchscreen(bool recalibrate = false) {
  uint16_t calibrationData[5];
  bool valid = false;

  // Initialize file system if it does not exist
  SPIFFS.begin(true);

  // Does calibration file exist?
  if (SPIFFS.exists("/tscal.dat")) {
    if (recalibrate) {
      SPIFFS.remove("/tscal.dat");
    }
    else {
      fs::File f = SPIFFS.open("/tscal.dat", FILE_READ);
      if (f) {
        if (f.readBytes((char *)calibrationData, 14) == 14)
          valid = true;
        f.close();
      }
    }
  }

  // Load calibration data to the TFT touchscreen library
  if (valid && !recalibrate) {
    tft.setTouch(calibrationData);
  }
  else {
    // Recalibrate touchscreen
    tft.fillScreen(TFT_BLACK);
    tft.setCursor(20, 0);
    tft.setTextFont(2);
    tft.setTextSize(1);
    tft.setTextColor(TFT_WHITE, TFT_BLACK);

    tft.println("Touch corners as indicated");

    tft.setTextFont(1);

    tft.calibrateTouch(calibrationData, TFT_YELLOW, TFT_BLACK, 15);

    tft.println("Calibration done");
    delay(500);

    fs::File f = SPIFFS.open("/tscal.dat", FILE_WRITE);
    if (f) {
      f.write((const unsigned char *)calibrationData, 14);
      f.close();
    }

    tft.fillScreen(TFT_BLACK);
  }
}*/

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
  SerialBT.begin("AsthmAlert"); //Bluetooth device name

  Serial.println("TAMC_GT911 Example: Ready");
  tp.begin();
  tp.setRotation(ROTATION_NORMAL);
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

  tp.read();
  if (tp.isTouched){
    for (int i=0; i<tp.touches; i++){
      Serial.print("Touch ");Serial.print(i+1);Serial.print(": ");;
      Serial.print("  x: ");Serial.print(tp.points[i].x);
      Serial.print("  y: ");Serial.print(tp.points[i].y);
      Serial.print("  size: ");Serial.println(tp.points[i].size);
      Serial.println(' ');
  delay(1000);
}

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