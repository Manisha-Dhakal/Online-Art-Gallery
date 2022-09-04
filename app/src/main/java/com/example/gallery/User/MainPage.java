package com.example.gallery.User;

import static android.os.Build.VERSION_CODES.O;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gallery.Adapter.OrderAdapter;
import com.example.gallery.CartItem;
import com.example.gallery.Modeldata.Modelcategory;
import com.example.gallery.R;
import com.example.gallery.ShopViewModel;
import com.google.android.gms.common.internal.service.Common;
import com.nex3z.notificationbadge.NotificationBadge;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AppCompatActivity {

    private static final String TAG = "MainPage";
    Toolbar toolbar;
    CardView cardView;
    NavHostFragment navHostFragment;
    NavController navController;
    ShopViewModel shopViewModel;
    private int cartQuantity = 0;

    //slider
        private int [] mImages = new int[]
            {
                    R.drawable.gouache, R.drawable.watercolor, R.drawable.acrylic, R.drawable.timon,R.drawable.slide//sliderimage
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

//      navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentContainerView);
        navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this,navController);
        shopViewModel = new ViewModelProvider(this).get(ShopViewModel.class);
        shopViewModel.getCart().observe(this, new Observer<List<CartItem>>() {
            @Override
            public void onChanged(List<CartItem> cartItems) {
                int quantity = 0;
                for(CartItem cartItem: cartItems){
                    quantity += cartItem.getQuantity();

                }
                cartQuantity = quantity;
                invalidateOptionsMenu();
            }
        });



        TextView tv = (TextView) findViewById(R.id.username);
        Intent intent = getIntent();
        String str = intent.getStringExtra("key");
        tv.setText(str);

        toolbar = findViewById(R.id.toolbar);
        cardView = findViewById(R.id.architecture);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, ProductPage.class);
                startActivity(intent);
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        CarouselView carouselView = findViewById(R.id.slider);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return super.onSupportNavigateUp();
    }

    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.usercartaction,menu);
        MenuItem menuItem = menu.findItem(R.id.cartFragment);
        View actionView = menuItem.getActionView();

        NotificationBadge cartbadge = actionView.findViewById(R.id.badge);
        cartbadge.setText(String.valueOf(cartQuantity));
        cartbadge.setVisibility(cartQuantity == 0? View.GONE : View.VISIBLE);
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
        if (NavigationUI.onNavDestinationSelected(item, navController)) {
            return true;
        } else {
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
}