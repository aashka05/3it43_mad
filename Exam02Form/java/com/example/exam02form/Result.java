package com.example.exam02form;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    TextView tv;
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_result);
        tv = findViewById(R.id.tv);
        String result = "";
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String email = i.getStringExtra("email");
        String phone = i.getStringExtra("phone");

        boolean cb1 = i.getBooleanExtra("cb1", false);
        boolean cb2 = i.getBooleanExtra("cb2", false);
        if(cb1) {
            result += "Sing ";
        }
        if(cb2) {
            result += "Dance";
        }

        String gender = i.getStringExtra("gender");
        result += ("\n" + gender);

        boolean toggle = i.getBooleanExtra("toggle", false);
        if(toggle) {
            result += "\ninterested";
        } else {
            result += "\nuninterested";
        }
        String spinner = i.getStringExtra("spinner");
        result += ("Spinner: " + spinner);

        tv.setText("Name: " + name + "\n" + email + "\n" + phone + "\n" + result);
    }
}
