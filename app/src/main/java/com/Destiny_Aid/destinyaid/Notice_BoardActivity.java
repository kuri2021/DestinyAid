package com.Destiny_Aid.destinyaid;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Notice_BoardActivity extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.free_board,container,false);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            String[] permission={Manifest.permission.WRITE_EXTERNAL_STORAGE};
            if (checkSel(permission[0]))==PackageManager.PERMISSION_DENIED;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
