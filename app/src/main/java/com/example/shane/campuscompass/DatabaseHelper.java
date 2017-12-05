package com.example.shane.campuscompass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Zach on 11/10/2017.
 */
//Comment to send to GIT
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "Homework_Table";
    private static final String COL1 = "ID";
    private static final String COL2 = "Course";
    private static final String COL3 = "Assignment";
    private static final String COL4 = "DueDate";

    public DatabaseHelper(Context context){
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

    public boolean addData(String course, String assignment, String dueDate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,course);
        contentValues.put(COL3,assignment);
        contentValues.put(COL4,dueDate);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT " + COL2 + ", " + COL3 + ", " + COL4 + " FROM " + TABLE_NAME, null);
        return data;
    }
}
