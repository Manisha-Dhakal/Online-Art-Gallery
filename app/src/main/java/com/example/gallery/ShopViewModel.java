package com.example.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gallery.repo.CartRepo;
import com.example.gallery.repo.ShopRepo;

import java.util.List;

public class ShopViewModel extends ViewModel {

    ShopRepo shopRepo = new ShopRepo();
    CartRepo cartRepo = new CartRepo();
    MutableLiveData<ModelOrder> modelOrderMutableLiveData = new MutableLiveData<>();

    public LiveData<List<ModelOrder>> getProducts(){

        return shopRepo.getProducts();

    }
    public  void setProduct(ModelOrder product){
        modelOrderMutableLiveData.setValue(product);

    }

    public LiveData<ModelOrder> getProduct(){
        return modelOrderMutableLiveData;
    }

    public  LiveData<List<CartItem>> getCart(){
        return cartRepo.getCart();
}

    public  boolean addItemTocart(ModelOrder product){
        return  cartRepo.addItemTocart(product);
   }


   public void removeItemFromCart(CartItem cartItem){
        cartRepo.removeItemFromCart(cartItem );
   }

   public  void changeQuantity(CartItem cartItem, int quantity){
        cartRepo.changeQuantity(cartItem,quantity);
   }

   public  LiveData<Double> getTotalPrice(){
        return cartRepo.getTotalPrice();
   }
   public  void resetcart(){
        cartRepo.initCart();
   }

}

