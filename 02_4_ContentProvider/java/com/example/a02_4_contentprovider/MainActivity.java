package com.example.a02_4_contentprovider;

import android.content.ContentValues;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        ContentValues v = new ContentValues();
        v.put("name", "Aashka");
        getContentResolver().insert(MainContentProvider.CONTENT_URI, v);
    }
}
