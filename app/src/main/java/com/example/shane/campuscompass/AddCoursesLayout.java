package com.example.shane.campuscompass;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddCoursesLayout extends AppCompatActivity {


    private TextView courseName;
    private Spinner mlocation;
    private String mapLocation = "invisible";
    private List<CheckBox> mCheckBoxes = new ArrayList<>();
    private Button addButton, buttonStartTime,buttonEndTime;
    CoursesDatabase mCoursesDatabase;
    private TextView start, end;
    static final int DIALOG_START =0;
    static final int DIALOG_END = 1;

    int starthour;
    int startmin;

    int endhour;
    int endmin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_course_layout);

        mlocation = findViewById(R.id.LocationSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.locations, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mlocation.setAdapter(adapter);
        mlocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                                                    mapLocation = parent.getItemAtPosition(pos).toString();

                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });


        start = findViewById(R.id.textStartTime);
        end = findViewById(R.id.textEndTime);

        courseName = findViewById(R.id.CourseNameTextView);


        mCheckBoxes = Arrays.asList(
                                    (CheckBox)findViewById(R.id.Monday),
                                    (CheckBox)findViewById(R.id.Tuesday),
                                    (CheckBox)findViewById(R.id.Wednesday),
                                    (CheckBox)findViewById(R.id.Thursday),
                                    (CheckBox)findViewById(R.id.Friday)
                                    );


        addButton = findViewById(R.id.AddCourseButton);
        buttonStartTime = findViewById(R.id.StartTimeBtn);
        buttonEndTime = findViewById(R.id.EndTimeBtn);

        mCoursesDatabase = new CoursesDatabase(this);


        buttonStartTime.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_START);
                    }
                }
        );

        buttonEndTime.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_END);
                    }
                }
        );

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String timeStart = starthour + " : " + startmin;
                String timeEnd = endhour + " : " + endmin;
                addData(courseName.getText().toString(),timeStart,timeEnd,getdow(mCheckBoxes),mapLocation);
                finish();
            }
        });

    }

    public String getdow(List<CheckBox> checkbox){
        String monday = " M ";
        String Tuesday = " T ";
        String Wednesday = " W ";
        String Thursday = " Th ";
        String Friday = " F ";
        String dow = "";

        if(checkbox.get(0).isChecked())
            dow += " " + monday;
        if(checkbox.get(1).isChecked())
            dow += " " + Tuesday;
        if(checkbox.get(2).isChecked())
            dow += " " +Wednesday;
        if(checkbox.get(3).isChecked())
            dow += " " +Thursday;
        if(checkbox.get(4).isChecked())
            dow += " " +Friday;

        return dow;
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == DIALOG_START) {
            return new TimePickerDialog(AddCoursesLayout.this,
                    kTimePickerListener_start, starthour, startmin, false);
        }
        if(id == DIALOG_END){
            return new TimePickerDialog(AddCoursesLayout.this,
                    kTimePickerListener_end, endhour, endmin, false);
        }
        return null;
    }


    //end time time picker
    protected TimePickerDialog.OnTimeSetListener kTimePickerListener_end =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    endhour = hourOfDay;
                    endmin = minute;
                    Toast.makeText(AddCoursesLayout.this,endhour + " : " + endmin, Toast.LENGTH_LONG).show();
                    end.setText(endhour + " : " + endmin);
                }
            };

    //start time time picker
    protected TimePickerDialog.OnTimeSetListener kTimePickerListener_start =
            new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            starthour = hourOfDay;
            startmin = minute;
            Toast.makeText(AddCoursesLayout.this,starthour + " : " + startmin, Toast.LENGTH_LONG).show();
            start.setText(starthour + " : " + startmin);
        }
    };

    public void addData(String course, String stime, String etime ,String Location, String Dow) {
        boolean insertData = mCoursesDatabase.addData(course, stime,etime, Location, Dow);
        if (insertData) {
            toastMessage("Data entered successfuly");
        } else {
            toastMessage("Something went wrong AddCoursesLayout");
        }
    }

    public void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
