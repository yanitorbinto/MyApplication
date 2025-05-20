package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Sqlite extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TuDinhNghia.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "TuDinhNghia";
    private SQLiteDatabase db;

    public Sqlite(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Sqlite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = " CREATE TABLE " + TABLE_NAME;
        db.execSQL(createTable);
    }

    public void openDatabase() {
        if(db == null || !db.isOpen()) {
            db = this.getWritableDatabase();
        }
    }

    public void closeDatabase() {
        if(db != null && db.isOpen()) {
            db.close();
        }
    }

    public SQLiteDatabase getDatabase() {
        return db;
    }

    public void insertData(Object data) {
        // Implement your insert logic here
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // Assuming data is a String for simplicity
        // Replace with actual data handling
        values.put("column_name", data.toString());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void updateData(Object data) {
        // Implement your update logic here
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // Assuming data is a String for simplicity
        // Replace with actual data handling
        values.put("column_name", data.toString());
        db.update(TABLE_NAME, values, "column_name = ?", new String[]{data.toString()});
        db.close();
    }

    public void deleteData(Object data) {
        // Implement your delete logic here
        db = this.getWritableDatabase();
        // Assuming data is a String for simplicity
        // Replace with actual data handling
        db.delete(TABLE_NAME, "column_name = ?", new String[]{data.toString()});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
