package com.example.gallery.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gallery.CartItem;
import com.example.gallery.ModelOrder;
import com.example.gallery.ShopViewModel;

import java.util.ArrayList;
import java.util.List;

public class CartRepo {


    private MutableLiveData<List<CartItem>> mutablecart = new MutableLiveData<>();
    private MutableLiveData<Double> mutableTotalPrice = new MutableLiveData<>();
    public LiveData<List<CartItem>> getCart(){
        if(mutablecart.getValue() == null){
            initCart();
        }
        return  mutablecart;
    }

    public void initCart() {
        mutablecart.setValue(new ArrayList<>());
        calculateTotal();
    }

    public boolean addItemTocart(ModelOrder product){
        if(mutablecart.getValue()==null){
            initCart();
        }
        List<CartItem> cartItemList = new ArrayList<>(mutablecart.getValue());
        for(CartItem cartItem :cartItemList){
            if(cartItem.getModelOrder().getId().equals(product.getId())){
                if(cartItem.getQuantity() ==5){
                    return false;
                }

                int index= cartItemList.indexOf(cartItem);
                cartItem.setQuantity(cartItem.getQuantity()+ 1);
                cartItemList.set(index,cartItem);

                mutablecart.setValue(cartItemList);
                calculateTotal();
                return true;
            }
        }
        CartItem cartItem = new CartItem(product,1);
        cartItemList.add(cartItem);
        mutablecart.setValue(cartItemList);
        calculateTotal();
        return true;
    }

    public  void removeItemFromCart(CartItem cartItem){
        if(mutablecart.getValue() ==null){
            return;
        }
        List<CartItem> cartItemList = new ArrayList<>(mutablecart.getValue());
        cartItemList.remove(cartItem);
        mutablecart.setValue(cartItemList);
        calculateTotal();
    }

    public void changeQuantity(CartItem cartItem, int quantity){
     if(mutablecart.getValue()== null)return;

     List<CartItem> cartItemList = new ArrayList<>(mutablecart.getValue());

     CartItem updatedItem = new CartItem(cartItem.getModelOrder(),quantity);
     cartItemList.set(cartItemList.indexOf(cartItem),updatedItem);
     mutablecart.setValue(cartItemList);
    }
    private  void calculateTotal(){
        if(mutablecart.getValue()== null)return;
        double total = 0.0;
        List<CartItem> cartItemList = mutablecart.getValue();
        for (CartItem cartItem : cartItemList){
            total += cartItem.getModelOrder().getPrice() * cartItem.getQuantity();
        }
        mutableTotalPrice.setValue(total);
    }

    public LiveData<Double> getTotalPrice(){
        if(mutableTotalPrice.getValue()==null){
            mutableTotalPrice.setValue(0.0);
        }
        return mutableTotalPrice;
    }
}
