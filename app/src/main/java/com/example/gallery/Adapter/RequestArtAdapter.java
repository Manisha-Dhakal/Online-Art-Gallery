package com.example.gallery.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gallery.Modeldata.ModelRequestArt;
import com.example.gallery.R;

import java.util.ArrayList;


public class RequestArtAdapter extends BaseAdapter {

    Context context;
    ArrayList<ModelRequestArt> arrayList;

    public RequestArtAdapter(Context context, ArrayList<ModelRequestArt> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.artistcardview,null);

        TextView name = view.findViewById(R.id.artistname);
        TextView location = view.findViewById(R.id.artistlocation);
        ImageView image = view.findViewById(R.id.artistimage);

        ModelRequestArt modelRequestArt= arrayList.get(position);
        String Name = modelRequestArt.getName();
        String Location = modelRequestArt.getLocation();
        byte[]  Image  = modelRequestArt.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(Image,0, Image.length);
        bitmap=Bitmap.createScaledBitmap(bitmap,400,400,true);
        image.setImageBitmap(bitmap);
        name.setText(Name);
        location.setText(Location);

        return view;
    }
}
