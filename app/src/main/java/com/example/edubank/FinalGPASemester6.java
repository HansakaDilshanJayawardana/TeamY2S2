package com.example.edubank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class FinalGPASemester6 extends AppCompatActivity {
    //Initialize variable
    ImageView backbtn;
    TextView gpaView, cgpaView;
    Button backtocalculategpabtn;
    private double gpa6;
    private double cgpa6;
    private double credits6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_g_p);

        //Assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        backbtn = findViewById(R.id.backbtn);
        backtocalculategpabtn = findViewById(R.id.backtocalculategpabtn);
        gpaView = findViewById(R.id.gpafinal);
        cgpaView = findViewById(R.id.cgpasemfinal);

        Intent finalInetnt = getIntent();//Create Intent Object

        //Get Passed Grades
        String grade1 = finalInetnt.getStringExtra("grade1");
        String grade2 = finalInetnt.getStringExtra("grade2");
        String grade3 = finalInetnt.getStringExtra("grade3");
        String grade4 = finalInetnt.getStringExtra("grade4");
        String grade5 = finalInetnt.getStringExtra("grade5");

        //Get Passed Credits
        String credit1 = finalInetnt.getStringExtra("credit1");
        String credit2 = finalInetnt.getStringExtra("credit2");
        String credit3 = finalInetnt.getStringExtra("credit3");
        String credit4 = finalInetnt.getStringExtra("credit4");
        String credit5 = finalInetnt.getStringExtra("credit5");

        //GPA Calculation
        gpa6 = (getGradePoint(grade1) + getGradePoint(grade2) + getGradePoint(grade3) + getGradePoint(grade4) + getGradePoint(grade5))/5;
        //GPA View
        gpaView.setText(Double.toString(gpa6));

        //CGPA Calculation
        credits6 = (getCredit(credit1) + getCredit(credit2) + getCredit(credit3) + getCredit(credit4) + getCredit(credit5));
        cgpa6 = ((getGradePoint(grade1) * getCredit(credit1)) + (getGradePoint(grade2) * getCredit(credit2)) + (getGradePoint(grade3) * getCredit(credit3)) + (getGradePoint(grade4) * getCredit(credit4)) + (getGradePoint(grade5) * getCredit(credit5))) / credits6;

        //CGPA View
        cgpaView.setText(Double.toString(cgpa6));

        //Direct to Previous Interface
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studentSemesterRsultsIntent = new Intent(FinalGPASemester6.this, StudentSemester6Results.class);
                startActivity(studentSemesterRsultsIntent);
                finish();
            }
        });

        //Direct to Calculate GPA Interface
        backtocalculategpabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backCalculateGPAIntent = new Intent(FinalGPASemester6.this, CalculateGPA.class);
                startActivity(backCalculateGPAIntent);
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

    //getGradePoint method
    private Double getGradePoint(String results){
        if(results.equals("A")|| results.equals("A+"))
            return 4.0;
        else if(results.equals("A-"))
            return 3.7;
        else if(results.equals("B+"))
            return 3.3;
        else if(results.equals("B"))
            return 3.0;
        else if(results.equals("B-"))
            return 2.7;
        else if(results.equals("C+"))
            return 2.3;
        else if(results.equals("C"))
            return 2.0;
        else if(results.equals("C-"))
            return 1.7;
        else if(results.equals("D+"))
            return 1.3;
        else if(results.equals("D"))
            return 1.0;
        else
            return 0.0;
    }

    //getCredit method
    private Double getCredit(String credits){
        if (credits.equals("6"))
            return 6.0;
        else if (credits.equals("5"))
            return 5.0;
        else if (credits.equals("4"))
            return 4.0;
        else if (credits.equals("3"))
            return 3.0;
        else if (credits.equals("2"))
            return 2.0;
        else
            return 1.0;
    }
}