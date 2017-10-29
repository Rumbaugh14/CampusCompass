package com.example.shane.campuscompass;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class AddCoursesMain extends ListFragment{

    private ListView lvCourse;
    private CourseListAdapter adapter;
    private List<Courses> mCoursesList;

    public AddCoursesMain() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_add_courses_main, container, false);
        //lvCourse = getListView().findViewById(R.id.list);
        lvCourse = v.findViewById(android.R.id.list);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //lvCourse = view.findViewById(android.R.id.list);


        //.findViewById(android.R.id.list);

        mCoursesList = new ArrayList<>();
        //add data to list
        mCoursesList.add(new Courses(1,"SWENG 411", "Burke", 123, "Monday"));
        mCoursesList.add(new Courses(2,"CAS 100A", "Kockle", 230, "Tuesday"));
        mCoursesList.add(new Courses(3,"EE 310", "Burke", 900, "Wed"));
        mCoursesList.add(new Courses(4,"SLEEP", "Burke", 1000, "Friday"));


        //init adapter

        adapter = new CourseListAdapter(getContext(),mCoursesList);
        lvCourse.setAdapter(adapter);

        lvCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //do something.....
            }
        });

    }

}
