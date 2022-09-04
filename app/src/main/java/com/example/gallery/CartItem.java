package com.example.gallery;

import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class CartItem {

    private ModelOrder modelOrder;
    private int quantity;

    public CartItem(ModelOrder modelOrder, int quantity) {
        this.modelOrder = modelOrder;
        this.quantity = quantity;
    }

    public ModelOrder getModelOrder() {
        return modelOrder;
    }

    public void setModelOrder(ModelOrder modelOrder) {
        this.modelOrder = modelOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "modelOrder=" + modelOrder +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return getQuantity() == cartItem.getQuantity() && getModelOrder().equals(cartItem.getModelOrder());
    }

    @BindingAdapter("android:setVal")
     public  static  void  getSelectedSpinnerValue(Spinner spinner,int quantity){
     spinner.setSelection(quantity -1 ,true);
}

    public  static DiffUtil.ItemCallback<CartItem> itemCallback = new DiffUtil.ItemCallback<CartItem>() {
        @Override
        public boolean areItemsTheSame(@NonNull CartItem oldItem, @NonNull CartItem newItem) {
//            return oldItem.getModelOrder().equals(newItem.getModelOrder());
        return  oldItem.getQuantity()== newItem.getQuantity();
        }

        @Override
        public boolean areContentsTheSame(@NonNull CartItem oldItem, @NonNull CartItem newItem) {
            return oldItem.equals(newItem);
        }
    };
}
