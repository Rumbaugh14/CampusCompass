package com.example.shane.campuscompass;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Zach on 12/6/2017.
 */

public class HomeworkEditActivity extends AppCompatActivity {

    private static final String TAG = "HomeworkEditActivity";

    DatabaseHelper mDatabaseHelper;
    private Button btnSaveData, btnDeleteData;
    private EditText editCourseExisting, editAssignmentExisting, editDueDateExisting;

    private String selectedCourse;
    private String selectedDueDate;
    private String selectedAssignment;
    private int selectedID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_homework_layout);

        btnSaveData = (Button) findViewById(R.id.saveAssignment);
        btnDeleteData = (Button) findViewById(R.id.deleteAssignment);
        editCourseExisting = (EditText) findViewById(R.id.editCourseExisting);
        editAssignmentExisting = (EditText) findViewById(R.id.editAssignmentExisting);
        editDueDateExisting = (EditText) findViewById(R.id.editDueDateExisting);
        mDatabaseHelper = new DatabaseHelper(this);

        Intent receivedIntent = getIntent();

        selectedID = receivedIntent.getIntExtra("id", -1);

        selectedCourse = receivedIntent.getStringExtra("course");
        selectedDueDate = receivedIntent.getStringExtra("dueDate");
        selectedAssignment = receivedIntent.getStringExtra("assignment");

        editCourseExisting.setText(selectedCourse);
        editAssignmentExisting.setText(selectedAssignment);
        editDueDateExisting.setText(selectedDueDate);

        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry1 = editCourseExisting.getText().toString();
                String newEntry2 = editAssignmentExisting.getText().toString();
                String newEntry3 = editDueDateExisting.getText().toString();
                if(editCourseExisting.length() != 0 && editAssignmentExisting.length() != 0 && editDueDateExisting.length() != 0)
                {
                    mDatabaseHelper.updateData(newEntry1, newEntry2, newEntry3, selectedID, selectedCourse, selectedAssignment, selectedDueDate);

                    finish();
                } else {
                    toastMessage("One or more fields do not contain data!");
                }


            }
        });

        btnDeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseHelper.deleteData(selectedID, selectedCourse, selectedAssignment, selectedDueDate);
                editCourseExisting.setText("");
                editAssignmentExisting.setText("");
                editDueDateExisting.setText("");
                toastMessage("Removed from Assignments");
                finish();
            }
        });
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
