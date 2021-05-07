package com.example.edubank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class NameUniversity extends AppCompatActivity {
    //Initialize variable
    ImageView backbtn;
    Button nameuniversitysubmit;
    EditText yourname, university;
    UserDetails userDetails;
    long maxid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_university);

        //Assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        backbtn = findViewById(R.id.backbtn);
        nameuniversitysubmit = findViewById(R.id.nameuniversitysubmit);
        yourname = findViewById(R.id.yourname);
        university = findViewById(R.id.university);

        //Create a model class object
        userDetails = new UserDetails();

        //Accessing child nodes
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("UserDetails");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxid = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Data Inputs User Name and University and Save data in FireBase on button click Direct to Next Interface
        nameuniversitysubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (TextUtils.isEmpty(yourname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Your Name", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(university.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Your University", Toast.LENGTH_LONG).show();
                    else {
                        //Get all the User Details
                        String userName = yourname.getText().toString();
                        String universityName = university.getText().toString();

                        //Set values in User Details Java Class
                        userDetails.setUserName(userName);
                        userDetails.setUniversityName(universityName);

                        maxid +=1;
                        reference.child(String.valueOf(maxid)).setValue(userDetails);
                        Toast.makeText(NameUniversity.this, "User Details Added Successfully", Toast.LENGTH_LONG).show();
                        clear();

                        Intent CalculategpaIntent = new Intent(NameUniversity.this, CalculateGPA.class);
                        CalculategpaIntent.putExtra("userName", String.valueOf(maxid) );
                        CalculategpaIntent.putExtra("universityName", String.valueOf(maxid) );
                        startActivity(CalculategpaIntent);

                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid Number Type", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Direct to Previous Interface
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gpaMainIntent = new Intent(NameUniversity.this, GPAMainActivity.class);
                startActivity(gpaMainIntent);
                finish();
            }
        });

        //Set Grades Selected
        bottomNavigationView.setSelectedItemId(R.id.gradesnav);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    /*case R.id.schedulenav:
                        startActivity(new Intent(getApplicationContext(), Schedule.class));
                        overridePendingTransition(0, 0);
                        return true;*/
                    /*case R.id.coursesnav:
                        startActivity(new Intent(getApplicationContext(), Courses.class));
                        overridePendingTransition(0, 0);
                        return true;*/
                    case R.id.gradesnav:
                        return true;
                   /* case R.id.examschedulenav:
                        startActivity(new Intent(getApplicationContext(), ExamSchedule.class));
                        overridePendingTransition(0, 0);
                        return true;*/
                }
                return false;
            }
        });
    }


    //Clear Method
    public void clear() {
        yourname.setText(null);
        university.setText(null);
    }
}