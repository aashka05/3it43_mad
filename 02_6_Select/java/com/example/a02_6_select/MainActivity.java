package com.example.a02_6_select;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import android.view.View;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    CheckBox cb1, cb2;
    RadioGroup rg;
    Switch sw;
    ToggleButton tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        cb1 = findViewById(R.id.o1);
        cb2 = findViewById(R.id.o2);
        rg = findViewById(R.id.rg);
        sw = findViewById(R.id.sw);
        tb = findViewById(R.id.tb);
    }
    public void display(View v) {
        String result = "";
        if(cb1.isChecked()) {
            result += "Option1\n";
        }
        if (cb2.isChecked()) {
            result += "Option2\n";
        }
        int x = rg.getCheckedRadioButtonId();
        if (x != -1) {
            RadioButton rb = findViewById(x);
            result += (rb.getText() + "\n");
        }
        result += ((sw.isChecked() ? 1 : 0) + "\n");
        result += ((tb.isChecked() ? "ON" : "OFF") + "\n");

        tv.setText(result);
    }
}