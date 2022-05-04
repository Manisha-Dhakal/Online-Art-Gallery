package com.example.gallery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gallery.Modeldata.Modelcategory;
import com.example.gallery.R;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    List<Modelcategory> modelcategoryList;
    Context context;

    public OrderAdapter( Context context,List<Modelcategory> modelcategoryList) {
        this.context = context;
        this.modelcategoryList = modelcategoryList;

    }

    public OrderAdapter(){

    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
    String name = modelcategoryList.get(position).getPname();
    String detail = modelcategoryList.get(position).getPdetail();
    int image = modelcategoryList.get(position).getPimage();

    holder.name.setText(name);
    holder.detail.setText(detail);
    holder.image.setImageResource(image);

    }

    @Override
    public int getItemCount() {
        return modelcategoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //here we will find the views on which we will inflate our data
        TextView name, detail;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            detail= itemView.findViewById(R.id.detail);
            image = itemView.findViewById(R.id.image);
        }
    }
}
