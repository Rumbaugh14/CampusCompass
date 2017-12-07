package com.example.shane.campuscompass;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.shane.campuscompass.DatabaseHelper;
import com.example.shane.campuscompass.R;

import java.util.ArrayList;

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
        mListView = (ListView) findViewById(R.id.listViewHomework);
        mDatabaseHelper = new DatabaseHelper(this);

        populateListView();
    }

    private void populateListView() {
        Cursor data = mDatabaseHelper.getData();
        int count = 0;
        ArrayList<String> classData = new ArrayList<>();
        ArrayList<String> assignmentData = new ArrayList<>();
        ArrayList<String> dueDateData = new ArrayList<>();
        while(data.moveToNext())
        {
            if (count == 0)
            {
                classData.add(data.getString(0));
                assignmentData.add(data.getString(1));
                dueDateData.add(data.getString(2));
            }
            else{
                if(count == 2)
                {
                    count=0;
                }
                else
                {
                    count++;
                }
            }

        }

        ListAdapter adapter = new HomeworkAdapter(this, classData, assignmentData, dueDateData);
        mListView.setAdapter(adapter);
    }
}
