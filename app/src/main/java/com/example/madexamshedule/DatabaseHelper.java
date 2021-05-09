package com.example.madexamshedule;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "User.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "user_exam_schedule";

    //Add columns to the database table
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_COURSE = "course_name";
    private static final String COLUMN_DATE = "exam_date";
    private static final String COLUMN_START = "start_time";
    private static final String COLUMN_END = "end_time";
    private static final String COLUMN_VENUE = "exam_venue";


    DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create the SQL query
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_COURSE + " TEXT, " +
                        COLUMN_DATE + " TEXT, " +
                        COLUMN_START + " TEXT, " +
                        COLUMN_END + " TEXT, " +
                        COLUMN_VENUE + " TEXT);";

        //Execute the query
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addSchedule(String course, String date, String start, String end, String venue) {
        SQLiteDatabase db = this.getWritableDatabase();

        //To store all the data from the application and pass to the database table
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_COURSE, course);
        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_START, start);
        cv.put(COLUMN_END, end);
        cv.put(COLUMN_VENUE, venue);

        //To insert data to the database table
        long result = db.insert(TABLE_NAME, null, cv);

        if(result == -1){
            Toast.makeText(context, "Failed to add data", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(context, "Data added successfully", Toast.LENGTH_LONG).show();
        }
    }

    //To read all the data from the database table
    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        if(db != null) {
            cursor = db.rawQuery(query, null);
        }

        return cursor;
    }

    void updateDetails(String row_id, String course, String date, String start, String end, String venue) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_COURSE, course);
        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_START, start);
        cv.put(COLUMN_END, end);
        cv.put(COLUMN_VENUE, venue);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});

        if(result == -1) {
            Toast.makeText(context, "Failed to update the details", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context, "Successfully updated the details", Toast.LENGTH_LONG).show();
        }
    }

    void deleteOneRow(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});

        if(result == -1){
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context, "Schedule is successfully deleted", Toast.LENGTH_LONG).show();
        }
    }
}
