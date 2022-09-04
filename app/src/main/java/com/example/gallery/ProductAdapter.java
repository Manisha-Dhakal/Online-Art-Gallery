package com.example.gallery;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gallery.databinding.ListitemBinding;


public class ProductAdapter extends ListAdapter<ModelOrder,ProductAdapter.ShopViewHolder> {
ShopInterface shopInterface;
    public ProductAdapter(ShopInterface shopInterface) {
        super(ModelOrder.itemCallback);
        this.shopInterface=shopInterface;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListitemBinding listitemBinding = ListitemBinding.inflate(layoutInflater,parent,false);
       listitemBinding.setShopInterface(shopInterface);

        return new ShopViewHolder(listitemBinding) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
   ModelOrder modelOrder= getItem(position);
   holder.listitemBinding.setProduct(modelOrder);
    }

    class ShopViewHolder extends RecyclerView.ViewHolder{

       ListitemBinding listitemBinding;


        public ShopViewHolder(ListitemBinding binding){
            super(binding.getRoot());
            this.listitemBinding= binding;

        }
    }
    public interface  ShopInterface{
        void addItem(ModelOrder product);
        void onItemClick(ModelOrder product);
    }
}
