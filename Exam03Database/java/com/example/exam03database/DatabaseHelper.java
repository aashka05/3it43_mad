package com.example.exam03database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context c) {
        super(c, "student", null, 1);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE data (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, dob DATETIME)");
    }
    public void onUpgrade(SQLiteDatabase db, int oldv, int newv) {
        db.execSQL("DROP TABLE IF EXISTS data");
    }
    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM data", null);
    }

    public long insertData(String name, String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("dob", dob);
        return db.insert("data", null, cv);
    }

    public int updateData(String id, String name, String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("dob", dob);
        return db.update("data", cv, "id=?", new String[] {id});
    }

    public int deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("data", "id=?", new String[]{id});
    }
}
