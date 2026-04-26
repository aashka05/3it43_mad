package com.example.a06_1_bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    BluetoothAdapter BA;
    Set<BluetoothDevice> paired;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BA = BluetoothAdapter.getDefaultAdapter();
        lv = findViewById(R.id.lv);
        if (BA == null) {
            Toast.makeText(this, "Bluetooth not supported", Toast.LENGTH_SHORT).show();
        }
    }

    public void onB(View v) {
        if(!BA.isEnabled()) {
            try {
                startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), 0);
            } catch (SecurityException e) {
                throw new RuntimeException(e);
            }
            Toast.makeText(this, "Bluetooth on", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Already on", Toast.LENGTH_SHORT).show();
        }
    }
    public void visibleB(View v) {
        try {
            startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE), 0);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        }
    }
    public void listB(View v) {
        if (checkSelfPermission(android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.BLUETOOTH_CONNECT}, 1);
            return;
        }
        paired = BA.getBondedDevices();
        ArrayList<String> l = new ArrayList<>();
        for (BluetoothDevice b : paired) {
            l.add(b.getName());
        }
        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, l));
    }
    public void offB(View v) {
        if (checkSelfPermission(android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.BLUETOOTH_CONNECT}, 1);
            return;
        }
        BA.disable();
        Toast.makeText(this, "Bluetooth off", Toast.LENGTH_SHORT).show();
    }
}