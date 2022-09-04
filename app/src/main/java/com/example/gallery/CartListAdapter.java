package com.example.gallery;

import static java.security.AccessController.getContext;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gallery.databinding.CartrowBinding;

public class CartListAdapter extends ListAdapter<CartItem, CartListAdapter.cartVH> {

    private CartInterface cartInterface;
    public CartListAdapter(CartInterface cartInterface) {
        super(CartItem.itemCallback);
        this.cartInterface = cartInterface;
    }

    @NonNull
    @Override
    public cartVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
     CartrowBinding cartrowBinding = CartrowBinding.inflate(layoutInflater,parent,false);
     return new cartVH(cartrowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull cartVH holder, int position) {
      holder.cartrowBinding.setCartItem(getItem(position));
      holder.cartrowBinding.executePendingBindings();
    }

    class cartVH extends RecyclerView.ViewHolder{
    CartrowBinding cartrowBinding;
        public cartVH(@NonNull CartrowBinding cartrowBinding) {
            super(cartrowBinding.getRoot());
            this.cartrowBinding = cartrowBinding;

            cartrowBinding.deleteimageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cartInterface.deleteItem(getItem(getAdapterPosition()));
                }
            });
            cartrowBinding.spinnercart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    int quantity = position +1;
                    if(quantity == getItem(getAdapterPosition()).getQuantity()){
                        return;
                    }
                    cartInterface.changeQuantity(getItem(getAdapterPosition()),quantity);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
    public  interface CartInterface {
        void deleteItem(CartItem cartItem);
        void changeQuantity(CartItem cartItem, int quantity);
    }
}
