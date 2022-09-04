package com.example.gallery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gallery.Modeldata.ModelUser;
import com.example.gallery.R;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {

    Context context;
    ArrayList<ModelUser> arrayList;

    public UserAdapter(Context context, ArrayList<ModelUser> arrayList) {
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
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.userlist, parent, false);
         }

        TextView id = convertView.findViewById(R.id.userid);
        TextView name = convertView.findViewById(R.id.username);
        TextView phone = convertView.findViewById(R.id.userphoneno);
        TextView address = convertView.findViewById(R.id.useraddress);
        TextView email = convertView.findViewById(R.id.useremail);
        TextView gender = convertView.findViewById(R.id.usergender);

        ModelUser modelUser = arrayList.get(position);
        Integer Id = modelUser.getId();
        String Name = modelUser.getName();
        String Phone = modelUser.getPhoneno();
        String Address = modelUser.getAddress();
        String Email = modelUser.getEmail();
        String Gender = modelUser.getGender();

        id.setText(String.valueOf(Id));
        name.setText(Name);
        phone.setText(Phone);
        address.setText(Address);
        email.setText(Email);
        gender.setText(Gender);


        return convertView;
    }
}
