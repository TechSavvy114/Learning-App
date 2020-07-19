package com.example.codingstuff.ADAPTERS;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codingstuff.R;
import com.example.codingstuff.Videos;
import com.example.codingstuff.YouTubePlayer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Video_Adapter extends RecyclerView.Adapter<Video_Adapter.ViewHolder> {
    Context context;
    ArrayList<Videos>arrayList;
    String TAG;
    public Video_Adapter(Context context, ArrayList<Videos> arrayList, String TAG) {
        this.context = context;
        this.arrayList = arrayList;
        this.TAG=TAG;
    }

    @NonNull
    @Override
    public Video_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_adapter_main,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Video_Adapter.ViewHolder holder, int position) {
        Picasso.get().load(arrayList.get(position).getName()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView=itemView.findViewById(R.id.imageView);
            itemView.setClickable(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(TAG.equals("JAVA")) {
                        Intent intent = new Intent(context, YouTubePlayer.class);
                        intent.putExtra("position", arrayList.get(getAdapterPosition()).getVideo());
                        context.startActivity(intent);
                    }
                    else if(TAG.equals("C++")){
                        Intent intent = new Intent(context, YouTubePlayer.class);
                        intent.putExtra("position", arrayList.get(getAdapterPosition()).getVideo());
                        context.startActivity(intent);
                    }
                    else if(TAG.equals("KOTLIN")){
                        Intent intent = new Intent(context, YouTubePlayer.class);
                        intent.putExtra("position", arrayList.get(getAdapterPosition()).getVideo());
                        context.startActivity(intent);
                    }
                    else if(TAG.equals("C#")){
                        Intent intent = new Intent(context, YouTubePlayer.class);
                        intent.putExtra("position", arrayList.get(getAdapterPosition()).getVideo());
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}
