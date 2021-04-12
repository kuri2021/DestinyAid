package com.Destiny_Aid.destinyaid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;
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

        


        items.add(new Collection_wonder_Item("가시","핸드캐논"
                ,R.drawable.thon
                ,R.drawable.kinds
                ,R.drawable.nasun
                ,R.drawable.accurized
                ,R.drawable.gost
                ,R.drawable.textured_grip));
        recyclerView=findViewById(R.id.recycler_collection_wonder);
        adapter= new Collection_wonder_Adapter(this,items);
        recyclerView.setAdapter(adapter);
        items.add(new Collection_wonder_Item("루미나","핸드캐논"
                ,R.drawable.lumina
                ,R.drawable.kinds
                ,R.drawable.sil
                ,R.drawable.accurized
                ,R.drawable.sky
                ,R.drawable.gobunja));
        recyclerView=findViewById(R.id.recycler_collection_wonder);
        adapter= new Collection_wonder_Adapter(this,items);
        recyclerView.setAdapter(adapter);
        items.add(new Collection_wonder_Item("매의 달","핸드캐논"
                ,R.drawable.horus
                ,R.drawable.kinds
                ,R.drawable.nasun
                ,R.drawable.gapgum
                ,R.drawable.notting
                ,R.drawable.soft));
        recyclerView=findViewById(R.id.recycler_collection_wonder);
        adapter= new Collection_wonder_Adapter(this,items);
        recyclerView.setAdapter(adapter);
        items.add(new Collection_wonder_Item("매의 달","핸드캐논"
                ,R.drawable.bubuq
                ,R.drawable.kinds
                ,R.drawable.nasun
                ,R.drawable.yunjang
                ,R.drawable.gulboc
                ,R.drawable.gobunja));
        recyclerView=findViewById(R.id.recycler_collection_wonder);
        adapter= new Collection_wonder_Adapter(this,items);
        recyclerView.setAdapter(adapter);
        items.add(new Collection_wonder_Item("스페이드 에이스","핸드캐논"
                ,R.drawable.spaceace
                ,R.drawable.kinds
                ,R.drawable.nasun
                ,R.drawable.big
                ,R.drawable.fire
                ,R.drawable.soft));
        recyclerView=findViewById(R.id.recycler_collection_wonder);
        adapter= new Collection_wonder_Adapter(this,items);
        recyclerView.setAdapter(adapter);
        items.add(new Collection_wonder_Item("유언","핸드캐논"
                ,R.drawable.lastword_small
                ,R.drawable.kinds
                ,R.drawable.nasun
                ,R.drawable.accurized
                ,R.drawable.hip_fire_grip
                ,R.drawable.textured_grip));
        recyclerView=findViewById(R.id.recycler_collection_wonder);
        adapter= new Collection_wonder_Adapter(this,items);
        recyclerView.setAdapter(adapter);
        items.add(new Collection_wonder_Item("진홍 핏자국","핸드캐논"
                ,R.drawable.gingong
                ,R.drawable.kinds
                ,R.drawable.sogugung
                ,R.drawable.accurized
                ,R.drawable.heal
                ,R.drawable.hip_fire_grip));
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