package com.example.gallery.Artist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gallery.Modeldata.ModelArtist;
import com.example.gallery.R;
import com.example.gallery.Util.DBHandler;

public class ArtistRegistration_Step2 extends AppCompatActivity {
Button button;
EditText name,phoneno,address, email, psw, confirm;
String entername, enterphoneno, enteraddress, enteremail, enterpsw, enterconfirmpsw, entergender;
CheckBox chk1, chk2, chk3;
DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_registration_step2);

        dbHandler= new DBHandler(getApplicationContext());
        name= findViewById(R.id.fname);
        phoneno = findViewById(R.id.phoneno);
        address = findViewById(R.id.address);
        button= findViewById(R.id.namenext);
        email = findViewById(R.id. email);
        psw = findViewById(R.id.password);
        confirm = findViewById(R.id.confirmpassword);
        chk1 =(CheckBox)findViewById(R.id.others);
        chk2 =(CheckBox)findViewById(R.id.male);
        chk3 =(CheckBox)findViewById(R.id.female);

        //Validation


        //Inserting data into database
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entername = name.getText().toString();
                enterphoneno = phoneno.getText().toString();
                enteraddress = address.getText().toString();
                enteremail = email.getText().toString();
                enterpsw = psw.getText().toString();
                entergender = chk1.getText().toString();
                entergender = chk2.getText().toString();
                entergender = chk3.getText().toString();
                enterconfirmpsw = confirm.getText().toString();

                //validation
                if(entername.equals("")||enterpsw.equals("")||enterconfirmpsw.equals("")||enterphoneno.equals("")||enteraddress.equals("")||enteremail.equals("")||entergender.equals("")){
                    Toast.makeText(ArtistRegistration_Step2.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                if (!enterconfirmpsw.equals(enterpsw)||enterconfirmpsw.isEmpty()) {
                    Toast psw = Toast.makeText(getApplicationContext(), "password doesn't match!", Toast.LENGTH_SHORT);
                    psw.show();
                }if(phoneno.length()!=10){
                    Toast phone = Toast.makeText(getApplicationContext(),"Enter ten digit phone number.", Toast.LENGTH_SHORT);
                    phone.show();
                } else {
                    ModelArtist modelArtist = new ModelArtist(-1, entername, entergender, enterphoneno, enteraddress, enteremail, enterpsw);
                    dbHandler.addArtist(modelArtist);
                    Toast.makeText(getApplicationContext(), "Account Creation Successfull", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ArtistRegistration_Step2.this, ArtistLogin.class);
                    startActivity(intent);

                }
            }
        });


    }
}