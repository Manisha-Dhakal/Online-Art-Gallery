package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gallery.Main.ArtistLogin;
import com.example.gallery.Main.Dashboard;
import com.example.gallery.Main.MainPage;
import com.example.gallery.Main.UserLogin;
import com.example.gallery.Modeldata.ModelArtist;
import com.example.gallery.Util.DBHandler;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    CardView cardViewartist, cardViewuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        getSupportActionBar().setTitle("Gallery Login");

        cardViewartist= findViewById(R.id.Artistlogin);
        cardViewuser= findViewById(R.id.Userlogin);

        cardViewartist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginActivity.this, ArtistLogin.class);
                startActivity(intent);
            }
        });

        cardViewuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginActivity.this, UserLogin.class);
                startActivity(intent);
            }
        });
    }
    }