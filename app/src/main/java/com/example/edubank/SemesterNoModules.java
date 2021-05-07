package com.example.edubank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SemesterNoModules extends AppCompatActivity {
    //Initialize variable
    ImageView backbtn;
    Button totalmodulesubmitbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_no_modules);

        //Assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        backbtn = findViewById(R.id.backbtn);
        totalmodulesubmitbtn = findViewById(R.id.totalmodulesubmitbtn);

        //Set Grades Selected
        bottomNavigationView.setSelectedItemId(R.id.gradesnav);

        //Direct to Previous Interface
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calculateGPAIntent = new Intent(SemesterNoModules.this, CalculateGPA.class);
                startActivity(calculateGPAIntent);
                finish();
            }
        });

        //Direct to Next Interface
        totalmodulesubmitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studentResultsIntent = new Intent(SemesterNoModules.this, StudentSemesterResults.class);
                startActivity(studentResultsIntent);
                finish();
            }
        });

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
}