package com.example.gallery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gallery.Modeldata.ModelArtist;
import com.example.gallery.R;

import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistAdapterViewHolder> {
    private Context context;
    private List<ModelArtist> modelArtistList;

    public ArtistAdapter(Context context, List<ModelArtist> modelArtistList) {
        this.context = context;
        this.modelArtistList = modelArtistList;
    }

    @NonNull
    @Override
    public ArtistAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view= layoutInflater.inflate(R.layout.activity_artist_registration_step2,parent,false);
        return new ArtistAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistAdapterViewHolder holder, int position) {
        String fname, lname;
        int id;
//    String artistfname = modelArtistList.get(position).getname();
//    String artistlname = modelArtistList.get(position).getFname();
//    holder.editText1.setText(artistfname);
//    holder.editText2.setText(artistlname);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ArtistAdapterViewHolder extends RecyclerView.ViewHolder {
        EditText editText1, editText2;
        Button btn;
        public ArtistAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            editText1= itemView.findViewById(R.id.fname);
            btn = itemView.findViewById(R.id.next);
        }
    }
}
