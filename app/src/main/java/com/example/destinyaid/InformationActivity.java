package com.example.destinyaid;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class InformationActivity extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Item> items=new ArrayList<>();
    MyAdapter adapter;
    Spinner spinner;
    ArrayAdapter spinner_adapter;
    ViewPager2 vp;
    ArrayList<String> arrayList=new ArrayList<>();

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
                    case 0://시련의장
                        items.clear();
//                        items.add(new Item(R.drawable.pvp,"점령","거점을 점령하고 상대를 처치하여 용맹을 획득하세요"));
                        adapter=new MyAdapter(getActivity(),items);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setBackgroundColor(0xff771111);
                        break;
                    case 1://공격전,황혼전
                        items.clear();
                        new Thread(){
                            @Override
                            public void run() {
                                super.run();
                                Document document = null;
                                try {
                                    document = Jsoup.connect("https://resetde.ga/ordeal") .get();
                                    for(int i=0;i<100;i++){
                                        Elements title=document.select("h5").eq(i);
                                        Log.d("naver","title"+title.text());
                                    }

                                    for(int i=0;i<100;i++){
                                        Elements elements=document.select("p.text-light").eq(i);
                                        Log.d("naver","elements"+elements.text());
                                    }

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        }.start();
//                        items.add(new Item(R.drawable.pve,"선봉대 공격전","선봉대가 도시의 적을 상대로 최우선 순위의 임무를 수행할 수로자를 찾고있습니다."));
                        break;
                    case 2://레이드
                        items.clear();
                        items.add(new Item(R.drawable.pve,"선봉대 공격전","선봉대가 도시의 적을 상대로 최우선 순위의 임무를 수행할 수로자를 찾고있습니다."));
                        adapter=new MyAdapter(getActivity(),items);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setBackgroundColor(0xff111177);
                        break;
                    case 3://유로파
                        items.clear();
                        items.add(new Item(R.drawable.pve,"선봉대 공격전","선봉대가 도시의 적을 상대로 최우선 순위의 임무를 수행할 수로자를 찾고있습니다."));
                        adapter=new MyAdapter(getActivity(),items);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setBackgroundColor(0xff111177);
                        break;
                    case 4://기타
                        items.clear();
                        items.add(new Item(R.drawable.pve,"선봉대 공격전","선봉대가 도시의 적을 상대로 최우선 순위의 임무를 수행할 수로자를 찾고있습니다."));
                        adapter=new MyAdapter(getActivity(),items);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setBackgroundColor(0xff111177);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        return view;
    }



}
