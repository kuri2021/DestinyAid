package com.example.destinyaid;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

import java.util.ArrayList;

public class InformationActivity extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Item> items=new ArrayList<>();
    MyAdapter adapter;
    Spinner spinner;
    ArrayAdapter spinner_adapter;
    ViewPager2 vp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.informationtab,container,false);
        spinner=view.findViewById(R.id.spinner);
        spinner_adapter=ArrayAdapter.createFromResource(getActivity().getApplicationContext(),R.array.주간리셋활동,R.layout.spinner_selected);

        recyclerView=view.findViewById(R.id.crucible_recyclerview);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0://시련의장
                        recyclerView.removeAllViewsInLayout();
                        items.add(new Item(R.drawable.pvp,"점령","거점을 점령하고 상대를 처치하여 용맹을 획득하세요"));
                        adapter=new MyAdapter(getActivity(),items);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setBackgroundColor(0xff771111);
                        Toast.makeText(getContext(), "시련의장", Toast.LENGTH_SHORT).show();
                        break;
                    case 1://공격전,황혼전
                        recyclerView.removeAllViewsInLayout();
                        items.add(new Item(R.drawable.pve,"선봉대 공격전","선봉대가 도시의 적을 상대로 최우선 순위의 임무를 수행할 수로자를 찾고있습니다."));
                        adapter=new MyAdapter(getActivity(),items);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setBackgroundColor(0xff111177);
                        Toast.makeText(getContext(), "공격전", Toast.LENGTH_SHORT).show();
                        break;
                    case 2://레이드
                        break;
                    case 3://유로파
                        break;
                    case 4://기타
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
