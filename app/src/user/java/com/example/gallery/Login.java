package com.example.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.gallery.Admin.MainAdmin;
import com.example.gallery.Artist.ArtistLogin;
import com.example.gallery.User.UserLogin;

public class Login extends AppCompatActivity {
    CardView cardViewartist, cardViewuser;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        getSupportActionBar().setTitle("Gallery Login");

        cardViewartist= findViewById(R.id.Artistlogin);
        cardViewuser= findViewById(R.id.Userlogin);
        imageView= findViewById(R.id.imageadmin);

        cardViewartist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Login.this, ArtistLogin.class);
                startActivity(intent);
            }
        });

        cardViewuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Login.this, UserLogin.class);
                startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainAdmin.class);
                startActivity(intent);
            }
        });

    }
    }