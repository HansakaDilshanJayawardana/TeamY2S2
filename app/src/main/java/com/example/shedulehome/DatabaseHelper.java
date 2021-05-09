package com.example.shedulehome;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.format.Time;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class  DatabaseHelper extends SQLiteOpenHelper {


   public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="SmartShedule.db";
   public static final String TABLE_NAME="shedule";

    //table columns
    public static final String mcode="mcode";
    public static final String mname="mname";
    public static final String mday="mday";
    public static final String mfrom="mfrom";
    public static final String mto="mto";
    public static  final String mclasroom="mclasroom";



    //creating constructor
    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    //crewating database table
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE=" create table "+ TABLE_NAME +"("+ mcode +" STRING PRIMARY KEY ,"
                + mname +" TEXT NOT NULL,"+ mday +" TEXT NOT NULL," +
                ""+ mfrom +" TEXT NOT NULL,"+ mto +" TEXT  NOT NULL,"+ mclasroom +" TEXT NOT NULL);";
        db.execSQL(CREATE_TABLE);
        //create table
        //String createTable="create table"+TABLE_NAME+"(mcode STRING PRIMARY KEY,mname STRING,day STRING,day STRING,shfrom DATETIME,shto DATETIME,cls STRING)";
        //db.execSQL(createTable);
        //db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop tabels if there any
        db.execSQL(" DROP TABLE IF EXISTS "+ TABLE_NAME );
        onCreate(db);
    }

    //adding shedule details to the database
    public void addShedule(Shedule shedule2){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("mcode",shedule2.getMcode());
        contentValues.put("mname",shedule2.getName());
        contentValues.put("mday",shedule2.getDay());
        contentValues.put("mfrom",shedule2.getFrm());
        contentValues.put("mto",shedule2.getTo());
        contentValues.put("mclasroom",shedule2.getClasrom());

        //save data to db
        sqLiteDatabase.insert(" shedule ",null,contentValues);
        sqLiteDatabase.close();

    }
    //get user added shedule count
    public int countShedule(){
        SQLiteDatabase db=getReadableDatabase();
        String query=" SELECT  * FROM  "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        return cursor.getCount();
    }






    public Shedule getSingleShedule(String mCode){
        SQLiteDatabase db=getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{mCode,mname,mday,mfrom,mto,mclasroom},
                mcode + "= ?",new String[]{String.valueOf(mCode)}
                ,null,null,null);

        Shedule shedule;
        if(cursor != null) {
            cursor.moveToFirst();
            shedule = new Shedule(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
            );
            return shedule;
        }
        return  null;
    }
    public int updateSingleShedule(Shedule shedule) {
        SQLiteDatabase db=getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put(mcode,shedule.getMcode());
        contentValues.put(mname,shedule.getName());
        contentValues.put(mday,shedule.getDay());
        contentValues.put(mfrom,shedule.getFrm());
        contentValues.put(mto,shedule.getTo());
        contentValues.put(mclasroom,shedule.getClasrom());

        int status=db.update(TABLE_NAME,contentValues,mcode+"=?",
                new String[]{String.valueOf(shedule.getMcode())});
        db.close();;
        return status;
    }

    //get all shedules
    public List<Shedule>getAllshedules(){

        List<Shedule>shedules=new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {
                Shedule shedule=new Shedule();
                shedule.setMcode(cursor.getString(0));
                shedule.setName(cursor.getString(1));
                shedule.setDay(cursor.getString(2));
                shedule.setFrm(cursor.getString(3));
                shedule.setTo(cursor.getString(4));
                shedule.setClasrom(cursor.getString(5));

                shedules.add(shedule);
            }while (cursor.moveToNext());
    }
        return shedules;
    }



    public void deleteShedule(String mcode) {
        SQLiteDatabase db=getWritableDatabase();
        db.delete(TABLE_NAME,"mcode=? ",new String[]{String.valueOf(mcode)});
        db.close();
    }
}


