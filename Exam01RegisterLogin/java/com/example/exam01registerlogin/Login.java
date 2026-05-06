package com.example.exam01registerlogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText etuname, etpwd;
    TextView tv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etuname = findViewById(R.id.etuname);
        etpwd = findViewById(R.id.etpwd);
        tv = findViewById(R.id.tv);
    }
    public void submit(View v) {
        SharedPreferences pref = getSharedPreferences("com.android.app.users", MODE_PRIVATE);
        String uname = pref.getString("uname", null);
        String pwd = pref.getString("pwd", null);
        tv.setText(uname + " " + pwd);
        if((etuname.getText().toString()).equals(uname)) {
            if(etpwd.getText().toString().equals(pwd)) {
                Intent i = new Intent(this, Pro.class);
                startActivity(i);
            } else {
                Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Wrong username", Toast.LENGTH_SHORT).show();
        }
    }

}
