package com.program.Task2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

class RVAdapter extends RecyclerView.Adapter<ActHolder> {
    private final OnItemClickListener listener;
    private List<Activis> actA;

    RVAdapter(List<Activis> al, OnItemClickListener listene) {
        actA = al;
        listener = listene;
    }

    @Override
    public ActHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_act, parent, false);
        return new ActHolder(v);

    }

    @Override
    public void onBindViewHolder(ActHolder holder, int position) {

        holder.bind(actA.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return actA.size();
    }

    interface OnItemClickListener {
        void onItemClick(Activis item);
    }
}