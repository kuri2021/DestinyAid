package com.example.destinyaid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Collection_Wonder extends AppCompatActivity {

    ArrayList<Collection_wonder_Item> items=new ArrayList<>();
    RecyclerView recyclerView;
    Collection_wonder_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection__wonder);

        items.add(new Collection_wonder_Item("test","test"
                ,R.drawable.lastword_small
                ,R.drawable.kinds
                ,R.drawable.ic_baseline_backpack_24
                ,R.drawable.ic_baseline_backpack_24
                ,R.drawable.ic_baseline_backpack_24
                ,R.drawable.ic_baseline_backpack_24));
        recyclerView=findViewById(R.id.recycler_collection_wonder);
        adapter= new Collection_wonder_Adapter(this,items);
        recyclerView.setAdapter(adapter);

    }
}