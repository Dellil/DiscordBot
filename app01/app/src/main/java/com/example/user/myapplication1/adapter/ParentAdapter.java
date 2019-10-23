package com.example.user.myapplication1.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.user.myapplication1.viewholder.ParentViewHolder;
import com.example.user.myapplication1.R;
import com.example.user.myapplication1.vo.LinkVO;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ParentAdapter extends RecyclerView.Adapter<ParentViewHolder> {
    ArrayList<LinkVO> list;
    RecyclerView.RecycledViewPool rvp;
    public ParentAdapter(ArrayList<LinkVO> vo) {
        list = vo;
        rvp = new RecyclerView.RecycledViewPool();
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ParentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder parentViewHolder, int i) {
        parentViewHolder.textView.setText(list.get(i).getTime());
        ArrayList<String> linkList = list.get(i).getLinks();

        LinearLayoutManager llm = new LinearLayoutManager(parentViewHolder.recyclerView.getContext(), LinearLayout.HORIZONTAL, false);
        llm.setInitialPrefetchItemCount(5);
        parentViewHolder.recyclerView.setLayoutManager(llm);
        parentViewHolder.recyclerView.setAdapter(new ChildAdapter(linkList));
        parentViewHolder.recyclerView.setRecycledViewPool(rvp);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
