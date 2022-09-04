package com.example.gallery.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gallery.ModelOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData<List<ModelOrder>> mutableLiveData;

    public LiveData<List<ModelOrder>> getProducts(){
        if(mutableLiveData == null){
            mutableLiveData = new MutableLiveData<>();
            loadProducts();
        }
        return mutableLiveData;
    }

    private void  loadProducts(){
        List<ModelOrder> modelOrderList = new ArrayList<>();
        modelOrderList.add(new ModelOrder(UUID.randomUUID().toString(),1000,"Water Color","art.jpg"));
        modelOrderList.add(new ModelOrder(UUID.randomUUID().toString(),1000,"Water Color","Acrylic"));
        modelOrderList.add(new ModelOrder(UUID.randomUUID().toString(),1000,"Water Color","Acrylic"));
        modelOrderList.add(new ModelOrder(UUID.randomUUID().toString(),1000,"Water Color","Acrylic"));
        modelOrderList.add(new ModelOrder(UUID.randomUUID().toString(),1000,"Water Color","Acrylic"));
        mutableLiveData.setValue(modelOrderList);
    }
}
