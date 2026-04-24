package com.example.a02_5_broadcastreciever;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainReceiver r = new MainReceiver();
        registerReceiver(r, new android.content.IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
    }
}