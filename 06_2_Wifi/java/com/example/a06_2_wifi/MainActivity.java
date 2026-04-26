package com.example.a06_2_wifi;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    WifiManager wm;
    WifiScanReceiver wsr;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        wm = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wsr = new WifiScanReceiver();
        registerReceiver(wsr, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
    }
    public void onW(View v) {
        wm.setWifiEnabled(true);
        Toast.makeText(this, "Wifi on", Toast.LENGTH_SHORT).show();
    }
    public void offW(View v) {
        wm.setWifiEnabled(false);
        Toast.makeText(this, "Wifi off", Toast.LENGTH_SHORT).show();
    }
    public void scanW(View v) {
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return;
        }
        try {
            wm.startScan();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
    public class WifiScanReceiver extends BroadcastReceiver {
        public void onReceive(Context c, Intent i) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                return;
            }
            List<ScanResult> wifis = wm.getScanResults();
            ArrayList<String> l = new ArrayList<>();
            for(ScanResult wifi:wifis) {
                l.add(wifi.SSID + "  " + wifi.level + "\n");
            }
            lv.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, l));
        }
    }
    protected void onPause() {
        super.onPause();
        unregisterReceiver(wsr);
    }
}
