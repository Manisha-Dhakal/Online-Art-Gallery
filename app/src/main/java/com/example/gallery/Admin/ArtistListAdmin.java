package com.example.gallery.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.gallery.Adapter.ArtistAdapter;
import com.example.gallery.Adapter.UserAdapter;
import com.example.gallery.Modeldata.ModelArtist;
import com.example.gallery.Modeldata.ModelUser;
import com.example.gallery.R;
import com.example.gallery.Util.DBHandler;

import java.util.ArrayList;

public class ArtistListAdmin extends AppCompatActivity {
    DBHandler dbHandler;
    ListView listView;
    ArrayList<ModelArtist> arrayList;
    ArtistAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_list_admin);

        dbHandler= new DBHandler(this);
        listView = findViewById(R.id.artistlist);

        showuserdata();
    }

    private void showuserdata() {
        arrayList = dbHandler.getartistdata();
        adapter= new ArtistAdapter(this,arrayList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}