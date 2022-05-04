package com.example.gallery.User;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gallery.Adapter.OrderAdapter;
import com.example.gallery.Modeldata.Modelcategory;
import com.example.gallery.R;
import com.google.android.material.navigation.NavigationView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerListener;
    Toolbar toolbar;
    Text txt;
    List<Modelcategory> modelcategoryList;
    RecyclerView recyclerView;
        private int [] mImages = new int[]
            {
                    R.drawable.gouache, R.drawable.watercolor, R.drawable.acrylic, R.drawable.timon,R.drawable.slide//sliderimage
            };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

      TextView tv = (TextView) findViewById(R.id.username);
      Intent intent = getIntent();
      String str = intent.getStringExtra("key");
      tv.setText(str);

//        tv.setText("Welcome ,"+getIntent().getExtras().getString("username"));


        toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerlayout);

        drawerListener = new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(drawerListener);
        drawerListener.syncState();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



      CarouselView carouselView = findViewById(R.id.slider);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
              imageView.setImageResource(mImages[position]);
            }
        });
        modelcategoryList = new ArrayList<>();
        modelcategoryList.add(new Modelcategory("Sketching", getString(R.string.Sketching), R.drawable.gouache));
        modelcategoryList.add(new Modelcategory("Painting", getString(R.string.Sketching), R.drawable.sculpture));

        modelcategoryList.add(new Modelcategory("Oil painting", getString(R.string.Sketching), R.drawable.watercolor));

        modelcategoryList.add(new Modelcategory("Water Painting", getString(R.string.Sketching), R.drawable.painting));

        modelcategoryList.add(new Modelcategory("Illustration", getString(R.string.Sketching), R.drawable.painting));

        modelcategoryList.add(new Modelcategory("Digital art", getString(R.string.Sketching), R.drawable.painting));

        modelcategoryList.add(new Modelcategory("Sketching", getString(R.string.Sketching), R.drawable.painting));
        // recyclerview
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));

        //adapter
        OrderAdapter Adapter = new OrderAdapter(this, modelcategoryList);
        recyclerView.setAdapter(Adapter);

   }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(drawerListener.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}