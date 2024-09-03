// In TFT eSPI's User_Setup.h, you must disable the TFT_BL for the backlight control to work

#include <TFT_eSPI.h>
#include "FS.h"
#include "SPIFFS.h"
#include <Adafruit_Sensor.h>
#include <DHT.h>
#include <DHT_U.h>

#include "Free_Fonts.h"

// Pins
const byte LEDB = 17;
const byte LEDG = 16;
const byte LEDR = 4;
const byte LCD_BL_PIN = 27;
const byte LDR_PIN = 34;
const byte DHT_PIN = 21;

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

TFT_eSPI tft = TFT_eSPI();
DHT_Unified dht(DHT_PIN, DHT11);

#define TFT_GREY 0x2104 // Dark grey 16-bit colour

bool range_error = false;

uint16_t backcolor = TFT_BLACK;

const byte MAX_DATA = 195;
int8_t dataRH[MAX_DATA];
int8_t dataThi[MAX_DATA];
byte counter = 0;
float sumThi = -40.0;
float sumRH = -40.0;

void clearDataPoints() {
  for (uint8_t i = 0; i < MAX_DATA; i++) {
    dataRH[i] = 0;
    dataThi[i] = 0;
  }
}

void saveDataPoints(float RH, float Thi) {
  // Shift arrays by one towards index 0
  for (uint8_t i = 1; i < MAX_DATA; i++) {
    dataRH[i - 1] = dataRH[i];
    dataThi[i - 1] = dataThi[i];
  }

  dataRH[MAX_DATA - 1] = (uint8_t) RH;
  dataThi[MAX_DATA - 1] = constrain(map((uint16_t) Thi * 10, 150, 550, 0, 100), 0, 100);    // From 15.0 to 55.0 deg C
}

void drawStatHistogramFramework() {
  tft.drawFastHLine(90, 217, 480, TFT_WHITE);
  tft.drawFastHLine(90, 319, 480, TFT_WHITE);

  // Draw 15-minute lines
  tft.setTextDatum(BC_DATUM);

  // Draw time codes on x-axis
  for (uint16_t i = 13; i > 0; i--) {
    tft.drawNumber(i * 15, 480 - i * 30, 216, 2);
  }

  tft.setFreeFont(FSS12);
  tft.setTextDatum(TL_DATUM);
}

void drawStatHistogram() {
  for (uint8_t i = 0; i < MAX_DATA; i++) {
    tft.fillRect(90 + i * 2, 218, 2, 318 - dataThi[i], TFT_BLACK);
    tft.fillRect(90 + i * 2, 318 - dataThi[i], 2, 318, temperatureColors2(dataThi[i]));
    tft.drawFastHLine(90 + i * 2, 318 - dataRH[i], 2, TFT_BLUE);
  }

  // Draw 15-minute lines
  for (uint16_t i = 90; i < 480; i += 30)
    tft.drawFastVLine(i, 218, 100, TFT_CYAN);

  // Draw warning line at 40 degrees
  tft.drawFastHLine(90, 256, 480, TFT_YELLOW);
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

int humidityColors(int RH) {
  if (RH > 60)
    return 0xF81F;      // Purple
  if (RH > 30)
    return 0x07E0;      // Green
  else
    return 0xF800;      // Red
}

/*
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
  //ledcSetup(0, 5000, 8);
  //ledcAttachPin(LCD_BL_PIN, 0);
  //ledcWrite(0, 128);                // Turn on the backlight
  digitalWrite(LCD_BL_PIN, HIGH);

  // Configure the LDR
  pinMode(LDR_PIN, ANALOG);
  analogReadResolution(12);         // 12 bits
  analogSetWidth(12);               // 12 bits
  analogSetPinAttenuation(LDR_PIN, ADC_6db);   // Maximum voltage of 1350mV

  // Initialize LCD
  tft.begin();
  tft.invertDisplay(0);
  tft.setRotation(3);
  //calibrateTouchscreen(false);
  tft.fillScreen(backcolor);
  tft.setTextColor(TFT_WHITE, backcolor);
  tft.setFreeFont(FSS12);
  tft.setTextSize(1);
  tft.setTextDatum(TL_DATUM);

  // Initialize sensor
  dht.begin();

  clearDataPoints();
  drawStatHistogramFramework();
  drawStatHistogram();

  delay(1000);
}

void loop() {
  // Adjust backlight from LDR readings
  //ledcWrite(0, constrain(map(analogRead(LDR_PIN), 0, 800, 255, 5), 5, 255));

  // Get DHT11 sensor values
  sensors_event_t event;

  dht.temperature().getEvent(&event);
  float temp = event.temperature;
  float temp2 = temp * temp;

  dht.humidity().getEvent(&event);
  float RH = event.relative_humidity;
  float RH2 = RH * RH;

  // Compute heat index temperature equivalent
  float Thi = c1 + c2 * temp + c3 * RH + c4 * temp * RH + c5 * temp2 + c6 * RH2 + c7 * temp2 * RH + c8 * temp * RH2 + c9 * temp2 * RH2;
  
  // Draw UI elements
  drawRingMeter(temp, 15,  55, 0,     0,   50,    "*C", temperatureColors(temp), TFT_GREY, TFT_WHITE, TFT_BLACK);
  drawRingMeter(RH,    0, 100, 0,   100,   50,   "%RH", humidityColors(RH), TFT_GREY, TFT_WHITE, TFT_BLACK);
  drawRingMeter(Thi,  15,  55, 160,   0,  100, "*C hi", temperatureColors(Thi), TFT_GREY, TFT_WHITE, TFT_BLACK);

  if (sumThi > 0.0)
    sumThi += Thi;
  else
    sumThi = Thi;

  if (sumRH > 0.0)
    sumRH += RH;
  else
    sumRH = RH;

  delay(1000);

  // Update every minute
  if (++counter >= 60) {
    saveDataPoints(sumRH / 60.0, sumThi / 60.0);
    sumRH = RH;
    sumThi = Thi;
    drawStatHistogram();
    counter = 0;
  }
}
