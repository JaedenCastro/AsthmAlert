package com.google.appinventor.components.runtime.util;

public enum FileAccessMode {
    READ("android.permission.READ_EXTERNAL_STORAGE"),
    WRITE("android.permission.WRITE_EXTERNAL_STORAGE"),
    APPEND("android.permission.WRITE_EXTERNAL_STORAGE");
    
    private final String GqEao9b9YWjqJfm0U8G9R1Onjg5BiUMTCoMqRIVO602C1plqYKUzgjm5B5hvlTms;

    private FileAccessMode(String str) {
        this.GqEao9b9YWjqJfm0U8G9R1Onjg5BiUMTCoMqRIVO602C1plqYKUzgjm5B5hvlTms = str;
    }

    public final String getPermission() {
        return this.GqEao9b9YWjqJfm0U8G9R1Onjg5BiUMTCoMqRIVO602C1plqYKUzgjm5B5hvlTms;
    }
}
