package com.example.gallery.User;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gallery.CartItem;
import com.example.gallery.CartListAdapter;
import com.example.gallery.R;
import com.example.gallery.ShopViewModel;
import com.example.gallery.Util.DBHandler;
import com.example.gallery.databinding.FragmentCartBinding;

import java.util.List;


public class CartFragment extends Fragment implements CartListAdapter.CartInterface {

    private static final String TAG = "CartFragment";
    ShopViewModel shopViewModel;
    FragmentCartBinding fragmentCartBinding;
    NavController navController;
    DBHandler dbHandler;
    ImageView image;
    TextView heading, totalprice;
    Button  button;

    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCartBinding= FragmentCartBinding.inflate(inflater,container,false);
        return  fragmentCartBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController= Navigation.findNavController(view);
        final CartListAdapter cartListAdapter = new CartListAdapter(this);
        fragmentCartBinding.cartrecyclerview.setAdapter(cartListAdapter);
        fragmentCartBinding.cartrecyclerview.addItemDecoration(new DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL));
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);

        button= (Button) view.findViewById(R.id.btnplaceorder);
        //
        shopViewModel.getCart().observe(getViewLifecycleOwner(), new Observer<List<CartItem>>() {
            @Override
            public void onChanged(List<CartItem> cartItems) {
               cartListAdapter.submitList(cartItems);
               fragmentCartBinding.btnplaceorder.setEnabled(cartItems.size()>0);
            }
        });
        shopViewModel.getTotalPrice().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
             fragmentCartBinding.totalprice.setText("Total: $"+aDouble.toString());
            }
        });
        fragmentCartBinding.btnplaceorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            navController.navigate(R.id.action_cartFragment_to_orderFragment);
            }
        });
    }

    @Override
    public void deleteItem(CartItem cartItem) {
      shopViewModel.removeItemFromCart(cartItem);
    }

    @Override
    public void changeQuantity(CartItem cartItem, int quantity) {
     shopViewModel.changeQuantity(cartItem,quantity);
    }

}