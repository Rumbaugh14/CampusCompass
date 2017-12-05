package com.example.shane.campuscompass;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddCoursesLayout extends AppCompatActivity {

    public static int num = 0;
    private TextView courseName;
    private Spinner location;
    private List<CheckBox> mCheckBoxes = new ArrayList<>();
    private TimePicker startTime;
    private TimePicker endTime;
    private Button addButton;

    //private ListView lvCourse;
    //private List<Course> mCourseList = new ArrayList<>();
    //private CourseListAdapter adapter = new CourseListAdapter(getContext(), mCourseList);


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


        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                //String name = courseName.getText().toString();
                String day = "Mon";
                String loc = "Burke";
                int t = 100;
                num++;
                Course currentClass = new Course(num, courseName.getText().toString(), loc, t, day);

                // --- Disregard these three following lines ---
                //mCourseList.add(currentClass);
                //adapter = new CourseListAdapter(getContext(), mCourseList);
                //lvCourse.setAdapter(adapter);

                //AddCoursesMain.AddCourse(currentClass);
                finish();
            }
        });

    }


}
