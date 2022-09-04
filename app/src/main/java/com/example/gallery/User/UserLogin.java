package com.example.gallery.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gallery.R;
import com.example.gallery.Util.DBHandler;

public class UserLogin extends AppCompatActivity {
Button buttonsignup, buttonlogin;
EditText editemail, editpsw, editname;
DBHandler dbHandler;
String Email, Pass, name, Confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        getSupportActionBar().setTitle("Useradmin Login");
        dbHandler= new DBHandler(getApplicationContext());

        buttonsignup=findViewById(R.id.signup);
        buttonlogin=findViewById(R.id.login);
        editemail = findViewById(R.id.editTextEmail);
        editpsw = findViewById(R.id.editPassword);

        buttonsignup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(UserLogin.this, User_Registration.class);
                    startActivity(intent);
            }
        });

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Email = editemail.getText().toString();
                Pass = editpsw.getText().toString();


                if (Email.equals("") || Pass.equals("")) {
                    Toast.makeText(UserLogin.this, "Please Enter all the field", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkemailpassword = dbHandler.checkemailpassword(Email, Pass);
                    if (checkemailpassword == true) {
                        Toast.makeText(UserLogin.this, "Login successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UserLogin.this, MainPage.class);
                        intent.putExtra("key", Email);
                        startActivity(intent);
                    } else {
                        Toast.makeText(UserLogin.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        }



}