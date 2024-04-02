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


public class FavoriteFragment extends Fragment {
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

        listData.add(new Item(R.drawable.dawetireng, "Es Dawet Ireng", "Enak dan Manis memiliki dawet yang lembut dan kenyal tak heran mirip boba dengan cita rasa traditional"));
        listData.add(new Item(R.drawable.nasi_pecel, "Nasi Pecel", "Nasi pecel dengan sambal kacang manis dan kadang pedas memiliki lauk berupa koyor atau peyek memiliki rasa yang authentic"));
        listData.add(new Item(R.drawable.bakso_malang, "Bakso Malang", "Rasa yang hangat dan lauk seperti pangsit yang melimpah menjadikannya favorit untuk semua kalangan"));



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