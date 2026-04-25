package com.example.a03_2_menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView text = findViewById(R.id.tv);
        registerForContextMenu(text);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.edit) {
            Toast.makeText(this, "Edit", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.delete) {
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }
    public void firstAct(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void thirdAct(View v) {
        Intent i = new Intent(this, ThirdActivity.class);
        startActivity(i);
    }
}
