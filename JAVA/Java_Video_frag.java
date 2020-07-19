package com.example.codingstuff.JAVA;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codingstuff.ADAPTERS.Video_Adapter;
import com.example.codingstuff.R;
import com.example.codingstuff.Videos;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Java_Video_frag extends Fragment {

    RecyclerView recyclerView;
    Video_Adapter videoAdapter;
    DatabaseReference myRef;
    ArrayList<Videos>arrayList;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.video_frags, container, false);

        recyclerView=view.findViewById(R.id.recycler_vid_java);
        arrayList=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        videoAdapter =new Video_Adapter(getActivity(),arrayList,"JAVA");
        recyclerView.setAdapter(videoAdapter);
        getArrayList();

        return view;
    }

    private void getArrayList() {
        myRef=FirebaseDatabase.getInstance().getReference().child("Java_Youtube");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChildren()){
                    for (DataSnapshot cData:snapshot.getChildren()){
                        String name=cData.child("a").getValue(String.class);
                        String video=cData.child("vid").getValue(String.class);
                        Log.d("image",name);
                        Log.d("video",video);
                        Videos videos=new Videos();
                        videos.setName(name);
                        videos.setVideo(video);
                        arrayList.add(videos);
                        videoAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}