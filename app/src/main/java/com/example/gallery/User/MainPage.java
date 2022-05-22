package com.example.gallery.User;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gallery.Adapter.OrderAdapter;
import com.example.gallery.Modeldata.Modelcategory;
import com.example.gallery.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AppCompatActivity {

    DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerListener;
    Toolbar toolbar;
    List<Modelcategory> modelcategoryList;
    RecyclerView recyclerView;

    //slider
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
        modelcategoryList.add(new Modelcategory("Wall Art", getString(R.string.Sketching), R.drawable.timon));
        modelcategoryList.add(new Modelcategory("Sculpture", getString(R.string.Sketching), R.drawable.sculpture));

        modelcategoryList.add(new Modelcategory("Oil painting", getString(R.string.Sketching), R.drawable.watercolor));

        modelcategoryList.add(new Modelcategory("Cinema Art", getString(R.string.Sketching), R.drawable.slide));

        modelcategoryList.add(new Modelcategory("Gouache", getString(R.string.Sketching), R.drawable.gouache));

        modelcategoryList.add(new Modelcategory("Acrylic", getString(R.string.Sketching), R.drawable.acrylic));

        modelcategoryList.add(new Modelcategory("Architecture", getString(R.string.Sketching), R.drawable.architechture));
        // recyclerview
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));

        //adapter
        OrderAdapter Adapter = new OrderAdapter(this, modelcategoryList);
        recyclerView.setAdapter(Adapter);

   }

    public  boolean onCreateOptionsMenu( Menu menu){
        getMenuInflater().inflate(R.menu.usercartaction,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(drawerListener.onOptionsItemSelected(item))
        {
            return true;
        }
        //
        LayoutInflater inflater=(LayoutInflater) MainPage.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.logout,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainPage.this);
        builder.setView(view)
                .setTitle("Logout")
                .setNegativeButton("LOGOUT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();

                    }
                });

        builder.create().show();
        return super.onOptionsItemSelected(item);
    }



}