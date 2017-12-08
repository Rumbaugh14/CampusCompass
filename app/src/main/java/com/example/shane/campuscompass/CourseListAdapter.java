package com.example.shane.campuscompass;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Shane on 10/29/2017.
 */

public class CourseListAdapter extends BaseAdapter{

    private Context mContext;
    private List<String> mCourseName;
    private List<String> mCourseLocation;
    private List<String> mCourseDow;
    private List<String> mCourseStartTime;
    private List<String> mCourseEndTime;

    public CourseListAdapter(Context context, List<String> courseName,
                             List<String> courseLocation, List<String> courseDow,
                             List<String> courseStartTime, List<String> courseEndTime) {
        mContext = context;
        mCourseName = courseName;
        mCourseLocation = courseLocation;
        mCourseDow = courseDow;
        mCourseStartTime = courseStartTime;
        mCourseEndTime = courseEndTime;
    }

    @Override
    public int getCount() {
        return mCourseName.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.item_courses_list,null);

        TextView courseName = (TextView) v.findViewById(R.id.course_list_name);
        TextView courseDoW = (TextView) v.findViewById(R.id.course_list_location);
        TextView courseLocation = (TextView) v.findViewById(R.id.course_list_dow);
        TextView courseTimeStart = (TextView) v.findViewById(R.id.course_list_timeStart);
        TextView courseTimeEnd = (TextView) v.findViewById(R.id.course_list_timeEnd);
        //set text for TextViews

        courseName.setText(mCourseName.get(position));
        courseLocation.setText(mCourseLocation.get(position));
        courseDoW.setText(mCourseDow.get(position));
        courseTimeStart.setText(mCourseStartTime.get(position));
        courseTimeEnd.setText(mCourseEndTime.get(position));


        return v;
    }


    //Constructor

    }

