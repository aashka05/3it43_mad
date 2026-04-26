package com.example.a05_1_sqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etName, etID;
    TextView tv;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etID = findViewById(R.id.etID);
        etName = findViewById(R.id.etName);
        tv = findViewById(R.id.tv);
        db = new DatabaseHelper(this);
    }
    public void sel(View v) {
        Cursor c = db.getStudent();
        String s = "";
        while(c.moveToNext()) {
            s += ("ID: " + c.getInt(0) + "   ");
            s += ("Name: " + c.getString(1) + "\n");
        }
        tv.setText(s);
    }
    public void ins(View v) {
        String n = etName.getText().toString();
        long result = db.insertStudent(n);
    }
    public void upd(View v) {
        String id = etID.getText().toString();
        String name = etName.getText().toString();
        int result = db.updateStudent(id, name);
    }
    public void del(View v) {
        String id = etID.getText().toString();
        int result = db.deleteStudent(id);
    }
}