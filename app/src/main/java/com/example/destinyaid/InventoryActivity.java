package com.example.destinyaid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.sql.Array;

public class InventoryActivity extends Fragment {

    TabLayout tabLayout;
    Spinner spinner_crt;
    ArrayAdapter spinner_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.inventorytab,container,false);
        spinner_crt=view.findViewById(R.id.job_class);
        spinner_adapter=ArrayAdapter.createFromResource(getContext(),R.array.job_class,R.layout.spinner_selected);
        spinner_crt.setAdapter(spinner_adapter);

        FragmentTransaction transaction=getChildFragmentManager().beginTransaction();
        transaction.add(R.id.inventory_frame,new Fragment_Weapon());
        transaction.commit();


        tabLayout=view.findViewById(R.id.tab);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                Fragment fragment;
                switch (tab.getPosition()){
                    case 0:
                        fragment=new Fragment_Weapon();
                        transaction.replace(R.id.inventory_frame,fragment);
                        transaction.commit();
                        break;
                    case 1:
                        fragment=new Fragment_Armor();
                        transaction.replace(R.id.inventory_frame,fragment);
                        transaction.commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return view;
    }
}
