package com.example.semester_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "healthcare";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsersTable = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_USERNAME + " TEXT PRIMARY KEY, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_PASSWORD + " TEXT)";
        db.execSQL(createUsersTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public void register(String username, String email, String password) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASSWORD, password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    public boolean login(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {COLUMN_USERNAME};
        String selection = COLUMN_USERNAME + "=? AND " + COLUMN_PASSWORD + "=?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionArgs, null, null, null);
        boolean loggedIn = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return loggedIn;
    }
    /////
    ///

}