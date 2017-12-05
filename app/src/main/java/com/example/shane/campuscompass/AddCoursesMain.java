package com.example.shane.campuscompass;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class AddCoursesMain extends ListFragment{

    private static ListView lvCourse;
    private static List<Course> mCourseList = new ArrayList<>();
    private static CourseListAdapter adapter;
    private FloatingActionButton mFaB;
    //private Context currentContext = getContext();
    //= new CourseListAdapter(getContext(), mCourseList)


    public AddCoursesMain() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_add_courses_main, container, false);

        lvCourse = v.findViewById(android.R.id.list);
        mFaB = v.findViewById(R.id.FaB_AddCourse);
        return v;
    }


    public static void AddCourse(Course c){
        mCourseList.add(c);

        //adapter = new CourseListAdapter(currentContext, mCourseList);
        //lvCourse.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //add data to list

        //this is a list of courses entered in manually ....
        //mCourseList = new ArrayList<>();

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
         */


        //init adapter

        //adapter = new CourseListAdapter(getContext(), mCourseList);
        //lvCourse.setAdapter(adapter);

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

    }



}
