package com.example.codingstuff.JAVA;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codingstuff.ADAPTERS.Basic_Adv_Frag_Recycler_Adapter;
import com.example.codingstuff.R;

import java.util.ArrayList;

public class Java_Basic_frag extends Fragment {
    RecyclerView recyclerView;
    ArrayList<String>arrayList;
    String[]strings;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        strings=getResources().getStringArray(R.array.java_basic_topic);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.all_basic_adv_frags, container, false);

        recyclerView=v.findViewById(R.id.recycler_basic_adv_frags);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(new Basic_Adv_Frag_Recycler_Adapter(getActivity(),strings,"JAVA_BASIC"));

        return v;
    }
}