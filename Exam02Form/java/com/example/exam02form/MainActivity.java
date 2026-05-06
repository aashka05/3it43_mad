package com.example.exam02form;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etname, etemail, etphone;
    CheckBox checkBox, checkBox2;
    RadioGroup radioGroup;
    RadioButton radioButton, radioButton2;
    ToggleButton toggleButton;
    Spinner spinner;
    String[] data = {"math", "sci", "eng"};
    ArrayAdapter<String> adap_sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname = findViewById(R.id.etname);
        etemail = findViewById(R.id.etemail);
        etphone = findViewById(R.id.etphone);
        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        toggleButton = findViewById(R.id.toggleButton);
        adap_sp = new ArrayAdapter<> (this, android.R.layout.simple_spinner_item, data);
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adap_sp);
    }
    public void submit(View v) {
        Intent i = new Intent(this, Result.class);
        i.putExtra("name", etname.getText().toString());
        i.putExtra("email", etemail.getText().toString());
        i.putExtra("phone", etphone.getText().toString());

        i.putExtra("cb1", checkBox.isChecked());
        i.putExtra("cb2", checkBox2.isChecked());

        String g = "";
        int selected = radioGroup.getCheckedRadioButtonId();
        if(selected != -1) {
            RadioButton rb = findViewById(selected);
            g = rb.getText().toString();
        }
        i.putExtra("gender", g);

        i.putExtra("toggle", toggleButton.isChecked());

        i.putExtra("spinner", spinner.getSelectedItem().toString());

        startActivity(i);
    }
}