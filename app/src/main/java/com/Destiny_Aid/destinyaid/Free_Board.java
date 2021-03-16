package com.Destiny_Aid.destinyaid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Free_Board extends Fragment {

    ArrayList<BoardItems> items=new ArrayList<BoardItems>();
    RecyclerView recyclerView;
    BoardAdapter adapter;

    TextView tv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.free_board,container,false);
        recyclerView=view.findViewById(R.id.recycler);
        adapter=new BoardAdapter(getActivity().getApplicationContext());
    }
}
