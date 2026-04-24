package com.example.a02_3_service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startServ(View v) {
        Intent i = new Intent(this, MusicService.class);
        startService(i);
    }

    public void stopServ(View v) {
        Intent i = new Intent(this, MusicService.class);
        stopService(i);
    }
}