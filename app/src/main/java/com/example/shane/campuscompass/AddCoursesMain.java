package com.example.shane.campuscompass;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class AddCoursesMain extends ListFragment{

    private ListView lvCourse;
    private List<String> mCourseList = new ArrayList<>();
    private CourseListAdapter adapter ;
    private FloatingActionButton mFaB;
    private CoursesDatabase coursesDatabase;
    private Cursor data;
    public AddCoursesMain() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {View v = inflater.inflate(R.layout.fragment_add_courses_main, container, false);
        lvCourse = v.findViewById(android.R.id.list);
        mFaB = v.findViewById(R.id.FaB_AddCourse);
        mCourseList = new ArrayList<>();
        coursesDatabase = new CoursesDatabase(getContext());
        mFaB.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent in = new Intent(getActivity(), AddCoursesLayout.class);
                startActivity(in);
            }
        });
        populate();
        return v;
    }



    private void populate(){
        final Cursor data = coursesDatabase.getData();
        int count =0;

        final ArrayList<String> courseName = new ArrayList<>();
        final ArrayList<String> courseLocation = new ArrayList<>();
        final ArrayList<String> courseStartTime = new ArrayList<>();
        final ArrayList<String> courseEndTime = new ArrayList<>();
        final ArrayList<String> courseDoW = new ArrayList<>();

        while(data.moveToNext()){
            if(count == 0){
                courseName.add(data.getString(0));
                courseStartTime.add(data.getString(1));
                courseEndTime.add(data.getString(2));
                courseLocation.add(data.getString(3));
                courseDoW.add(data.getString(4));
            }
            else{
                if(count == 4){
                    count=0;
                }
                else{
                    count++;
                }
            }
        }//end while
        adapter = new CourseListAdapter(getContext(), courseName,courseLocation,courseDoW,courseStartTime,courseEndTime);
        lvCourse.setAdapter(adapter);

        lvCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String course = (String)courseName.get(i);
                String Location = (String)courseLocation.get(i);
                String Dow = (String)courseDoW.get(i);
                String StartTime = (String)courseStartTime.get(i);
                String EndTime = (String)courseEndTime.get(i);
                Cursor data = coursesDatabase.getItemID(course, Location,Dow,StartTime,EndTime);
                int itemID = -1;

                while (data.moveToNext()) {
                    itemID = data.getInt(0);
                }

                if (itemID >= 1) {

                    Intent editScreenIntent = new Intent(getActivity(), AddCoursesLayout.class);
                    editScreenIntent.putExtra("id", itemID);
                    editScreenIntent.putExtra("course", course);
                    editScreenIntent.putExtra("dueDate", Location);
                    editScreenIntent.putExtra("assignment", Dow);
                    editScreenIntent.putExtra("assignment", StartTime);
                    editScreenIntent.putExtra("assignment", EndTime);
                    startActivity(editScreenIntent);

                } else {
                    toastMessage("No ID associated with that assignment");
                }
            }
        });

        adapter = new CourseListAdapter(getContext(), courseName,courseLocation,courseDoW,courseStartTime,courseEndTime);
        lvCourse.setAdapter(adapter);
    }
    private void toastMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
/*
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
/*
        //add data to list

        //this is a list of courses entered in manually ....
        mCourseList = new ArrayList<>();
        coursesDatabase = new CoursesDatabase(getContext());
        data = coursesDatabase.getData();
       /*
        if(data.getCount()==0){

        }
        else{
            mCourseList.add(new Course(1, data.getString(1), data.getString(4),
                    data.getString(2), data.getString(3), data.getString(5)));
        }
        */

        //mCourseList.add(new Course(1,"SWENG 411", "Burke", 123, "Monday"));
        //mCourseList.add(new Course(2,"CAS 100A", "Kockle", 230, "Tuesday"));
        //mCourseList.add(new Course(3,"EE 310", "Burke", 900, "Wed"));
        //mCourseList.add(new Course(4,"SLEEP", "Burke", 1000, "Friday"));

        //mCourseList.add(new Course(1,"SWENG 411", "Burke", 123, "Monday"));
        //mCourseList.add(new Course(2,"CAS 100A", "Kockle", 230, "Tuesday"));
        //mCourseList.add(new Course(3,"EE 310", "Burke", 900, "Wed"));
        //mCourseList.add(new Course(4,"SLEEP", "Burke", 1000, "F"));



        /*
        get data from alternate activity...... into course
        set data fields from the alternate activity
        when the button is clicked set an onclick listener to add the new course
        update the CourseListAdapter



        //init adapter

        adapter = new CourseListAdapter(getContext(), mCourseList);
        lvCourse.setAdapter(adapter);

        lvCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //do something.....
            }
        });


        mFaB.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent in = new Intent(getActivity(), AddCoursesLayout.class);
                startActivity(in);


            }
        });
*/
    }




