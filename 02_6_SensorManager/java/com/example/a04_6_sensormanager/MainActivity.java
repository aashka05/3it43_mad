package com.example.a04_6_sensormanager;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    Sensor light;
    TextView tvd, tvl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvd = findViewById(R.id.tvdata);
        tvl = findViewById(R.id.tvlist);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        light = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(light != null) {
            sm.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            tvl.setText("No light sensor");
        }
        List<Sensor> list = sm.getSensorList(Sensor.TYPE_ALL);
        String l = "";
        for(Sensor sensor: list) {
            l += (sensor.getName() + "\n");
        }
        tvl.setText(l);
    }
    public void onSensorChanged(SensorEvent se) {
        if (se.sensor.getType() == Sensor.TYPE_LIGHT) {
            tvd.setText("Light: " + se.values[0] + "lux");
        }
    }
    public void onAccuracyChanged(Sensor s, int a) {}
    public void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }
    protected void onResume() {
        super.onResume();
        if(light != null)
            sm.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL);
    }
}