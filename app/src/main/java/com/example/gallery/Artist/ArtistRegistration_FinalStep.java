package com.example.gallery.Artist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gallery.User.UserLogin;
import com.example.gallery.R;

public class ArtistRegistration_FinalStep extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_registration_finalstep);

        button=findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ArtistRegistration_FinalStep.this, ArtistLogin.class);
                startActivity(intent);
            }
        });
    }
}
