package com.Destiny_Aid.destinyaid;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class InventoryActivity extends Fragment {

    TabLayout tabLayout;
    Spinner spinner_crt;
    ArrayAdapter spinner_adapter;
    String apiKey="49e6de48ae2748b98426b183ce2cd068";
    TextView tv;
    Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.inventorytab,container,false);
        spinner_crt=view.findViewById(R.id.job_class);
        spinner_adapter=ArrayAdapter.createFromResource(getContext(),R.array.job_class,R.layout.spinner_selected);
        spinner_crt.setAdapter(spinner_adapter);
        tv=view.findViewById(R.id.test_tv);
        btn=view.findViewById(R.id.btn);
        String url="https://www.bungie.net/platform/Destiny/Manifest/InventoryItem/1274330687/";




        FragmentTransaction transaction=getChildFragmentManager().beginTransaction();
        transaction.add(R.id.inventory_frame,new Fragment_Weapon());
        transaction.commit();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            URL obj=new URL(url);
                            HttpURLConnection con= (HttpURLConnection) obj.openConnection();

                            con.setRequestMethod("GET");
                            con.setRequestProperty("X-API-KEY",apiKey);
                            int responseCode=con.getResponseCode();
//            Log.d("contents","Response Code", responseCode);

                            BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()));
                            String inputLine;
                            String response="";
                            while((inputLine=in.readLine())!=null){
                                response+=inputLine;
                            }
                            in.close();

                            JsonParser parser = new JsonParser();
                            JsonObject json = (JsonObject) parser.parse(response);
                            JsonElement itemName=json.getAsJsonObject("Response");
                            Log.i("tag", String.valueOf(itemName));
                            tv.setText((CharSequence) itemName);



                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
            }
        });



//        tabLayout=view.findViewById(R.id.tab);
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                FragmentTransaction transaction=getFragmentManager().beginTransaction();
//                Fragment fragment;
//                switch (tab.getPosition()){
//                    case 0:
//                        fragment=new Fragment_Weapon();
//                        transaction.replace(R.id.inventory_frame,fragment);
//                        transaction.commit();
//                        break;
//                    case 1:
//                        fragment=new Fragment_Armor();
//                        transaction.replace(R.id.inventory_frame,fragment);
//                        transaction.commit();
//                        break;
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });


        return view;
    }
}
