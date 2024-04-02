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


public class DrinkFragment extends Fragment {
    private RecyclerView recyclerView;
    private Adapter Adapter;
    private List<Item> listData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_drink, container, false);

        recyclerView = view.findViewById(R.id.rvDrink);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        listData = new ArrayList<>();

        listData.add(new Item(R.drawable.dawetireng, "Es Dawet Ireng", "Es Dawet yang berasal dari daerah Butuh, Purworejo, Jawa Tengah. Kata ireng dari bahasa Jawa berarti hitam. Butiran dawet berwarna hitam"));
        listData.add(new Item(R.drawable.wedang_uwuh, "Wedang Uwuh", "Wedang uwuh adalah minuman dengan bahan-bahan yang berupa dedaunan mirip dengan rempah. Dalam bahasa Jawa, Wedang berarti minuman yang diseduh, sedangkan uwuh berarti sampah."));
        listData.add(new Item(R.drawable.jamu_temulawak, "Jamu Temulawak", "Minuman ini terkenal dengan khasiat obatnya dan telah digunakan selama berabad-abad dalam pengobatan tradisional Indonesia."));



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