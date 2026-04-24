package com.example.a02_4_contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

public class MainContentProvider extends ContentProvider {
    public static final String AUTHORITY = "com.example.a02_4_contentprovider.provider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/student");
    SQLiteDatabase db;
    static final int STUDENTS = 1;
    static final UriMatcher um = new UriMatcher(UriMatcher.NO_MATCH);
    static {um.addURI(AUTHORITY, "student", STUDENTS);}
    @Override
    public boolean onCreate() {
        DBHelper helper = new DBHelper(getContext());
        db = helper.getWritableDatabase();
        return (db != null);
    }
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return db.query("student", projection, selection, selectionArgs, null, null, sortOrder);
    }

    public Uri insert(Uri uri, ContentValues cv) {
        long id = db.insert("student", null, cv);
        return Uri.parse("content://" + AUTHORITY + "student" + id);
    }

    public int update(Uri uri, ContentValues cv, String selection, String[] selectionArgs) {
        return db.update("student", cv, selection, selectionArgs);
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return db.delete("student", selection, selectionArgs);
    }

    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/vnd.example.student";
    }

}