package com.example.firstapp;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class foundersViewAdapter extends RecyclerView.Adapter<foundersViewAdapter.ViewHolder>{
    List<FoudersListData> listdata;

    Context context;
    public foundersViewAdapter(List<FoudersListData> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.activity_founders_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoudersListData data = listdata.get(position);
        holder.tvName.setText(data.getName());
        holder.tvDesc.setText(data.getDesc());
        holder.ivimg.setImageResource(data.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FoundersDiscriptionActivity.class);
                intent.putExtra("name", data.getName());
                intent.putExtra("description", data.getDesc());
                intent.putExtra("image", data.getImage());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivimg;
        public TextView tvName;
        public TextView tvDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivimg=itemView.findViewById(R.id.img1);
            tvName=itemView.findViewById(R.id.tvname);
            tvDesc=itemView.findViewById(R.id.tvDesc);
        }
    }
}
