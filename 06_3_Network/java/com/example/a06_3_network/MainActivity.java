package com.example.a06_3_network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ConnectivityManager cm;
    NetworkInfo ni;
    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        ni = cm.getActiveNetworkInfo();
        et = findViewById(R.id.et);
        tv = findViewById(R.id.tv);

    }
    public void getH(View v) {
        try {
            if(ni != null && ni.isConnected()) {
                String link = et.getText().toString();
                URL u = new URL(link);
                HttpURLConnection conn = (HttpURLConnection)u.openConnection();
                conn.connect();
                InputStream is = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line, result="";
                while((line = br.readLine()) != null) {
                    result += line;
                }
                tv.setText(result);
            }
        } catch (IOException e) {
            tv.setText(e.toString());
        }
    }
}