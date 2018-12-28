package com.example.rashan.testapp;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        final ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                highlightMiddleItem(linearLayoutManager,listAdapter);

            }
        });

        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
               highlightMiddleItem(linearLayoutManager,listAdapter);
            }
        },300);



    }

    public void highlightMiddleItem(LinearLayoutManager linearLayoutManager, ListAdapter listAdapter){
        synchronized (this){
            int firstItem = linearLayoutManager.findFirstVisibleItemPosition();
            int lastItem = linearLayoutManager.findLastVisibleItemPosition();
            int middleItem = Math.abs(lastItem - firstItem) / 2 + firstItem;
            listAdapter.setSelectedPosition(middleItem);
            listAdapter.notifyDataSetChanged();
        }
    }



}
