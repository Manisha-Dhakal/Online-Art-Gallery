package com.example.gallery.Main;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.example.gallery.R;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {
 DrawerLayout drawerLayout;
 NavigationView navigationView;
 Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
;
      drawerLayout = findViewById(R.id.drawerlayout);
      navigationView = findViewById(R.id.navigationview);
      toolbar = findViewById(R.id.toolbar);

      setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }
}