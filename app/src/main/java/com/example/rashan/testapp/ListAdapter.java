package com.example.rashan.testapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Rashan on 12/28/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int selectedPosition=-1;
    class ViewHolderRow extends RecyclerView.ViewHolder {
        public TextView title;
        public RelativeLayout relativeLayout;


        public ViewHolderRow(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.textView);
            relativeLayout = (RelativeLayout)view.findViewById(R.id.layout);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(position==selectedPosition)
            ((ViewHolderRow)holder).relativeLayout.setBackgroundColor(Color.GREEN);
        else
            ((ViewHolderRow)holder).relativeLayout.setBackgroundColor(Color.WHITE);
        ((ViewHolderRow)holder).title.setText(position+"");


    }

    @Override
    public int getItemCount() {
        return 10000;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list, parent, false);
        return new ViewHolderRow(itemView);
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }
}
