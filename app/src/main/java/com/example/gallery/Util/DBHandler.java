package com.example.gallery.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.gallery.Modeldata.ModelArtist;
import com.example.gallery.Modeldata.ModelUser;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "ARTGALLERY";
    public static final int DB_VERSION = 1;

    //Inserting Artist details
    public static final String ARTIST_TABLE = "ARTIST";
    public static final String A_ID = "ID";
    public static final String A_NAME = "NAME";
    public static final String A_PHONENUMBER = "PHONENO";
    public static final String A_ADDRESS = "ADDRESS";
    public static final String A_EMAIL = "EMAIL";
    public static final String A_PSW = "PSW";
    public static final String A_GENDER = "GENDER";

    //Inserting User details
    public static final String USER_TABLE = "USER";
    public static final String U_ID = "ID";
    public static final String U_NAME = "NAME";
    public static final String U_PHONENUMBER = "PHONENO";
    public static final String U_ADDRESS = "ADDRESS";
    public static final String U_EMAIL = "EMAIL";
    public static final String U_PSW = "PSW";
    public static final String U_GENDER = "GENDER";


    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Creating table for artist
        String createtableartist= "CREATE TABLE " + ARTIST_TABLE + " ( " + A_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + A_NAME + " TEXT , " + A_PHONENUMBER + " TEXT , " + A_ADDRESS + " TEXT ," + A_EMAIL + " TEXT , " + A_PSW + " TEXT ,  " + A_GENDER + " TEXT)";
        sqLiteDatabase.execSQL(createtableartist);

        //Creating table for user
        String createtableuser= "CREATE TABLE " + USER_TABLE + " ( " + U_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + U_NAME + " TEXT , " + U_PHONENUMBER + " TEXT , " + U_ADDRESS + " TEXT ," + U_EMAIL + " TEXT , " + U_PSW + " TEXT ,  " + U_GENDER + " TEXT)";
        sqLiteDatabase.execSQL(createtableuser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addArtist (ModelArtist modelArtist){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(A_ID, modelArtist.getId());
        cv.put(A_NAME, modelArtist.getName());
        cv.put(A_PHONENUMBER, modelArtist.getPhoneno());
        cv.put(A_ADDRESS, modelArtist.getAddress());
        cv.put(A_EMAIL, modelArtist.getEmail());
        cv.put(A_PSW, modelArtist.getPsw());
        cv.put(A_GENDER, modelArtist.getGender());

        long insert = db.insert(ARTIST_TABLE, null, cv);
        db.close();

        if(insert == 1) {
            return false;
        }else{
            return true;
        }
    }


    public  Boolean checkArtist (String email,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from ARTIST where EMAIL= ? and PSW = ?", new String[]{email, pass });
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }}


    public boolean addUser (ModelUser modelUser){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(U_ID,modelUser.getId());
        cv.put(U_NAME, modelUser.getName());
        cv.put(U_PHONENUMBER, modelUser.getPhoneno());
        cv.put(U_ADDRESS, modelUser.getAddress());
        cv.put(U_EMAIL, modelUser.getEmail());
        cv.put(U_PSW, modelUser.getPsw());
        cv.put(U_GENDER, modelUser.getGender());

        long insert = db.insert(USER_TABLE, null, cv);
        db.close();

        if(insert == 1) {
            return false;
        }else{
            return true;
        }
    }
    public  Boolean checkemail(String Email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from USER where EMAIL = ?" , new String[]{Email});
        if (cursor.getCount() >0){
            return true;
        }else{
            return false;
        }
    }

    public  Boolean checkemailpassword (String Email,String Pass){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from USER where EMAIL= ? and PSW = ?", new String[]{Email, Pass });
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }}
}
