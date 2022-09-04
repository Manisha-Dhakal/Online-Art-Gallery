package com.example.gallery.User;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gallery.ModelOrder;
import com.example.gallery.ProductAdapter;
import com.example.gallery.R;
import com.example.gallery.ShopViewModel;
import com.example.gallery.databinding.FragmentShopBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ShopFragment extends Fragment implements ProductAdapter.ShopInterface {
    private static final String TAG = "ShopFragment";
   
    FragmentShopBinding fragmentShopBinding;
    private ProductAdapter productAdapter;
    private NavHostFragment navHostFragment;
    private NavController navController;

     private ShopViewModel shopViewModel;


    public ShopFragment() {
        // Required empty public constructor

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentShopBinding = fragmentShopBinding.inflate(inflater,container,false);
        return fragmentShopBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        productAdapter= new ProductAdapter(this);
        fragmentShopBinding.shoprecyclerview.setAdapter(productAdapter);
        fragmentShopBinding.shoprecyclerview.addItemDecoration(new DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL));
        fragmentShopBinding.shoprecyclerview.addItemDecoration(new DividerItemDecoration(requireContext(),DividerItemDecoration.HORIZONTAL));

        shopViewModel= new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        shopViewModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<ModelOrder>>() {
            @Override
            public void onChanged(List<ModelOrder> modelOrders) {
            productAdapter.submitList(modelOrders);
            }
        });
//        navHostFragment = (NavHostFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.fragmentContainerView);
        navController= Navigation.findNavController(view);

    }

    @Override
    public void addItem(ModelOrder product) {
        boolean isAdded = shopViewModel.addItemTocart(product);
if(isAdded){
    Snackbar.make(requireView(),product.getPname()+"added to cart", Snackbar.LENGTH_LONG)
            .setAction("Checkout", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navController.navigate(R.id.action_shopFragment_to_cartFragment);
                }
            }).show();

}else{
    Snackbar.make(requireView(),"Already have the max quantity in cart", Snackbar.LENGTH_LONG)
            .show();
}
    }

    @Override
    public void onItemClick(ModelOrder product) {
        Log.d(TAG,"onItemClick:" +product.toString());
        shopViewModel.setProduct(product);
        navController.navigate(R.id.action_shopFragment_to_productFragment);

    }
}