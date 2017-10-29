package com.example.shane.campuscompass;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shane.campuscompass.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Shane on 10/29/2017.
 */

public class CourseListAdapter extends BaseAdapter{

    private Context mContext;
    private List<Courses> mCoursesList;

    //Constructor

    public CourseListAdapter(Context context, List<Courses> coursesList) {
        mContext = context;
        mCoursesList = coursesList;
    }

    @Override
    public int getCount() {
        return mCoursesList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCoursesList.get(position);
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
        courseName.setText(mCoursesList.get(position).getName());
        courseLocation.setText(mCoursesList.get(position).getLocation());
        courseDoW.setText(mCoursesList.get(position).getdow());
        courseTime.setText(String.valueOf(mCoursesList.get(position).getTime()));

        //save course id to tag
        v.setTag(mCoursesList.get(position).getId());

        return v;
    }
}
