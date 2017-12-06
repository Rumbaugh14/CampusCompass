package com.example.shane.campuscompass;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by Andrew
 */
public class ProfileFragment extends Fragment {

    private static final String TAG  = "ProfileFragment";
    private Button editButton; //profile ui edit button
    private TextView profileName;
    private TextView profileMajor;
    private TextView profileEmail;
    private Button saveButton;
    private EditText editName;
    private EditText editMajor;
    private EditText editEmail;
    private PopupWindow profilePopup;
    private String name = "Name";
    private String major = "Major";
    private String email = "E-Mail";
    DatabaseHelperProfile mDatabaseHelper;


    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.profile_fragment, container, false);

        editButton = (Button)v.findViewById(R.id.editButton);
        profileName = (TextView)v.findViewById(R.id.userName);
        profileMajor = (TextView)v.findViewById(R.id.userMajor);
        profileEmail = (TextView)v.findViewById(R.id.userEmail);
        mDatabaseHelper = new DatabaseHelperProfile(getContext());

        populateProfile();
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                profilePopup(view);
            }
        });
    }

    public void profilePopup(View anchorView) {
        View popupView = getLayoutInflater().inflate(R.layout.profile_pop_window, null);

        profilePopup = new PopupWindow(popupView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        profilePopup.setFocusable(true);
        profilePopup.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        profilePopup.showAtLocation(anchorView, Gravity.NO_GRAVITY, 0, 0);

        saveButton = (Button) popupView.findViewById(R.id.saveChanges);
        editName = (EditText) popupView.findViewById(R.id.nameField);
        editMajor = (EditText) popupView.findViewById(R.id.majorField);
        editEmail = (EditText) popupView.findViewById(R.id.emailField);

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                name = editName.getText().toString();
                major = editMajor.getText().toString();
                email = editEmail.getText().toString();

                if (editName.length() != 0 && editMajor.length() != 0 && editEmail.length() != 0) {
                    addData(name, major, email, view);
                } else {
                    toastMessage("One or more fields do not contain data!", view);
                }

                profileName.setText(name);
                profileMajor.setText(major);
                profileEmail.setText(email);
                profilePopup.dismiss();
            }
        });
    }

    private void toastMessage(String message, View v) {
        Toast.makeText(v.getContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void addData(String newEntry1, String newEntry2, String newEntry3, View v) {
        boolean insertData = mDatabaseHelper.addData(newEntry1, newEntry2, newEntry3);

        if(insertData) {
            toastMessage("Profile information updated!", v);
        } else {
            toastMessage("Something went wrong.", v);
        }
    }

    private void populateProfile () {
        Log.d(TAG, "ProfileFragment: Attempting to display data to the profile.");

        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            profileName.setText(data.getString(0));
            profileMajor.setText(data.getString(1));
            profileEmail.setText(data.getString(2));
        }
    }
}
