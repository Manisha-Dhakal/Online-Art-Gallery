package com.example.gallery.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.gallery.Modeldata.ModelArtist;
import com.example.gallery.Modeldata.ModelOrder;
import com.example.gallery.Modeldata.ModelRequestArt;
import com.example.gallery.Modeldata.ModelUser;
import com.example.gallery.Modeldata.Modelcategory;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "ARTGALLERY";
    public static final int DB_VERSION = 1;

    //Rgistration of artist
    public static final String ARTIST_TABLE = "ARTIST";
    public static final String A_ID = "ID";
    public static final String A_NAME = "NAME";
    public static final String A_PHONENUMBER = "PHONENO";
    public static final String A_ADDRESS = "ADDRESS";
    public static final String A_EMAIL = "EMAIL";
    public static final String A_PSW = "PSW";
    public static final String A_GENDER = "GENDER";

    //Registratiojn of user
    public static final String USER_TABLE = "USER";
    public static final String U_ID = "ID";
    public static final String U_NAME = "NAME";
    public static final String U_PHONENUMBER = "PHONENO";
    public static final String U_ADDRESS = "ADDRESS";
    public static final String U_EMAIL = "EMAIL";
    public static final String U_PSW = "PSW";
    public static final String U_GENDER = "GENDER";

    //Artist Requesting place in Gallery
    public static final String R_TABLE = "REQUESTEDART";
    public static final String R_NAME = "NAME";
    public static final String R_LOCATION = "LOCATION";
    public static final String R_IMAGE = "IMAGE";

    public DBHandler(@Nullable Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Creating table for artist
        String createtableartist= "CREATE TABLE " + ARTIST_TABLE + " ( " + A_ID + " INTEGER , " + A_NAME + " TEXT , " + A_PHONENUMBER + " TEXT , " + A_ADDRESS + " TEXT ," + A_EMAIL + " TEXT , " + A_PSW + " TEXT ,  " + A_GENDER + " TEXT)";
        sqLiteDatabase.execSQL(createtableartist);

        //Creating table for user
        String createtableuser= "CREATE TABLE " + USER_TABLE + " ( " + U_ID + " INTEGER , " + U_NAME + " TEXT , " + U_PHONENUMBER + " TEXT , " + U_ADDRESS + " TEXT ," + U_EMAIL + " TEXT , " + U_PSW + " TEXT ,  " + U_GENDER + " TEXT)";
        sqLiteDatabase.execSQL(createtableuser);


        //creating table for artist to request art
        String rq= "CREATE TABLE " + R_TABLE + " ( " + R_NAME + " TEXT , " + R_LOCATION + " TEXT , " + R_IMAGE + " BLOB)";
        sqLiteDatabase.execSQL(rq);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + R_TABLE);
        onCreate(sqLiteDatabase);

    }
//artist login
    public  Boolean checkValidation (String Username, String Psw){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from ARTIST where NAME= ? and PSW = ?", new String[]{Username, Psw});
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

    //for userlogin
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
        Cursor cursor = db.rawQuery("Select * from USER where NAME= ? and PSW = ?", new String[]{Email, Pass });
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }}

    //cartdetails
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


      public  boolean addrequestArt (String name, String location, byte[] image){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put (R_NAME, name);
        contentValues.put(R_LOCATION, location);
        contentValues.put(R_IMAGE,image);
        long res = db.insert(R_TABLE,null,contentValues);
        db.close();
        if (res == -1)
            return false;
        else return true;
      }

      public ArrayList<ModelRequestArt>  getart(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<ModelRequestArt> arrayList = new ArrayList<>();
        Cursor cursor =db.rawQuery("Select * from " + R_TABLE,null);
          while(cursor.moveToNext()) {
              String name = cursor.getString(0);
              String location = cursor.getString(1);
              byte[] image = cursor.getBlob(2);
              ModelRequestArt modelRequestArt = new ModelRequestArt(name,location,image);
              arrayList.add(modelRequestArt);
          }
          return arrayList;
      }



}
