// Assumes you have a global TFT_eSPI instance named tft

int drawRingMeter(int value, int vMin, int vMax, int x, int y, int r, const char *units, int graphColor, int graphColor2, int textColor, int backColor) {
  // Position X and Y to center of meter
  x += r;
  y += r;

  // Convert value into a string
  char buf[15];
  byte len = value > 999 ? 5 : 3;
  
  dtostrf(value, len, 0, buf);
  buf[len] = ' ';
  buf[len + 1] = 0; // Null-terminate string

  // Print meter value, allow for 3 digits
  tft.setTextSize(1);
  tft.setTextColor(textColor, backColor);
  tft.setTextDatum(MC_DATUM);
  
  if (r > 84) {   // Large meter: 31 pixels per digit at Font 6
    tft.setTextPadding(93);
    tft.drawString(buf, x, y, 6);
  }
  else {          // Smaller meter: 14 pixels per digit at Font 4
    tft.setTextPadding(42);
    tft.drawString(buf, x, y, 4);
  }

  // Print meter units
  tft.setTextSize(1);
  tft.setTextPadding(0);
  tft.setTextColor(textColor, backColor);
  if (r > 84)     // Large meter: use Font 4
    tft.drawString(units, x, y + 45, 4); 
  else            // Small meter: use Font 2
    tft.drawString(units, x, y + 15, 2);

  // Draw the ring
  int vAngle = 330;

  if (vAngle != 330)
    tft.drawSmoothArc(x, y, r - 2, r * 0.75, vAngle, 330, graphColor2, backColor);
  
  if (vAngle != 30)
    tft.drawSmoothArc(x, y, r - 2, r * 0.75, 30, vAngle, graphColor, backColor);

  return x + r;
}