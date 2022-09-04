package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.gallery.Adapter.RequestArtAdapter;
import com.example.gallery.Modeldata.ModelArtist;
import com.example.gallery.Modeldata.ModelRequestArt;
import com.example.gallery.Modeldata.ModelUser;
import com.example.gallery.Util.DBHandler;

import java.util.ArrayList;

public class ArtistDetails extends AppCompatActivity {
    DBHandler dbHandler;
    ListView listView;
    ArrayList<ModelUser> arrayList;
    UserAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_details);
        dbHandler= new DBHandler(this);

        listView= findViewById(R.id.artistlist);
        showartistdata();
    }

    private void showartistdata() {

        arrayList = dbHandler.getuserdata();
        adapter= new UserAdapter(this,arrayList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}