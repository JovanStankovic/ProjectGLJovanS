package com.example.projectgljovans;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "Login.db";

    private static final String TABLE_NAME = "user";

    private static final String COLUMN_USERNAME = "userName";
    private static final String COLUMN_PASSWORD = "password";

    SQLiteDatabase database;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TABLE_NAME+" ( "+COLUMN_USERNAME+" TEXT PRIMARY KEY, "+ COLUMN_PASSWORD +" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean checkUserNamePass(String userName,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where userName=? and password=?",new String[]{userName,password});
        if(cursor.getCount()>0) return true;
        else return false;
    }

    public boolean insertData(){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME,"donka");
        contentValues.put(COLUMN_PASSWORD,"321");
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == 1)
            return false;
            else return true;
    }
    public boolean insertData1(){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME,"jovan");
        contentValues.put(COLUMN_PASSWORD,"123");
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == 1)
            return false;
        else return true;
    }
    public boolean insertData2(){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME,"admin");
        contentValues.put(COLUMN_PASSWORD,"admin");
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == 1)
            return false;
        else return true;
    }
}
