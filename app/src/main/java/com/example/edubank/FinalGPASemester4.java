package com.example.edubank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FinalGPASemester4 extends AppCompatActivity {
    //Initialize variable
    ImageView backbtn;
    TextView gpaView, cgpaView;
    Button backtocalculategpabtn;
    private double gpa4;
    private double cgpa4;
    private double credits4;
    private double total_gpa4;
    private double cumutative_gradePoints4;

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
        //Total Grade Points in Semester 4
        total_gpa4 = addGPASemFour(getGradePoint(grade1), getGradePoint(grade2), getGradePoint(grade3), getGradePoint(grade4), getGradePoint(grade5));
        //GPA of Semester 4
        gpa4 = calculateGPASemFour(total_gpa4, 5.0);

        //GPA View
        gpaView.setText(Double.toString(gpa4));

        //CGPA Calculation
        //Cumulative Credits
        credits4 = addCreditsSemFour(getCredit(credit1), getCredit(credit2), getCredit(credit3), getCredit(credit4), getCredit(credit5));
        //Cumulative Grade Points
        cumutative_gradePoints4 = multiplyGradePointsSemFour(getGradePoint(grade1), getCredit(credit1), getGradePoint(grade2), getCredit(credit2), getGradePoint(grade3), getCredit(credit3), getGradePoint(grade4), getCredit(credit4), getGradePoint(grade5), getCredit(credit5));
        //CGPA of Semester 4
        cgpa4 = calculateCGPASemFour(credits4, cumutative_gradePoints4);

        //CGPA View
        cgpaView.setText(Double.toString(cgpa4));

        //Direct to Previous Interface
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studentSemesterRsultsIntent = new Intent(FinalGPASemester4.this, StudentSemester4Results.class);
                startActivity(studentSemesterRsultsIntent);
                finish();
            }
        });

        //Direct to Calculate GPA Interface
        backtocalculategpabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backCalculateGPAIntent = new Intent(FinalGPASemester4.this, CalculateGPA.class);
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

    //Semester 4 Total Grade Points Calculation Method
    private double addGPASemFour(double grade1, double grade2, double grade3, double grade4, double grade5) {
        return grade1 + grade2 + grade3 + grade4 + grade5;
    }

    //Semester 4 GPA Calculation Method
    private double calculateGPASemFour(double total_gpa, double v) {
        return total_gpa / v;
    }

    //Cumulative Credits Calculation Method
    private double addCreditsSemFour(double credit1, double credit2, double credit3, double credit4, double credit5) {
        return credit1 + credit2 + credit3 + credit4 + credit5;
    }

    //Cumulative Grade Points Calculation Method
    private double multiplyGradePointsSemFour(double gradePoint1, double credit1, double gradePoint2, double credit2, double gradePoint3, double credit3, double gradePoint4, double credit4, double gradePoint5, double credit5) {
        return ((gradePoint1 * credit1) + (gradePoint2 * credit2) + (gradePoint3 * credit3) + (gradePoint4 * credit4) + (gradePoint5 * credit5));
    }

    //Semester 4 CGPA Calculation Method
    private double calculateCGPASemFour(double credits, double cumutative_gradePoints) {
        return cumutative_gradePoints / credits;
    }
}