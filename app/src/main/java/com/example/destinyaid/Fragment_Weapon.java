package com.example.destinyaid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment_Weapon extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Item> items=new ArrayList<>();
    MyAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_weapon,container,false);

        recyclerView=view.findViewById(R.id.recycler_collection_weapon);
        items.add(new Item(R.drawable.pvp,"점령","거점을 점령하고 상대를 처치하여 용맹을 획득하세요"));
        adapter=new MyAdapter(getActivity(),items);
        recyclerView.setAdapter(adapter);


        return view;
    }
}
