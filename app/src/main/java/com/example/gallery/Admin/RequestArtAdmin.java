package com.example.gallery.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.gallery.Adapter.RequestArtAdapter;
import com.example.gallery.Modeldata.ModelRequestArt;
import com.example.gallery.R;
import com.example.gallery.Util.DBHandler;

import java.util.ArrayList;

public class RequestArtAdmin extends AppCompatActivity {


    DBHandler dbHandler;
    ListView listView;
    ArrayList<ModelRequestArt> arrayList;
    RequestArtAdapter requestArtAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_art_admin);

        dbHandler = new DBHandler(this);
        listView = findViewById(R.id.listView);

        showart();
    }

    private void showart() {
        arrayList =dbHandler.getart();
        requestArtAdapter= new RequestArtAdapter(this,arrayList);
        listView.setAdapter(requestArtAdapter);
        requestArtAdapter.notifyDataSetChanged();
    }
}