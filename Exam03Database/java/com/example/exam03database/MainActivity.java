package com.example.exam03database;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText etname, etid;
    CalendarView etdob;
    ListView lv;
    ArrayAdapter<String> adap_lv;
    ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        etname = findViewById(R.id.etname);
        etdob = findViewById(R.id.calendarView);
        etid = findViewById(R.id.etid);
        lv = findViewById(R.id.lv);
    }
    public void get(View v) {
        Cursor c = db.getData();
        int count = 0;
        data.clear();
        while(c.moveToNext()) {
            String s = "";
            s += "ID: " + c.getInt(0) + "   ";
            s += ("Name: " + c.getString(1) + "   ");
            s += ("DOB: " + c.getString(2) + "\n");
            data.add(s);
        }
        adap_lv = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, data);

        lv.setAdapter(adap_lv);
    }

    public void ins(View v) {
        String n = etname.getText().toString();
        long date = etdob.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyy", Locale.getDefault());
        String d = String.valueOf(sdf.format(new Date(date)));
        db.insertData(n, d);
    }

    public void upd(View v) {
        String i = etid.getText().toString();
        String n = etname.getText().toString();
        long date = etdob.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy", Locale.getDefault());
        String d = sdf.format(new Date(date));
        db.updateData(i, n, d);
    }

    public void del(View v) {
        String i = etid.getText().toString();
        db.deleteData(i);
    }
}