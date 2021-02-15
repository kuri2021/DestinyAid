package com.example.destinyaid;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class InformationActivity extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Item> items=new ArrayList<>();
    MyAdapter adapter;
    ViewPager2 vp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.informationtab,container,false);


        items.add(new Item("점령","거점을 점령하고 상대를 처치하여 점수를 획득하시오"));
        items.add(new Item("점령","거점을 점령하고 상대를 처치하여 점수를 획득하시오"));
        items.add(new Item("점령","거점을 점령하고 상대를 처치하여 점수를 획득하시오"));
        items.add(new Item("점령","거점을 점령하고 상대를 처치하여 점수를 획득하시오"));
        items.add(new Item("점령","거점을 점령하고 상대를 처치하여 점수를 획득하시오"));
        items.add(new Item("점령","거점을 점령하고 상대를 처치하여 점수를 획득하시오"));
        items.add(new Item("점령","거점을 점령하고 상대를 처치하여 점수를 획득하시오"));
        recyclerView=view.findViewById(R.id.strike_recyclerview);
        adapter=new MyAdapter(getActivity(),items);
        recyclerView.setAdapter(adapter);
        return view;
    }

}
