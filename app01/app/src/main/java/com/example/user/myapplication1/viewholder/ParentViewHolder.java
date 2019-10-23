package com.example.user.myapplication1.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.myapplication1.R;

public class ParentViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public ImageButton imgb;
    public RecyclerView recyclerView;

    public ParentViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.cardview_text_view);
        imgb = itemView.findViewById(R.id.cardview_button);
        recyclerView = itemView.findViewById(R.id.cardview_recycler_view);
    }
}
