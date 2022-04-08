package com.example.gallery.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gallery.Modeldata.ModelArtist;
import com.example.gallery.R;
import com.example.gallery.Util.DBHandler;

import java.util.ArrayList;
import java.util.List;

public class RecyclerLogin extends AppCompatActivity {
 private List<ModelArtist> modelArtistList= new ArrayList<>();
 private DBHandler dbHandler;
 private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_login);


    }
}