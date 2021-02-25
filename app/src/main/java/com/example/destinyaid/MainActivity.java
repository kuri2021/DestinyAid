package com.example.destinyaid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kakao.sdk.user.UserApiClient;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        Intent intent=getIntent();
        String email=intent.getStringExtra("email");
        Toast.makeText(this, G.nickname+email , Toast.LENGTH_SHORT).show();



        //로그인후 첫페이지
        FragmentTransaction tran=fragmentManager.beginTransaction();
        tran.add(R.id.fragment,new InformationActivity());
        tran.commit();

        bnv=findViewById(R.id.bnv);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction tran=fragmentManager.beginTransaction();
                Fragment fragment=null;
                switch (item.getItemId()){
                    case R.id.bnv_information:
                        fragment=new InformationActivity();
                        tran.replace(R.id.fragment,fragment);
                        tran.commit();
                        break;
                    case R.id.bnv_inventory:
                        fragment=new InventoryActivity();
                        tran.replace(R.id.fragment,fragment);
                        tran.commit();
                        break;
                    case R.id.bnv_clan:
                        fragment=new Weekly_Reset();
                        tran.replace(R.id.fragment,fragment);
                        tran.commit();
                        break;
                    case R.id.bnv_collection:
                        fragment=new CollectionActivity();
                        tran.replace(R.id.fragment,fragment);
                        tran.commit();
                        break;
                    case R.id.bnv_logout:
                        Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);
                        UserApiClient.getInstance().logout(new Function1<Throwable, Unit>() {
                            @Override
                            public Unit invoke(Throwable throwable) {
                                if(throwable!=null){
                                    Toast.makeText(MainActivity.this, "로그아웃 fail", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(MainActivity.this, "로그아웃", Toast.LENGTH_SHORT).show();
                                }
                                return null;
                            }
                        });
                        break;
                }

                return true;
            }
        });
    }
}