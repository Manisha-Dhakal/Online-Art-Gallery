package com.example.gallery.User;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gallery.R;
import com.example.gallery.ShopViewModel;
import com.example.gallery.databinding.FragmentProductBinding;


public class ProductFragment extends Fragment {


    FragmentProductBinding fragmentProductBinding;
    ShopViewModel shopViewModel;

    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentProductBinding= FragmentProductBinding.inflate(inflater,container,false);
        return fragmentProductBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shopViewModel= new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        fragmentProductBinding.setGet(shopViewModel);
    }
}