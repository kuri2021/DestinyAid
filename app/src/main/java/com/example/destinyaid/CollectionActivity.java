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

public class CollectionActivity extends Fragment {

    RecyclerView recyclerView;
    ArrayList<CollectionItem> collectionitems=new ArrayList<>();
    CollectionAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.collectiontab,container,false);
        recyclerView=view.findViewById(R.id.recycler_collection);

        collectionitems.add(new CollectionItem("name","0",R.drawable.ganbit2));
        adapter=new CollectionAdapter(getActivity(),collectionitems);
        recyclerView.setAdapter(adapter);


        return view;
    }
}
