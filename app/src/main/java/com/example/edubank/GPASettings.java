package com.example.edubank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;

public class GPASettings extends AppCompatActivity {
    //Initialize variable
    ImageView backbtn;
    Button addbtn, donebtn;
    EditText apluspoint, apoint, aminuspoint, bpluspoint, bpoint, bminupoint, cpluspoint, cpoint, cminuspoint, dpluspoint, dpoint, epoint;
    DatabaseReference reference;
    GradePoint gradePoint;

    //Global variables to hold Grade Points data inside this activity
    String aplus, a, aminus,bplus, b, bminus, cplus, c, cminus, dplus, d, e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_p_a_settings);

        //Assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        backbtn = findViewById(R.id.backbtn);
        addbtn = findViewById(R.id.addbtn);
        donebtn = findViewById(R.id.donebtn);
        apluspoint = findViewById(R.id.apluspoint);
        apoint = findViewById(R.id.apoint);
        aminuspoint = findViewById(R.id.aminuspoint);
        bpluspoint = findViewById(R.id.bpluspoint);
        bpoint = findViewById(R.id.bpoint);
        bminupoint = findViewById(R.id.bminupoint);
        cpluspoint = findViewById(R.id.cpluspoint);
        cpoint = findViewById(R.id.cpoint);
        cminuspoint = findViewById(R.id.cminuspoint);
        dpluspoint = findViewById(R.id.dpluspoint);
        dpoint = findViewById(R.id.dpoint);
        epoint = findViewById(R.id.epoint);
        gradePoint = new GradePoint();

        showAllGradePointsData();

        //Set Grades Selected
        bottomNavigationView.setSelectedItemId(R.id.gradesnav);

        //Direct to Previous Interface
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gpaMainIntent = new Intent(GPASettings.this, GPAMainActivity.class);
                startActivity(gpaMainIntent);
                finish();
            }
        });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gpaAddIntent = new Intent(GPASettings.this, GradePointsAdd.class);
                startActivity(gpaAddIntent);
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

    private void showAllGradePointsData() {
    }

    public void update(View view) {

    }
}