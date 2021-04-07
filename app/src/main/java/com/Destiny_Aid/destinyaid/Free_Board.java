package com.Destiny_Aid.destinyaid;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Free_Board extends Fragment implements View.OnClickListener{
    FloatingActionButton edtbtn;
    ArrayList<BoardItems> items=new ArrayList<BoardItems>();
    RecyclerView recyclerView;
    BoardAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.free_board, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        edtbtn=view.findViewById(R.id.edtbtn);
        String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), permissions[0]) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(getActivity(), permissions, 100);
        }
        edtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getActivity(), EditActivity.class);
                startActivity(intent);
            }
        });
//        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
//            String[] permissions={Manifest.permission.WRITE_EXTERNAL_STORAGE};
//            if(getActivity().checkSelfPermission(permissions[0])== PackageManager.PERMISSION_DENIED){
//                requestPermissions(permissions, 100);
//            }
//        }
//        return view;
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        if(requestCode==100 && grantResults[0]==PackageManager.PERMISSION_DENIED){
//
//        }
//    }
//    public void clickSelect(View view){
//
//    }
        return view;
    }

    @Override
    public void onClick(View v) {
    }
}

