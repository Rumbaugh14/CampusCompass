package com.example.shane.campuscompass;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CreateHomework extends Fragment {

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd, btnViewData;
    private EditText editCourse, editAssignment, editDueDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.create_homework, container, false);

        btnAdd = (Button) v.findViewById(R.id.addAssignment);
        btnViewData = (Button) v.findViewById(R.id.viewAssignment);
        editCourse = (EditText) v.findViewById(R.id.editCourse);
        editAssignment = (EditText) v.findViewById(R.id.editAssignment);
        editDueDate = (EditText) v.findViewById(R.id.editDueDate);
        mDatabaseHelper = new DatabaseHelper(v.getContext());

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String newEntry1 = editCourse.getText().toString();
                String newEntry2 = editAssignment.getText().toString();
                String newEntry3 = editDueDate.getText().toString();
                if(editCourse.length() != 0 && editAssignment.length() != 0 && editDueDate.length() != 0)
                {
                    AddData(newEntry1, newEntry2, newEntry3, v);
                } else {
                    toastMessage("One or more fields do not contain data!", v);
                }
            }
        });

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeworkListActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }

    public void AddData(String newEntry1, String newEntry2, String newEntry3, View v)
    {
        boolean insertData = mDatabaseHelper.addData(newEntry1, newEntry2, newEntry3);

        if(insertData)
        {
            toastMessage("Data Successfully Inserted!", v);
        }
        else
        {
            toastMessage("Something went wrong.", v);
        }
    }

    private void toastMessage(String message, View v)
    {
        Toast.makeText(v.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
