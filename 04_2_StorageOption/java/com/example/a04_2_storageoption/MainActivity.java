package com.example.a04_2_storageoption;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    String FN = "file.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.et);
        tv = findViewById(R.id.tv);
    }

    public void sfsave(View v) {
        SharedPreferences pref = getSharedPreferences("com.android.app.users", MODE_PRIVATE);
        SharedPreferences.Editor e = pref.edit();
        e.putString("name", et.getText().toString());
        e.apply();
    }
    public void sfload(View v) {
        SharedPreferences pref = getSharedPreferences("com.android.app.users", MODE_PRIVATE);
        String n = pref.getString("name", "No data");
        tv.setText("Shared Preference: " + n);
    }
    public void issave(View v) {
        try {
            FileOutputStream fos = openFileOutput(FN, MODE_PRIVATE);
            fos.write(et.getText().toString().getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void isload(View v) {
        try {
            FileInputStream fis = openFileInput(FN);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line, result = "";
            while((line = br.readLine()) != null) {
                result += (line);
            }
            tv.setText("Internal Storage: " + result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void essave(View v) {
        try {
            File f = new File(getExternalFilesDir(null), FN);
            FileWriter fw = new FileWriter(f);
            fw.write(et.getText().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void esload(View v) {
        try {
            File f = new File(getExternalFilesDir(null), FN);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line, result = "";
            while((line = br.readLine()) != null) {
                result += (line);
            }
            tv.setText("External Storage: " + result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}