package com.agamjyot.android.wizwackassignmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    initialising variables
    SwipeRefreshLayout swipeRefreshLayout;
    ListView listView;
    ArrayAdapter<Integer> adapter;

    ArrayList<Integer> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        assign variables
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        listView = findViewById(R.id.list_view);

//        initialising arrayList
        arrayList = new ArrayList<>();

//        adding values in the arrayList
        arrayList.add(1);

//        initialising Adapter
        adapter = new ArrayAdapter<>(this,
                R.layout.view_item, arrayList);

//        set Adapter
        listView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(() -> {
//                Adding new item to the list on each refresh
            arrayList.add(arrayList.size() + 1);

//                notifying adapter
            adapter.notifyDataSetChanged();

//                dismissing the swipeRefresh symbol
            swipeRefreshLayout.setRefreshing(false);
        });
    }
}