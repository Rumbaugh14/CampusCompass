package com.example.shane.campuscompass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddCoursesLayout extends AppCompatActivity {

    private TextView courseName;
    private Spinner location;
    private List<CheckBox> mCheckBoxes = new ArrayList<>();
    private TimePicker startTime;
    private TimePicker endTime;
    private Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_course_layout);


        courseName = (TextView)findViewById(R.id.CourseNameTextView);
        location = (Spinner)findViewById(R.id.LocationSpinner);

        mCheckBoxes = Arrays.asList(
                                    (CheckBox)findViewById(R.id.Monday),
                                    (CheckBox)findViewById(R.id.Tuesday),
                                    (CheckBox)findViewById(R.id.Wednesday),
                                    (CheckBox)findViewById(R.id.Thursday),
                                    (CheckBox)findViewById(R.id.Friday)
                                    );

        startTime = (TimePicker)findViewById(R.id.Start_TTP);
        endTime = (TimePicker)findViewById(R.id.End_TTP);
        addButton = (Button)findViewById(R.id.AddCourseButton);



    }


}
