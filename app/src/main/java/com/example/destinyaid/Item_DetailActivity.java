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
        String equipitemname_tv=intent.getStringExtra("equipitemname_tv");
        int equipitem_iv=intent.getIntExtra("equipitem_iv",R.drawable.pvp);
        int equipitemlock_iv=intent.getIntExtra("equipitemlock_iv",R.drawable.kinds);

        item_name.setText(equipitemname_tv);
        Glide.with(this).load(item_small).into(item_small);
        Glide.with(this).load(kinds).into(kinds);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            item_small.setTransitionName("equipitem_iv");
        }
    }
}