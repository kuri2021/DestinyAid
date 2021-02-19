package com.example.destinyaid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Collection_Wonder extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Collection_wonder_Item> collectionWonderItems=new ArrayList<>();
    Collection_wonder_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection__wonder);
        recyclerView=findViewById(R.id.recycler_collection_wonder);

        collectionWonderItems.add(new Collection_wonder_Item(
                "lastword",
                "handcanon",
                R.drawable.ic_baseline_arrow_circle_up_24,
                R.drawable.ic_baseline_arrow_circle_up_24,
                R.drawable.ic_baseline_arrow_circle_up_24,
                R.drawable.ic_baseline_arrow_circle_up_24,
                R.drawable.ic_baseline_arrow_circle_up_24,
                R.drawable.ic_baseline_arrow_circle_up_24));

        adapter=new Collection_wonder_Adapter(this,collectionWonderItems);
        recyclerView.setAdapter(adapter);


    }
}