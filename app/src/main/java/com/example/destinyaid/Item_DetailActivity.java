package com.example.destinyaid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Item_DetailActivity extends AppCompatActivity {

    TextView item_name,item_kategorie,special_function_text,function1_text,function2_text,function3_text,function4_text,lore;
    ImageView item_full,item_small,kinds,special_function,function1,function2,function3,function4;
    View item_coller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item__detail);
        //TextView
        item_name=findViewById(R.id.item_name);
        item_kategorie=findViewById(R.id.item_kategorie);
        special_function_text=findViewById(R.id.special_function_text);
        function1_text=findViewById(R.id.function1_text);
        function2_text=findViewById(R.id.function2_text);
        function3_text=findViewById(R.id.function3_text);
        function4_text=findViewById(R.id.function4_text);
        lore=findViewById(R.id.lore);
        //ImageView
        item_full=findViewById(R.id.item_full);
        item_small=findViewById(R.id.item_small);
        kinds=findViewById(R.id.kinds);
        special_function=findViewById(R.id.special_function);
        function1=findViewById(R.id.function1);
        function2=findViewById(R.id.function2);
        function3=findViewById(R.id.function3);
        function4=findViewById(R.id.function4);
        //등급전용컬러
        item_coller=findViewById(R.id.item_coller);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        int imgId=intent.getIntExtra("img",R.drawable.ganbit2);
        item_name.setText(name);
        Glide.with(this).load(imgId).into(item_small);
    }
}