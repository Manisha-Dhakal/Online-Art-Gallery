package com.example.gallery.Artist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gallery.R;
import com.example.gallery.Util.DBHandler;

public class ArtistLogin extends AppCompatActivity {
    EditText editusername, editpsw;
    Button buttonlogin, buttonsignup;
    DBHandler dbHandler;
    String Username, Psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_login);

        getSupportActionBar().setTitle("Artistadmin Login");
        dbHandler= new DBHandler(getApplicationContext());


        buttonsignup = findViewById(R.id.signup);
        buttonlogin = findViewById(R.id.alogin);
        editusername = findViewById(R.id.editTextUsername);
        editpsw = findViewById(R.id.editPassword);

        buttonsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ArtistLogin.this, ArtistRegistration.class);
                startActivity(intent);
            }
        });
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Username = editusername.getText().toString();
                Psw = editpsw.getText().toString();


                if(Username.equals("") || Psw.equals("")){
                    Toast.makeText(ArtistLogin.this, "Please enter all the field", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkvalidation = dbHandler.checkValidation(Username, Psw);
                    if (checkvalidation == true) {
                        Toast.makeText(ArtistLogin.this, "Login successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ArtistLogin.this, Dashboard.class);
                        intent.putExtra("key", Username);
                        startActivity(intent);
                    } else {

                        Toast.makeText(ArtistLogin.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                    }
                }}
        });
    }}