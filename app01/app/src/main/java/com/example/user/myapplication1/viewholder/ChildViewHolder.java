package com.example.user.myapplication1.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.user.myapplication1.R;

public class ChildViewHolder extends RecyclerView.ViewHolder {
    public ImageView imgView;
    public ChildViewHolder(@NonNull View itemView) {
        super(itemView);
        imgView = itemView.findViewById(R.id.second_list_image_view);
    }
}
