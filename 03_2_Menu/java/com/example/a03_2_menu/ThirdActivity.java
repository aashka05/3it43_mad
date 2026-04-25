package com.example.a03_2_menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class ThirdActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }
    public void firstAct(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void secondAct(View v) {
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }
    public void popup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.setting) {
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId() == R.id.about) {
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });
        popup.show();
    }
}
