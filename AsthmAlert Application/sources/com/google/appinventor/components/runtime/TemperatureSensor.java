package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;

@SimpleObject
@DesignerComponent(category = ComponentCategory.SENSORS, description = "<p>Non-visible component that measures the temperature of the air in the room in degrees Celsius. This sensor implementation varies across devices.</p>", iconName = "images/temperatureSensor.png", nonVisible = true, version = 1)
public class TemperatureSensor extends AndroidNonvisibleComponent implements SensorEventListener, Component, OnDestroyListener, OnPauseListener, OnResumeListener {
    private final Activity activity;
    private ComponentContainer container;
    private Context context;
    private boolean enabled;
    private float hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = 0.0f;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private final SensorManager f259hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private int ihRLpfoglw4vpN1eVLFIksSKviBvteBH3bd3uSRN7VsdBdKQo5NWEdm996sfoJhJ = 13;
    private final Sensor sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt;
    private boolean vOibdtOfNxMVixWab9VDGgvD9L4Kqb2ZDQBius3PMdhiP1dPN68Z9GzWJA49TUbE;

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public TemperatureSensor(ComponentContainer componentContainer) {
        super(componentContainer.$form());
        this.form.registerForOnPause(this);
        this.form.registerForOnResume(this);
        this.form.registerForOnDestroy(this);
        this.container = componentContainer;
        this.context = componentContainer.$context();
        this.activity = componentContainer.$context();
        SensorManager sensorManager = (SensorManager) this.context.getSystemService("sensor");
        this.f259hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = sensorManager;
        this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt = sensorManager.getDefaultSensor(this.ihRLpfoglw4vpN1eVLFIksSKviBvteBH3bd3uSRN7VsdBdKQo5NWEdm996sfoJhJ);
        startListening();
        Enabled(true);
        Log.d("TemperatureSensor", "Temperature Sensor Created");
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether Sensor is Available")
    public boolean Available() {
        return this.f259hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getSensorList(this.ihRLpfoglw4vpN1eVLFIksSKviBvteBH3bd3uSRN7VsdBdKQo5NWEdm996sfoJhJ).size() > 0;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public boolean Enabled() {
        return this.enabled;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether Sensor should be Enabled")
    public void Enabled(boolean z) {
        if (this.enabled != z) {
            this.enabled = z;
            if (z) {
                startListening();
            } else {
                stopListening();
            }
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns the temperature in degrees celsius. To return values the sensor must be enabled")
    public float Temperature() {
        return this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    }

    @SimpleEvent(description = "Event that fires when the temperature is changed")
    public void TemperatureChanged(float f) {
        EventDispatcher.dispatchEvent(this, "TemperatureChanged", Float.valueOf(f));
    }

    private void startListening() {
        SensorManager sensorManager;
        Sensor sensor;
        if (!this.vOibdtOfNxMVixWab9VDGgvD9L4Kqb2ZDQBius3PMdhiP1dPN68Z9GzWJA49TUbE && (sensorManager = this.f259hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) != null && (sensor = this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt) != null) {
            sensorManager.registerListener(this, sensor, 3);
            this.vOibdtOfNxMVixWab9VDGgvD9L4Kqb2ZDQBius3PMdhiP1dPN68Z9GzWJA49TUbE = true;
        }
    }

    private void stopListening() {
        SensorManager sensorManager;
        if (this.vOibdtOfNxMVixWab9VDGgvD9L4Kqb2ZDQBius3PMdhiP1dPN68Z9GzWJA49TUbE && (sensorManager = this.f259hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) != null) {
            sensorManager.unregisterListener(this);
            this.vOibdtOfNxMVixWab9VDGgvD9L4Kqb2ZDQBius3PMdhiP1dPN68Z9GzWJA49TUbE = false;
        }
    }

    public void onResume() {
        Log.d("TemperatureSensor", "onResume");
        if (this.enabled) {
            startListening();
        }
    }

    public void onPause() {
        Log.d("TemperatureSensor", "onPause");
        stopListening();
    }

    public void onDestroy() {
        Log.d("TemperatureSensor", "onDestroy");
        stopListening();
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        synchronized (this) {
            if (sensorEvent.sensor.getType() == this.ihRLpfoglw4vpN1eVLFIksSKviBvteBH3bd3uSRN7VsdBdKQo5NWEdm996sfoJhJ) {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = sensorEvent.values[0];
            }
        }
        TemperatureChanged(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
    }
}
