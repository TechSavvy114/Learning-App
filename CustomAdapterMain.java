package com.example.codingstuff;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapterMain extends RecyclerView.Adapter<CustomAdapterMain.ViewHolder>{
    ArrayList<Videos>arrayList;
    Context context;

    public CustomAdapterMain(ArrayList<Videos> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapterMain.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.custom_adapter_main,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterMain.ViewHolder holder, int position) {
        Uri uri=Uri.parse(arrayList.get(position).getName());
        Picasso.get().load(uri).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView=itemView.findViewById(R.id.imageView);
            itemView.setClickable(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,VideoPlay.class);
                    intent.putExtra("position",arrayList.get(getAdapterPosition()).getVideo());
                    context.startActivity(intent);
                }
            });
        }
    }
}
