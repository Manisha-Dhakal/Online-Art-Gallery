package com.example.gallery.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.gallery.R;
import com.google.android.material.navigation.NavigationView;
import com.nex3z.notificationbadge.NotificationBadge;

public class ProductPage extends AppCompatActivity {

    NavHostFragment navHostFragment;
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
        navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentContainerView);
        navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this,navController);

       Toolbar toolbar = findViewById(R.id.toolbar);




    }

        public  boolean onCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.usercartaction,menu);
            // getMenuInflater().inflate(R.menu.sidemenu,menu);

            MenuItem menuItem = menu.findItem(R.id.cartFragment);
            View actionView = menuItem.getActionView();

            NotificationBadge cartbadge = actionView.findViewById(R.id.badge);
            cartbadge.setText("0");
            actionView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onOptionsItemSelected(menuItem);
                }
            });
            return super.onCreateOptionsMenu(menu);
        }



        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            NavigationUI.onNavDestinationSelected(item, navController);
            switch (item.getItemId()) {
                // case R.id.waterpainting:
                // return true;
                case R.id.cartFragment:
                    return true;
                case R.id.logout:
                    return true;
                case R.id.click:
                    Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
                    finish();
                    return true;
               default:
                    return super.onOptionsItemSelected(item);
            }


        }

    }
