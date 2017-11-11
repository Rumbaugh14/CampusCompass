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
    private List<Course> mCourseList;

    //Constructor

    public CourseListAdapter(Context context, List<Course> courseList) {
        mContext = context;
        mCourseList = courseList;
    }

    @Override
    public int getCount() {
        return mCourseList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCourseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.item_courses_list,null);

        TextView courseName = (TextView)v.findViewById(R.id.course_list_name);
        TextView courseLocation = (TextView)v.findViewById(R.id.course_list_location);
        TextView courseDoW = (TextView)v.findViewById(R.id.course_list_dow);
        TextView courseTime = (TextView)v.findViewById(R.id.course_list_time);

        //set text for TextViews
        courseName.setText(mCourseList.get(position).getName());
        courseLocation.setText(mCourseList.get(position).getLocation());
        courseDoW.setText(mCourseList.get(position).getdow());
        courseTime.setText(String.valueOf(mCourseList.get(position).getTime()));

        //save course id to tag
        v.setTag(mCourseList.get(position).getId());

        return v;
    }
}
