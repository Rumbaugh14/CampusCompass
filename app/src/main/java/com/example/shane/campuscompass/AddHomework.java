package com.example.shane.campuscompass;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Zach on 11/10/2017.
 */

public class AddHomework extends Fragment {

    private static final String TAG = "AddHomework";

    DatabaseHelper hwDB;
    private Button btnAdd, btnViewData;
    private EditText editCourse, editAssignment, editDueDate;

    public AddHomework() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.add_homework, container, false);


        editCourse = (EditText) v.findViewById(R.id.courseField);
        editAssignment = (EditText) v.findViewById(R.id.assignmentField);
        editDueDate = (EditText) v.findViewById(R.id.dueDateField);
        btnAdd = (Button) v.findViewById(R.id.addButton);
        btnViewData = (Button) v.findViewById(R.id.viewButton);
        hwDB = new DatabaseHelper(getActivity());

        AddData();
        ViewData();

        return v;
    }

    public void AddData(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String course = editCourse.getText().toString();
                String assignment = editAssignment.getText().toString();
                String dueDate = editDueDate.getText().toString();

                if (editCourse.length() != 0 && editAssignment.length() != 0 && editDueDate.length() != 0){
                    boolean insertData = hwDB.addData(course, assignment, dueDate);

                    if (insertData == true) {
                        Toast.makeText(getActivity(), "Data Successfully Inserted!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Something went wrong.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "You must enter data.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void ViewData() {
        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeworkList.class);
                startActivity(intent);
            }
        });
    }

}
