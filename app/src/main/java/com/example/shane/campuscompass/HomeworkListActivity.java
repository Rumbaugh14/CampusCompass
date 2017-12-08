package com.example.shane.campuscompass;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shane.campuscompass.DatabaseHelper;
import com.example.shane.campuscompass.R;

import java.util.ArrayList;

/**
 * Created by Zach on 12/5/2017.
 */

public class HomeworkListActivity extends AppCompatActivity {

    private static final String TAG = "HomeworkListActivity";

    DatabaseHelper mDatabaseHelper;

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_item_list);
        mListView = (ListView) findViewById(R.id.listViewHomework);
        mDatabaseHelper = new DatabaseHelper(this);

        populateListView();
    }

    private void populateListView() {
        final Cursor data = mDatabaseHelper.getData();
        int count = 0;
        final ArrayList<String> classData = new ArrayList<>();
        final ArrayList<String> assignmentData = new ArrayList<>();
        final ArrayList<String> dueDateData = new ArrayList<>();
        while (data.moveToNext()) {
            if (count == 0) {
                classData.add(data.getString(0));
                assignmentData.add(data.getString(1));
                dueDateData.add(data.getString(2));
            } else {
                if (count == 2) {
                    count = 0;
                } else {
                    count++;
                }
            }

        }

        ListAdapter adapter = new HomeworkAdapter(this, classData, assignmentData, dueDateData);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String course = (String) classData.get(i);
                String dueDate = (String) dueDateData.get(i);
                String assignment = (String) assignmentData.get(i);

                Cursor data = mDatabaseHelper.getItemID(course, dueDate, assignment);
                int itemID = -1;

                while (data.moveToNext()) {
                    itemID = data.getInt(0);
                }

                if (itemID >= 1) {
                    Intent editScreenIntent = new Intent(HomeworkListActivity.this, HomeworkEditActivity.class);
                    editScreenIntent.putExtra("id", itemID);
                    editScreenIntent.putExtra("course", course);
                    editScreenIntent.putExtra("dueDate", dueDate);
                    editScreenIntent.putExtra("assignment", assignment);
                    startActivity(editScreenIntent);
                    finish();
                } else {
                    toastMessage("No ID associated with that assignment");
                }
            }
        });
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
