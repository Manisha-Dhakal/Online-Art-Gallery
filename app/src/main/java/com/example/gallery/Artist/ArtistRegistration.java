package com.example.gallery.Artist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gallery.User.UserLogin;
import com.example.gallery.R;

public class ArtistRegistration extends AppCompatActivity {
Button button;
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_registration);

        textView=findViewById(R.id.already);
        button= findViewById(R.id.next);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ArtistRegistration.this, ArtistRegistration_Step2.class);
                startActivity(intent);
     }
      });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ArtistRegistration.this, UserLogin.class);
                startActivity(intent);
            }
        });

        //Inserting data into database


    }
}