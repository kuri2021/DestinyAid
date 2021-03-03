package com.Destiny_Aid.destinyaid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;

public class Collection_Wonder extends AppCompatActivity {

    ArrayList<Collection_wonder_Item> items=new ArrayList<>();
    RecyclerView recyclerView;
    Collection_wonder_Adapter adapter;
    Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection__wonder);
        tb=findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_keyboard_backspace_24);
        getSupportActionBar().setTitle("");

        items.add(new Collection_wonder_Item("유언","test"
                ,R.drawable.lastword_small
                ,R.drawable.kinds
                ,R.drawable.nasun
                ,R.drawable.accurized
                ,R.drawable.hip_fire_grip
                ,R.drawable.textured_grip));
        recyclerView=findViewById(R.id.recycler_collection_wonder);
        adapter= new Collection_wonder_Adapter(this,items);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.collection_menu,menu);
        return true;
    }
    //    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.collection_menu, menu);
//        SearchView searchView= (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setMaxWidth(Integer.MAX_VALUE);
//        return false;
//    }
}