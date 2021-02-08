package com.example.destinyaid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        //로그인후 첫페이지
        FragmentTransaction tran=fragmentManager.beginTransaction();
        tran.add(R.id.fragment,new InformationActivity());
        tran.commit();

        bnv=findViewById(R.id.bnv);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction tran=fragmentManager.beginTransaction();
                Fragment fragment;
                switch (item.getItemId()){
                    case R.id.bnv_information:
                        fragment=new InformationActivity();
                        break;
                    case R.id.bnv_inventory:
                        fragment=new InventoryActivity();
                        break;
                    case R.id.bnv_clan:
                        fragment=new ClanActivity();
                        break;
                    case R.id.bnv_collection:
                        fragment=new CollectionActivity();
                        break;
                    case R.id.bnv_logout:
                        break;
                }
                return true;
            }
        });
    }
}