package com.example.a02_2_explicitintent;

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

    public void act2(View v) {
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(i);
    }
}