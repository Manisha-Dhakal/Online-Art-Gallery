package com.example.gallery.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gallery.Modeldata.ModelArtist;
import com.example.gallery.Modeldata.ModelUser;
import com.example.gallery.R;
import com.example.gallery.Util.DBHandler;

public class UserRegistration_Step2 extends AppCompatActivity {
Button button;
EditText name,phoneno,address, email, psw;
String entername, enterphoneno, enteraddress, enteremail, enterpsw, entergender;
CheckBox chk1, chk2, chk3;
DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration_step2);

        dbHandler= new DBHandler(getApplicationContext());
        name= findViewById(R.id.fname);
        phoneno = findViewById(R.id.phoneno);
        address = findViewById(R.id.address);
        button= findViewById(R.id.namenext);
        email = findViewById(R.id. email);
        psw = findViewById(R.id.confirmpassword);
        chk1 =(CheckBox)findViewById(R.id.others);
        chk2 =(CheckBox)findViewById(R.id.male);
        chk3 =(CheckBox)findViewById(R.id.female);

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

                ModelUser modeluser = new ModelUser(-1,entername,entergender,enterphoneno,enteraddress,enteremail,enterpsw);
                boolean success= dbHandler.addUser(modeluser);
                Toast.makeText(getApplicationContext(),"Name Added", Toast.LENGTH_SHORT).show();
                if(success){
                Intent intent = new Intent(UserRegistration_Step2.this, UserRegistration_FinalStep.class);
                startActivity(intent);
            }else{
                    Toast.makeText(getApplicationContext(),"Failed Addding Data", Toast.LENGTH_SHORT).show();
                }}
        });
    }
}