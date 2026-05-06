package com.example.exam01registerlogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etuname, etpwd;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etuname = findViewById(R.id.etuname);
        etpwd = findViewById(R.id.etpwd);
        tv = findViewById(R.id.tv);
    }
    public void register(View v) {
        SharedPreferences pref = getSharedPreferences("com.android.app.users", MODE_PRIVATE);
        SharedPreferences.Editor e = pref.edit();
        e.putString("uname", etuname.getText().toString());
        e.putString("pwd", etpwd.getText().toString());
        e.apply();
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }
}