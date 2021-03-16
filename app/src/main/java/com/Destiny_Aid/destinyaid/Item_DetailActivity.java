package com.Destiny_Aid.destinyaid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Item_DetailActivity extends AppCompatActivity {

    TextView item_name,item_kategorie,special_function_text,function1_text,function2_text,function3_text,function4_text,lore;
    ImageView item_full,item_small,kinds,special_function,function1,function2,function3,function4,comment_img;
    View item_coller;
    EditText et_cmt=findViewById(R.id.et_cmt);;
    TextView test_tv;



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
        int imgId=intent.getIntExtra("img",R.drawable.osiris);
        item_name.setText(name);
        Glide.with(this).load(imgId).into(item_small);
    }

    @Override
    protected void onResume() {
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl("http://kuri.dothome.co.kr");//기본주소
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();



        super.onResume();
    }
    //    public void click_success(View view) {
//        String comment=et.getText().toString();
//    }

    public void click_success(View view) {
        new Thread(){
            @Override
            public void run() {
                String et=et_cmt.getText().toString();

                String serverUrl="http://kuri.dothome.co.kr/Destiny/getcmt.php";
            }
        }.start();
    }
}