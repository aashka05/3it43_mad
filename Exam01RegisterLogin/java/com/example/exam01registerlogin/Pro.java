package com.example.exam01registerlogin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Pro extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView tv = findViewById(R.id.tv);
        SharedPreferences pref = getSharedPreferences("com.android.app.users", MODE_PRIVATE);
        tv.setText("Hello " + pref.getString("uname", null));
    }
}
