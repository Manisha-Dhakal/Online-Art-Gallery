package com.example.gallery.Artist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gallery.R;

public class ArtistLogin extends AppCompatActivity {
    EditText editemail, editpsw;
    Button buttonlogin, buttonsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_login);

        getSupportActionBar().setTitle("Artist Login");


        buttonsignup = findViewById(R.id.signup);
        buttonlogin = findViewById(R.id.alogin);

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
                Intent intent = new Intent(ArtistLogin.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }}