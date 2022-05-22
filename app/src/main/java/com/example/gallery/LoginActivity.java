package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.gallery.Artist.ArtistLogin;
import com.example.gallery.User.UserLogin;

public class LoginActivity extends AppCompatActivity {
    CardView cardViewartist, cardViewuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

//      if(Constants.type == Constants.Type.admin){
//          Log.i("TAG", "Admin");
//      }else{
//          Log.i("TAG","User");
//      }

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