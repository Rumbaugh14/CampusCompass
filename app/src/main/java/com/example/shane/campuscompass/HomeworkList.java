package com.example.shane.campuscompass;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.shane.campuscompass.dummy.DummyContent;
import com.example.shane.campuscompass.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;


public class HomeworkList extends ListFragment {

    public static final String TAG = "HomeworkList";

    DatabaseHelper mDatabaseHelper;

    private ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_list, container, false);

        mListView = (ListView) v.findViewById(R.id.list);
        mDatabaseHelper = new DatabaseHelper(v.getContext());

        populateListView(v);
        
        return v;
    }

    private void populateListView(View v) {
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));
            listData.add(data.getString(2));
            listData.add(data.getString(3));
        }
        ListAdapter adapter = new ArrayAdapter<>(v.getContext(), android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);
    }

}
