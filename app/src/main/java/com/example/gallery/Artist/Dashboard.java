package com.example.gallery.Artist;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gallery.Adapter.RequestArtAdapter;
import com.example.gallery.Modeldata.ModelRequestArt;
import com.example.gallery.R;
import com.example.gallery.Util.DBHandler;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    ImageView image;
    DBHandler dbHandler;
    ListView listView;
    ArrayList<ModelRequestArt> arrayList;
    RequestArtAdapter requestArtAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        dbHandler = new DBHandler(this);

        TextView tv = (TextView) findViewById(R.id.name); //setting artist name
        Intent intent = getIntent();
        String str = intent.getStringExtra("key");
        tv.setText(str);

        listView = findViewById(R.id.listView);
        showartistdata();
    }

    private void showartistdata() {
        arrayList =dbHandler.getart();
        requestArtAdapter= new RequestArtAdapter(this,arrayList);
        listView.setAdapter(requestArtAdapter);
        requestArtAdapter.notifyDataSetChanged();
    }


    public  boolean onCreateOptionsMenu( Menu menu){
        getMenuInflater().inflate(R.menu.artistmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public  boolean onOptionsItemSelected(MenuItem item){
        LayoutInflater inflater=(LayoutInflater) Dashboard.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.insertrequest_ofartist,null);
        final  EditText at_name  = view.findViewById(R.id.at_Name);
        final EditText at_location  = view.findViewById(R.id.at_location);
        image  = view.findViewById(R.id.at_art);


        image.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                boolean pick=true;
                if(pick == true){
                    if(!checkCameraPermission()){
                        requestCameraPermissions();
                    }else PickImage();
                }else {
                   if(!checkStoragePermisiion()){
                       requestStoragePermissions();
                   }else PickImage();
                }
            }
        });


        AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);
        builder.setView(view)
                .setTitle("adding art")
                .setMessage("enter info")
                .setIcon(R.drawable.ic_baseline_account_circle_24)
                .setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    String name= at_name.getText().toString();
                        String location= at_location.getText().toString();
                        boolean res = dbHandler.addrequestArt(name,location,ImageToByte(image));
                        if(res==true){
                            showartistdata();
                            Toast.makeText(Dashboard.this, "data added", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(Dashboard.this, "not added", Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

           builder.create().show();
        return super.onOptionsItemSelected(item);
    }

    private byte[] ImageToByte(ImageView image) {
        Bitmap bitmap=((BitmapDrawable) image.getDrawable()).getBitmap(); //array nai ho
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress( Bitmap.CompressFormat.PNG, 10, stream);
        byte[] bytes = stream.toByteArray();
        return bytes;

    }

    private void PickImage() {
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void requestStoragePermissions() {
        requestPermissions(new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                try{
                    InputStream stream = getContentResolver().openInputStream(resultUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(stream);
                    image.setImageBitmap(bitmap);
                }catch (Exception e) {
                e.printStackTrace();

                }
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void requestCameraPermissions() {

        requestPermissions(new String[] {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
    }

    private boolean checkStoragePermisiion() {
        boolean res1= ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        return  res1;
    }

    private boolean checkCameraPermission() {

        boolean res1= ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        boolean res2= ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
      return res1 && res2;
    }
}