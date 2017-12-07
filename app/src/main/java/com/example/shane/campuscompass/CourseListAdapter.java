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

        TextView courseName = v.findViewById(R.id.course_list_name);
        TextView courseLocation = v.findViewById(R.id.course_list_location);
        TextView courseDoW = v.findViewById(R.id.course_list_dow);
        TextView courseTimeStart = v.findViewById(R.id.course_list_timeStart);
        TextView courseTimeEnd = v.findViewById(R.id.course_list_timeEnd);
        //set text for TextViews

        courseName.setText(mCourseList.get(position).getName());
        courseLocation.setText(mCourseList.get(position).getLocation());
        courseDoW.setText(mCourseList.get(position).getdow());
        courseTimeStart.setText(mCourseList.get(position).getTimeSt());
        courseTimeEnd.setText((mCourseList.get(position).getTimeEd()));

        //save course id to tag
        v.setTag(mCourseList.get(position).getId());

        return v;
    }
}
