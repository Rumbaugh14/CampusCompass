package com.example.shane.campuscompass;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.ViewGroup.LayoutParams;

/**
 * Created by Andrew
 */
//public class ProfileEdit extends Fragment {
//
//    private Button saveButton;
//    private EditText editName;
//    private EditText editMajor;
//    private EditText editEmail;
//    private String name = ""; //user's name
//    private String major = ""; //user's major
//    private String email = ""; //user's email
//
//    public ProfileEdit(View popupView, LayoutParams , LayoutParams) {
//
//    }
//
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.profile_pop_window);
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//        getWindow().setLayout((int)(width*.8), (int)(height*.8));
//
//        saveButton = (Button)findViewById(R.id.saveChanges);
//        editName = (EditText)findViewById(R.id.nameField);
//        editMajor = (EditText)findViewById(R.id.majorField);
//        editEmail = (EditText)findViewById(R.id.emailField);
//
//        saveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                name = editName.getText().toString();
//                major = editMajor.getText().toString();
//                email = editEmail.getText().toString();
//            }
//        });
//    }
//}
