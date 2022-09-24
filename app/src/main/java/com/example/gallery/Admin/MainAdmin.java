package com.example.gallery.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gallery.R;

public class MainAdmin extends AppCompatActivity {
    EditText username, password;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        username= findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPersonName2);
        button= findViewById(R.id.adminlogin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                Intent intent = new Intent(MainAdmin.this, Management.class);
                startActivity(intent);
            }else{
                    Toast.makeText(MainAdmin.this, "wrong password", Toast.LENGTH_SHORT).show();
                }}
        });
    }
}