package com.example.destinyaid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment_Armor extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Item> items=new ArrayList<>();
    MyAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_armor,container,false);

        recyclerView=view.findViewById(R.id.recycler_collection_armor);
        items.add(new Item(R.drawable.pve,"선봉대 공격전","선봉대가 도시의 적을 상대로 최우선 순위의 임무를 수행할 수로자를 찾고있습니다."));
        adapter=new MyAdapter(getActivity(),items);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
