#include "BluetoothSerial.h"

#if !defined(CONFIG_BT_ENABLED) || !defined(CONFIG_BLUEDROID_ENABLED)
#error Bluetooth is not enabled! Please run `make menuconfig` to and enable it
#endif

BluetoothSerial SerialBT;

String aqi = "1";

void setup() {
  Serial.begin(115200);
  SerialBT.begin("AsthmAlert"); //Bluetooth device name
  Serial.println("AsthmAlert is now active!");
}

void loop() {
  if (Serial.available()) {
    aqi = Serial.readString();
  }
  aqi.trim();
  Serial.print(aqi);
  Serial.print("|");
  Serial.println("0,0,0,0,0,0,0,0,0");

  SerialBT.print(aqi);
  SerialBT.print("|");
  SerialBT.println("0,0,0,0,0,0,0,0,0");
  delay(1000);
}