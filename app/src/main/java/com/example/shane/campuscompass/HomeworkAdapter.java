package com.example.shane.campuscompass;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Zach on 12/5/2017.
 */

public class HomeworkAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList<String> mClassList;
    private ArrayList<String> mAssignmentList;
    private ArrayList<String> mDueDateList;

    public HomeworkAdapter(Context context, ArrayList<String> classList, ArrayList<String> assignmentList, ArrayList<String> dueDateList)
    {
        mContext = context;
        mClassList = classList;
        mAssignmentList = assignmentList;
        mDueDateList = dueDateList;
    }

    @Override
    public int getCount() {return mClassList.size();}

    @Override
    public Object getItem(int position) {return null;}

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = View.inflate(mContext, R.layout.homework_adapter, null);

        TextView className = (TextView) v.findViewById(R.id.classText2);
        TextView assignmentName = (TextView) v.findViewById(R.id.assignmentText);
        TextView dueDateName = (TextView) v.findViewById(R.id.dueDateText);

        className.setText(mClassList.get(position));
        assignmentName.setText(mAssignmentList.get(position));
        dueDateName.setText(mDueDateList.get(position));

        return v;
    }
}
