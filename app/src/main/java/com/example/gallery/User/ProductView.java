package com.example.gallery.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gallery.R;

public class ProductView extends AppCompatActivity {
    TextView title, pdetail, price;
    ImageView imageView;
    Button button;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);

        getSupportActionBar().setTitle("Order");


        imageView = findViewById(R.id.productimage);
        title= findViewById(R.id.carviewtext);
        button = findViewById(R.id.placeorder);
        pdetail = findViewById(R.id.details);
        price = findViewById(R.id.price);

        title.setText(getIntent().getStringExtra("name"));
        String detail= getIntent().getStringExtra("detail");
        imageView.setImageResource(getIntent().getIntExtra("image" ,0));


//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ProductView.this, ProductSummary.class);
//                startActivity(intent);
//
//
//            }
    }

}