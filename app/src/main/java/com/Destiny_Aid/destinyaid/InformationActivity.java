package com.Destiny_Aid.destinyaid;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class InformationActivity extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Item> items=new ArrayList<>();
    MyAdapter adapter;
    Spinner spinner;
    ArrayAdapter spinner_adapter;
    Information_ViewPager_Adapter viewPager_adapter;
    ViewPager viewPager;
    ArrayList<Integer> img= new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.informationtab,container,false);
        spinner=view.findViewById(R.id.spinner);
        spinner_adapter=ArrayAdapter.createFromResource(getActivity().getApplicationContext(),R.array.주간리셋활동,R.layout.spinner_selected);
        spinner.setAdapter(spinner_adapter);
        spinner_adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        recyclerView=view.findViewById(R.id.crucible_recyclerview);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0://공격전
                        items.clear();
                        new Thread(){
                            @Override
                            public void run() {
                                super.run();
                                Document document=null;
                                try {
                                    document = Jsoup.connect("https://resetde.ga/main").get();
                                    for(int i=0;i<3;i++){
                                        Elements title=document.select("div.card-body").eq(0).select("h5").eq(i+1);
                                        Log.d("main_title","title"+title.text());
                                        Elements elements=document.select("div.card-body").eq(0).select("p.text-light").eq(i);
                                        Log.d("strike_Contents","elements"+elements.text());


                                        String title_striker=title.text();
                                        String content_striker=elements.text();
                                        items.add(new Item(R.drawable.striker2,title_striker,content_striker));
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                adapter=new MyAdapter(getActivity(),items);
                                                recyclerView.setAdapter(adapter);
                                                recyclerView.setBackgroundColor(0xff771111);
                                            }
                                        });

                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();

                        break;
                    case 1://전장
                        items.clear();
                        new Thread(){
                            @Override
                            public void run() {
                                super.run();
                                Document document=null;
                                try {
                                    document = Jsoup.connect("https://resetde.ga/main").get();
                                    for(int i=0;i<2;i++){
                                        Elements title=document.select("div.card-body").eq(1).select("h5").eq(i+1);
                                        Log.d("main_title","title"+title.text());
                                        Elements elements=document.select("div.card-body").eq(1).select("p.text-light").eq(i);
                                        Log.d("strike_Contents","elements"+elements.text());


                                        String title_striker=title.text();
                                        String content_striker=elements.text();
                                        items.add(new Item(R.drawable.juenjang,title_striker,content_striker));
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                adapter=new MyAdapter(getActivity(),items);
                                                recyclerView.setAdapter(adapter);
                                                recyclerView.setBackgroundColor(0xff111177);
                                            }
                                        });

                                    }


                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        }.start();
//
                        break;
                    case 2://황혼전 시련
                        items.clear();
                        new Thread(){
                            @Override
                            public void run() {
                                super.run();
                                Document document=null;
                                try {
                                    document = Jsoup.connect("https://resetde.ga/ordeal").get();
                                    for(int i=0;i<4;i++){
                                        Elements title=document.select("div.card col-lg-3 p-4").select("h5");
                                        Log.d("main_title","title"+title.text());
                                        Elements elements=document.select("div.card col-lg-3 p-4").eq(3).select("p.text-light").eq(i+1);
                                        Log.d("strike_Contents","elements"+elements.text());


                                        String title_striker=title.text();
                                        String content_striker=elements.text();
                                        items.add(new Item(R.drawable.pve,title_striker,content_striker));
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                adapter=new MyAdapter(getActivity(),items);
                                                recyclerView.setAdapter(adapter);
                                                recyclerView.setBackgroundColor(0xffff4400);
                                            }
                                        });

                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        break;
                    case 3://잊혀진구역
                        items.clear();
                        new Thread(){
                            @Override
                            public void run() {
                                super.run();
                                Document document=null;
                                try {
                                    document = Jsoup.connect("https://resetde.ga/lost").get();
                                     //전설잊구
                                    Element title=document.select("h4").first();
                                        Log.d("main_title","title"+title.text());
                                        Elements elements=document.select("p").eq(1);
                                        Log.d("strike_Contents","elements"+elements.text());

                                        String title_striker=title.text();
                                        String content_striker=elements.text();
                                        items.add(new Item(R.drawable.lost,title_striker,content_striker));
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                adapter=new MyAdapter(getActivity(),items);
                                                recyclerView.setAdapter(adapter);
                                                recyclerView.setBackgroundColor(0xff444444);
                                            }});
                                     // 마스터잊구
                                    Elements title2=document.select("h4").eq(1);
                                    Log.d("main_title","title"+title.text());
                                    Elements elements2=document.select("p").eq(13);
                                    Log.d("strike_Contents","elements"+elements.text());

                                    String title_striker2=title2.text();
                                    String content_striker2=elements2.text();
                                    items.add(new Item(R.drawable.lost,title_striker2,content_striker2));
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            adapter=new MyAdapter(getActivity(),items);
                                            recyclerView.setAdapter(adapter);
                                            recyclerView.setBackgroundColor(0xff444444);
                                        }});


                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        break;
                    case 4://오시리스의시험
                        items.clear();
                        new Thread(){
                            @Override
                            public void run() {
                                super.run();
                                Document document=null;
                                try {
                                    document = Jsoup.connect("https://resetde.ga/trials").get();
                                    for(int i=0;i<4;i++){
                                        Elements title=document.select("h4").eq(i);
                                        Log.d("main_title","title"+title.text());
                                        Elements elements=document.select("div.card col-lg-3 p-4").eq(3).select("p.text-light").eq(i+1);
                                        Log.d("strike_Contents","elements"+elements.text());


                                        String title_striker=title.text();
                                        String content_striker=elements.text();
                                        if(content_striker!=""){
                                            items.add(new Item(R.drawable.osiris,title_striker,content_striker));
                                        }else{
                                            items.add(new Item(R.drawable.osiris,title_striker,"???"));
                                        }

                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                adapter=new MyAdapter(getActivity(),items);
                                                recyclerView.setAdapter(adapter);
                                                recyclerView.setBackgroundColor(0xffffaa00);
                                            }
                                        });

                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        break;
                    case 5://레이드
                        items.clear();
                        new Thread(){
                            @Override
                            public void run() {
                                super.run();
                                Document document=null;
                                try {
                                    document = Jsoup.connect("https://resetde.ga/raid").get();
                                    for(int i=0;i<3;i++){
                                        Elements title=document.select("h4").eq(i);
                                        Log.d("main_title","title"+title.text());
                                        Elements elements=document.select("p.text-light").eq(i);
                                        Log.d("strike_Contents","elements"+elements.text());


                                        String title_striker=title.text();
                                        String content_striker=elements.text();
                                        items.add(new Item(R.drawable.raid,title_striker,content_striker));
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                adapter=new MyAdapter(getActivity(),items);
                                                recyclerView.setAdapter(adapter);
                                                recyclerView.setBackgroundColor(0xff000000);
                                            }
                                        });

                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        viewPager=view.findViewById(R.id.pager);
        img.add(R.drawable.calender);
        viewPager_adapter=new Information_ViewPager_Adapter(getActivity().getApplicationContext(),img);
        viewPager.setAdapter(viewPager_adapter);

        return view;
    }
}
