package com.example.codingstuff.ADAPTERS;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codingstuff.Java_Topics_Details;
import com.example.codingstuff.R;

public class Basic_Adv_Frag_Recycler_Adapter extends RecyclerView.Adapter<Basic_Adv_Frag_Recycler_Adapter.ViewHolder> {

    Context context;
    String[] arrayList;
    String TAG;

    public Basic_Adv_Frag_Recycler_Adapter(Context context, String[] arrayList, String TAG) {
        this.context = context;
        this.arrayList = arrayList;
        this.TAG=TAG;
    }

    @NonNull
    @Override
    public Basic_Adv_Frag_Recycler_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.adv_basic_adapter_layout,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Basic_Adv_Frag_Recycler_Adapter.ViewHolder holder, int position) {
        holder.textView.setText(arrayList[position]);
    }

    @Override
    public int getItemCount() {
        return arrayList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView=itemView.findViewById(R.id.java_adapter_text);
            itemView.setClickable(true);
            itemView.setFocusable(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(TAG.equals("C_PLUS_ADV")) {
                        Intent intent = new Intent(context, Java_Topics_Details.class);
                        intent.putExtra("position", getAdapterPosition());
                        intent.putExtra("file", "c_plus-adv");
                        context.startActivity(intent);
                    }
                    else if(TAG.equals("C_PLUS_BASIC")){
                        Intent intent = new Intent(context, Java_Topics_Details.class);
                        intent.putExtra("position", getAdapterPosition());
                        intent.putExtra("file", "c_plus-basic");
                        context.startActivity(intent);

                    }
                    else if(TAG.equals("KOTLIN_ADV")){
                        Intent intent = new Intent(context, Java_Topics_Details.class);
                        intent.putExtra("position", getAdapterPosition());
                        intent.putExtra("file", "Kotlin_adv");
                        context.startActivity(intent);

                    }
                    else if(TAG.equals("KOTLIN_BASIC")){
                        Intent intent = new Intent(context, Java_Topics_Details.class);
                        intent.putExtra("position", getAdapterPosition());
                        intent.putExtra("file", "Kotlin_basic");
                        context.startActivity(intent);

                    }
                    else if(TAG.equals("JAVA_ADV")){
                        Intent intent = new Intent(context, Java_Topics_Details.class);
                        intent.putExtra("position", getAdapterPosition());
                        intent.putExtra("file", "java_adv");
                        context.startActivity(intent);

                    }
                    else if(TAG.equals("JAVA_BASIC")){
                        Intent intent = new Intent(context, Java_Topics_Details.class);
                        intent.putExtra("position", getAdapterPosition());
                        intent.putExtra("file", "java_basic");
                        context.startActivity(intent);

                    }
                    else if(TAG.equals("C_SHARP_BASIC")){
                        Intent intent = new Intent(context, Java_Topics_Details.class);
                        intent.putExtra("position", getAdapterPosition());
                        intent.putExtra("file", "c_sharp_basic");
                        context.startActivity(intent);

                    }
                    else if(TAG.equals("C_SHARP_ADV")){
                        Intent intent = new Intent(context, Java_Topics_Details.class);
                        intent.putExtra("position", getAdapterPosition());
                        intent.putExtra("file", "c_sharp_adv");
                        context.startActivity(intent);

                    }
                }
            });
        }
    }
}
