package com.example.shane.campuscompass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Shane on 12/5/2017.
 */

public class CoursesDatabase extends SQLiteOpenHelper{

    private static final String TABLE_NAME = "New_Courses_Table";
    private static final String COL1 = "ID";
    private static final String COL2 = "Course";
    private static final String COL3 = "StartTime";
    private static final String COL4 = "EndTime" ;
    private static final String COL5 = "Location";
    private static final String COL6 = "DayofWeek";

    public CoursesDatabase(Context context) {
        super(context, TABLE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT, " + COL3 +" TEXT, "+ COL4 +" TEXT, " + COL5 +" TEXT, "+ COL6 +" TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String upgrade = "DROP IF TABLE EXISTS "  + TABLE_NAME;
        db.execSQL(upgrade);
        onCreate(db);
    }

    public boolean addData(String course, String stime,String etime, String location, String DoW) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,course);
        contentValues.put(COL3,stime);//start time
        contentValues.put(COL4,etime);//end time
        contentValues.put(COL5,location);
        contentValues.put(COL6,DoW);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT " + COL2 + ", " + COL3 + ", " + COL4 + ", " + COL5 + ", "+ COL6 +  " FROM " + TABLE_NAME, null);

        return data;
    }

}
