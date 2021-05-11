package com.example.edubank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class CalculateGPA extends AppCompatActivity {
    //Initialize variable
    ImageView backbtn;
    Button semster1btn, semster2btn, semster3btn, semster4btn, semster5btn, semster6btn, semster7btn, semster8btn;
    TextView studentName, universityName;
    String usernameFromDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_g_p);

        //Assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        backbtn = findViewById(R.id.backbtn);
        semster1btn = findViewById(R.id.semster1btn);
        semster2btn = findViewById(R.id.semster2btn);
        semster3btn = findViewById(R.id.semster3btn);
        semster4btn = findViewById(R.id.semster4btn);
        semster5btn = findViewById(R.id.semster5btn);
        semster6btn = findViewById(R.id.semster6btn);
        semster7btn = findViewById(R.id.semster7btn);
        semster8btn = findViewById(R.id.semster8btn);
        universityName = findViewById(R.id.universityName);
        studentName = findViewById(R.id.studentName);

        //Accessing Child Nodes Using Singleton
        Query checkUser = FirebaseDatabase.getInstance().getReference("UserDetails").child(String.valueOf(CurrentGPAUser.getInstance().getMaxId()));

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    //Get UserName from DB
                    usernameFromDB = snapshot.child("userName").getValue().toString();
                    studentName.setText(usernameFromDB);//Set UserName to Student Name View
                    //Get University Name from DB and set University Name to University Name View
                    String universityFromDB = snapshot.child("universityName").getValue().toString();
                    universityName.setText(universityFromDB);

                } else {
                    Toast.makeText(getApplicationContext(), "Cannot Find User Details", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Direct to Previous Interface
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nameUniversityIntent = new Intent(CalculateGPA.this, NameUniversity.class);
                startActivity(nameUniversityIntent);
                finish();
            }
        });

        //Direct to Semester No of Modules Interface
        //Semester 1
        semster1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent semesterNoModIntent = new Intent(CalculateGPA.this, StudentSemesterResults.class);
                startActivity(semesterNoModIntent);
                finish();
            }
        });
        //Semester 2
        semster2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent semesterNoModIntent2 = new Intent(CalculateGPA.this, StudentSemester2Results.class);
                startActivity(semesterNoModIntent2);
                finish();
            }
        });
        //Semester 3
        semster3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent semesterNoModIntent = new Intent(CalculateGPA.this, StudentSemester3Results.class);
                startActivity(semesterNoModIntent);
                finish();
            }
        });
        //Semester 4
        semster4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent semesterNoModIntent = new Intent(CalculateGPA.this, StudentSemester4Results.class);
                startActivity(semesterNoModIntent);
                finish();
            }
        });
        //Semester 5
        semster5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent semesterNoModIntent = new Intent(CalculateGPA.this, StudentSemester5Results.class);
                startActivity(semesterNoModIntent);
                finish();
            }
        });
        //Semester 6
        semster6btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent semesterNoModIntent = new Intent(CalculateGPA.this, StudentSemester6Results.class);
                startActivity(semesterNoModIntent);
                finish();
            }
        });
        //Semester 7
        semster7btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent semesterNoModIntent = new Intent(CalculateGPA.this, StudentSemester7Results.class);
                startActivity(semesterNoModIntent);
                finish();
            }
        });
        //Semester 8
        semster8btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent semesterNoModIntent = new Intent(CalculateGPA.this, StudentSemester8Results.class);
                startActivity(semesterNoModIntent);
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

}