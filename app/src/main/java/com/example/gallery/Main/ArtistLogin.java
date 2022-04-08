package com.example.gallery.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gallery.R;
import com.example.gallery.Util.DBHandler;

public class ArtistLogin extends AppCompatActivity {
    SQLiteDatabase dbhandler;
    SQLiteOpenHelper openHelper;
    EditText email, password;
    Button buttonlogin, buttonsignup;
    String Psw,Email;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_login);
        openHelper = new DBHandler(this);
        dbhandler = openHelper.getReadableDatabase();

        buttonsignup=findViewById(R.id.signup);
        buttonlogin=findViewById(R.id.login);
        email=findViewById(R.id.editTextEmail);

        buttonsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ArtistLogin.this, ArtistRegistration.class);
                startActivity(intent);
            }
        });

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Psw = password.getText().toString();
                //cursor =dbhandler.rawQuery("select " + DBHandler.A_NAME +", " + DBHandler.A_LNAME + " from " + DBHandler.ARTIST_TABLE, new String[] {Email,Psw});
                //cursor= dbhandler.rawQuery("SELECT * FROM " + DBHandler.ARTIST_TABLE + "WHERE" + DBHandler.A_FNAME+ "=? AND " + DBHandler.A_LNAME + "=?" , new String[] {Email, Psw});
                if(cursor!=null) {
                    if (cursor.getCount() > 0) {
                        Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ArtistLogin.this,ArtistDashboard.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "error login", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
            }}