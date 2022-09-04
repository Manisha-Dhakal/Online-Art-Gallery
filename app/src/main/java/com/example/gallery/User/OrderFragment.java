package com.example.gallery.User;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gallery.R;
import com.example.gallery.ShopViewModel;
import com.example.gallery.databinding.FragmentOrderBinding;


public class OrderFragment extends Fragment {

NavController navController;
FragmentOrderBinding fragmentOrderBinding;
ShopViewModel shopViewModel;
    public OrderFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentOrderBinding = FragmentOrderBinding.inflate(inflater,container,false);
        return fragmentOrderBinding .getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);

        fragmentOrderBinding.continueShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopViewModel.resetcart();
                navController.navigate(R.id.action_orderFragment_to_shopFragment);

            }
        });
    }
}