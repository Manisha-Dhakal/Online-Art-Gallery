package com.example.gallery.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.gallery.Adapter.UserAdapter;
import com.example.gallery.Modeldata.ModelUser;
import com.example.gallery.R;
import com.example.gallery.Util.DBHandler;

import java.util.ArrayList;

public class UserListAdmin extends AppCompatActivity {
    DBHandler dbHandler;
    ListView listView;
    ArrayList<ModelUser> arrayList;
    UserAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list_admin);

        dbHandler= new DBHandler(this);

        listView= findViewById(R.id.userlist);
        showuserdata();
    }

    private void showuserdata() {

        arrayList = dbHandler.getuserdata();
        adapter= new UserAdapter(this,arrayList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    }
