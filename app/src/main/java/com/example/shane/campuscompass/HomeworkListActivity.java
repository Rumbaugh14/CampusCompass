package com.example.shane.campuscompass.dummy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.shane.campuscompass.DatabaseHelper;
import com.example.shane.campuscompass.R;

/**
 * Created by Zach on 12/5/2017.
 */

public class HomeworkListActivity extends AppCompatActivity{

    private static final String TAG  = "HomeworkListActivity";

    DatabaseHelper mDatabaseHelper;

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_item_list);
        mListView = (ListView) findViewById(R.id.list);
        mDatabaseHelper = new DatabaseHelper(this);

        populate
    }
}
