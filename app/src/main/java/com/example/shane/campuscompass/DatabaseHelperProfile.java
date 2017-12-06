package com.example.shane.campuscompass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andrew
 */
public class DatabaseHelperProfile extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelperProfile";
    private static final String TABLE_NAME = "profile_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "name";
    private static final String COL3 = "major";
    private static final String COL4 = "email";

    public DatabaseHelperProfile(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "Create TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT, " + COL3 +" TEXT, " + COL4 +" TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String upgrade = "DROP IF TABLE EXISTS "  + TABLE_NAME;
        db.execSQL(upgrade);
        onCreate(db);
    }

    public boolean addData(String name, String major, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, major);
        contentValues.put(COL4, email);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void delete() {
        SQLiteDatabase db = this.getWritableDatabase();
        String delete = "DELETE * FROM " + TABLE_NAME;
        db.execSQL(delete);
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT " + COL2 + ", " + COL3 + ", " + COL4 + " FROM " + TABLE_NAME, null);
        return data;
    }
}
