package com.example.a03_1_picker;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import com.hbb20.CountryCodePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    TimePicker timePicker;
    NumberPicker numberPicker;
    Calendar calendar;
    DatePickerDialog dialog;
    int dby, dbm, dbd;
    CountryCodePicker ccp;
    String cn, cc, pc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);
        ccp = findViewById(R.id.countryCodePicker);
    }
    public void clickCalendar(View v) {
        calendar = Calendar.getInstance();
        dialog = new DatePickerDialog(
                this,
                (view, year, month, day) -> {
                    dby = year;
                    dbm = month + 1;
                    dbd = day;
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        dialog.show();
    }
    public void display(View v) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();
        int value = numberPicker.getValue();
        cn = ccp.getSelectedCountryName();   // India
        cc = ccp.getSelectedCountryNameCode(); // IN
        pc = ccp.getSelectedCountryCode(); // 91
        TextView tv = findViewById(R.id.tv);
        String dpop = day + "-" + month + "-" + year;
        String tpop = hour + ":" + minute;
        String npop = String.valueOf(value);
        String dpdop = dbd + "-" + dbm + "-" + dby;
        String cpop = cn + ", " + cc  + ", " + pc;
        String result = dpop + "\n" + tpop + "\n" + npop + "\n" + dpdop + "\n" + cpop;
        tv.setText(result);
    }
}