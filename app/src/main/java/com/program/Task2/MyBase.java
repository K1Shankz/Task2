package com.program.Task2;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyBase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "prog.db";

    public MyBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MyBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public MyBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL("CREATE TABLE USER_Settings   (_id INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                "COLUMN_NAME TEXT, COLUMN_ID TEXT, COLUMN_GENDER TEXT, COLUMN_MAIL TEXT, COLUMN_COMMENT TEXT);");

        sqLiteDatabase.execSQL("CREATE TABLE USER_ACTIVIVTY (_id INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                "C_TITLE TEXT, C_DATE TEXT, C_TYPE TEXT, C_PLACE TEXT, C_DURATION TEXT, C_PHOTO TEXT, C_COMMENT TEXT, C_GPS TEXT);");
        ContentValues newValues = new ContentValues();
        newValues.put("COLUMN_NAME", "John Smit");
        newValues.put("COLUMN_ID", "js");
        newValues.put("COLUMN_GENDER", "Male");
        newValues.put("COLUMN_MAIL", "test@test.com");
        newValues.put("COLUMN_COMMENT", "This is a comment");

        sqLiteDatabase.insert("USER_Settings", null, newValues);
        //basic data
        newValues = new ContentValues();
        newValues.put("C_TITLE", "First step");
        newValues.put("C_DATE", "0");
        newValues.put("C_TYPE", "WORK");
        newValues.put("C_PLACE", "0,0");
        newValues.put("C_DURATION", "90");
        newValues.put("C_PHOTO", "path/to/file");
        newValues.put("C_COMMENT", "This is a comment first!");
        newValues.put("C_GPS", "This is a comment");
        sqLiteDatabase.insert("USER_ACTIVIVTY", null, newValues);
        newValues = new ContentValues();
        newValues.put("C_TITLE", "Second step");
        newValues.put("C_DATE", "8");
        newValues.put("C_TYPE", "STUDY");
        newValues.put("C_PLACE", "1,1");
        newValues.put("C_DURATION", "50");
        newValues.put("C_PHOTO", "path/to/file2");
        newValues.put("C_COMMENT", "This is a comment second!");
        newValues.put("C_GPS", "This is a comment");
        sqLiteDatabase.insert("USER_ACTIVIVTY", null, newValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//do nothing
    }
}
