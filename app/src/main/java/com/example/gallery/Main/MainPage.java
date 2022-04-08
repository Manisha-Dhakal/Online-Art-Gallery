package com.example.gallery.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.gallery.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainPage extends AppCompatActivity {

    private int [] mImages = new int[]
            {
                    R.drawable.gouache, R.drawable.watercolor, R.drawable.acrylic, R.drawable.timon,R.drawable.slide//sliderimage
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        CarouselView carouselView = findViewById(R.id.slider);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
              imageView.setImageResource(mImages[position]);
            }
        });
    }
}