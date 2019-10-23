package com.example.user.myapplication1.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.user.myapplication1.activity.ImageActivity;
import com.example.user.myapplication1.viewholder.ChildViewHolder;
import com.example.user.myapplication1.R;

import java.util.ArrayList;

public class ChildAdapter extends RecyclerView.Adapter<ChildViewHolder> {
    ArrayList<String> list;

    public ChildAdapter(ArrayList<String> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.second_list_item, viewGroup, false);
        return new ChildViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ChildViewHolder childViewHolder, int i) {
        final String iUrl = list.get(i);
        Glide.with(childViewHolder.imgView.getContext()).load(iUrl).into(childViewHolder.imgView);
        childViewHolder.imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ImageActivity.class);
                intent.putExtra("iUrl", iUrl);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
