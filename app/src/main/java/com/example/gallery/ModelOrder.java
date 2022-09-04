package com.example.gallery;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;

public class ModelOrder {
     String id;
     double price;
     String pname,  imageUrl;

    public ModelOrder(String id, double price, String pname, String imageUrl) {
        this.id = id;
        this.price = price;
        this.pname = pname;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ModelOrder{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", pname='" + pname + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelOrder that = (ModelOrder) o;
        return Double.compare(that.getPrice(), getPrice()) == 0 && getId().equals(that.getId()) && getPname().equals(that.getPname()) && getImageUrl().equals(that.getImageUrl());
    }


    public static DiffUtil.ItemCallback<ModelOrder> itemCallback = new DiffUtil.ItemCallback<ModelOrder>() {
        @Override
        public boolean areItemsTheSame(@NonNull ModelOrder oldItem, @NonNull ModelOrder newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull ModelOrder oldItem, @NonNull ModelOrder newItem) {
            return oldItem.equals(newItem);
        }
    };

    @BindingAdapter("android:productImage")
    public  static void loadImage(ImageView imageView, String imageUrl){

        Glide.with(imageView).load(imageUrl).into(imageView);

    }
}
