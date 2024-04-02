package com.example.navigationdrawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationdrawer.Item;
import com.example.navigationdrawer.Adapter;
import com.example.navigationdrawer.R;
import com.example.navigationdrawer.Adapter;
import com.example.navigationdrawer.Item;

import java.util.ArrayList;
import java.util.List;


public class FoodFragment extends Fragment {
    private RecyclerView recyclerView;
    private Adapter Adapter;
    private List<Item> listData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_food, container, false);

        recyclerView = view.findViewById(R.id.rvFood);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        listData = new ArrayList<>();

        listData.add(new Item(R.drawable.sego_gandul, "Sego Gandul", "Sego Gandul adalah hidangan khas Jawa Tengah yang terdiri dari nasi yang dimasak dengan daging sapi dan rempah-rempah, disajikan dengan kuah kental khas yang terbuat dari santan dan bumbu rempah."));
        listData.add(new Item(R.drawable.nasi_pecel, "Nasi Pecel", "Nasi pecel adalah hidangan Indonesia dengan nasi putih, sayuran, dan bumbu pecel (saus kacang). Nasi Pecel Madiun adalah varian populer dari Madiun, Jawa Timur, dengan sayuran seperti kacang panjang, tauge, dan kangkung"));
        listData.add(new Item(R.drawable.bakso_malang, "Bakso Malang", "Bakso Malang adalah variasi khusus dari bakso yang berasal dari Kota Malang, Jawa Timur, Indonesia. Bakso Malang memiliki ciri khas tertentu yang membedakannya dari bakso lainnya."));



        Adapter = new Adapter(getContext(), listData);


        recyclerView.setAdapter(Adapter);


        Adapter.setItemClickListener(new Adapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, Item item) {

            }
        });

        return view;
    }
}