package com.example.gallery.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gallery.R;

public class Management extends AppCompatActivity {
CardView cardViewuser, cardviewartist, cardviewrequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
        cardViewuser = findViewById(R.id.manageuser);
        cardviewartist = findViewById(R.id.manageartist);
        cardviewrequest = findViewById(R.id.managerequestArt);

        cardViewuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Management.this, UserListAdmin.class);
                startActivity(intent);
            }
        });

        cardviewartist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Management.this, ArtistListAdmin.class);
                startActivity(intent);
            }
        });

        cardviewrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Management.this, RequestArtAdmin.class);
                startActivity(intent);
            }
        });




    }
}