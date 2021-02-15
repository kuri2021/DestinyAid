package com.example.destinyaid;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class InformationActivity extends Fragment {

    Context context;
    ImageView iv_strike,iv_beyondlight;
    ViewPager2 vp;
    int id=0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.informationtab,container,false);
        iv_strike=view.findViewById(R.id.iv_strike);
        iv_beyondlight=view.findViewById(R.id.iv_beyondlight);
        context=container.getContext();

        iv_strike.setOnClickListener(listener);



        iv_strike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "확인", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id=getId();
            switch (id){
                case R.id.iv_strike :

            }
        }
    };



}
