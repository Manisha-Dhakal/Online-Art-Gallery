package com.example.gallery.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gallery.Modeldata.Modelcategory;
import com.example.gallery.R;
import com.example.gallery.User.ProductView;

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

        final Modelcategory temp = modelcategoryList.get(position);

        holder.name.setText(modelcategoryList.get(position).getPname());
        holder.detail.setText(modelcategoryList.get(position).getPdetail());
        holder.image.setImageResource(modelcategoryList.get(position).getPimage());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(context, ProductView.class);
                intent.putExtra("name",temp.getPname());
                intent.putExtra("detail",temp.getPdetail());
                intent.putExtra("image",temp.getPimage());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return modelcategoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //here we will find the views on which we will inflate our data
        Button button;
        TextView name, detail;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.quickview);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
        }
    }
}
