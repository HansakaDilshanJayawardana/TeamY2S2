package com.example.edubank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.database.ValueEventListener;

public class GradePointsAdd extends AppCompatActivity {
    //Initialize variable
    ImageView backbtn;
    Button donebtnadd, addbtnadd;
    EditText apluspointadd, apointadd, aminuspointadd, bpluspointadd, bpointadd, bminupointadd, cpluspointadd, cpointadd, cminuspointadd, dpluspointadd, dpointadd, epointadd;
    GradePoint gradePoint;
    long maxid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_points_add);

        //Assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        backbtn = findViewById(R.id.backbtn);
        addbtnadd = findViewById(R.id.addbtnadd);
        apluspointadd = findViewById(R.id.apluspointadd);
        apointadd = findViewById(R.id.apointadd);
        aminuspointadd = findViewById(R.id.aminuspointadd);
        bpluspointadd = findViewById(R.id.bpluspointadd);
        bpointadd = findViewById(R.id.bpointadd);
        bminupointadd = findViewById(R.id.bminupointadd);
        cpluspointadd = findViewById(R.id.cpluspointadd);
        cpointadd = findViewById(R.id.cpointadd);
        cminuspointadd = findViewById(R.id.cminuspointadd);
        dpluspointadd = findViewById(R.id.dpluspointadd);
        dpointadd = findViewById(R.id.dpointadd);
        epointadd = findViewById(R.id.epointadd);

        gradePoint = new GradePoint();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("GradePoint");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxid = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Data Inputs Grade Points and Save data in FireBase on button click
        addbtnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (TextUtils.isEmpty(apluspointadd.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Grade Point for A Plus", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(apointadd.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Grade Point for A", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(aminuspointadd.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Grade Point for A Minus", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(bpluspointadd.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Grade Point for B Plus", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(bpointadd.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Grade Point for B", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(bminupointadd.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Grade Point for B Minus", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(cpluspointadd.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Grade Point for C Plus", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(cpointadd.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Grade Point for C", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(cminuspointadd.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Grade Point for C Minus", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(dpluspointadd.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Grade Point for D Plus", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(dpointadd.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Grade Point for D", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(epointadd.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Grade Point for E", Toast.LENGTH_LONG).show();
                    else {
                        //Get all the Grade Points Values
                        Float aPlusPoint = Float.parseFloat(apluspointadd.getText().toString().trim());
                        Float aPoint = Float.parseFloat(apointadd.getText().toString().trim());
                        Float aMinusPoint = Float.parseFloat(aminuspointadd.getText().toString().trim());
                        Float bPlusPoint = Float.parseFloat(bpluspointadd.getText().toString().trim());
                        Float bPoint = Float.parseFloat(bpointadd.getText().toString().trim());
                        Float bMinusPoint = Float.parseFloat(bminupointadd.getText().toString().trim());
                        Float cPlusPoint = Float.parseFloat(cpluspointadd.getText().toString().trim());
                        Float cPoint = Float.parseFloat(cpointadd.getText().toString().trim());
                        Float cMinusPoint = Float.parseFloat(cminuspointadd.getText().toString().trim());
                        Float dPlusPoint = Float.parseFloat(dpluspointadd.getText().toString().trim());
                        Float dPoint = Float.parseFloat(dpointadd.getText().toString().trim());
                        Float ePoint = Float.parseFloat(epointadd.getText().toString().trim());

                        //Set values in Grade Points Java Class
                        gradePoint.setaPlusPoint(aPlusPoint);
                        gradePoint.setaPoint(aPoint);
                        gradePoint.setaMinusPoint(aMinusPoint);
                        gradePoint.setbPlusPoint(bPlusPoint);
                        gradePoint.setbPoint(bPoint);
                        gradePoint.setbMinusPoint(bMinusPoint);
                        gradePoint.setcPlusPoint(cPlusPoint);
                        gradePoint.setcPoint(cPoint);
                        gradePoint.setcMinusPoint(cMinusPoint);
                        gradePoint.setdPlusPoint(dPlusPoint);
                        gradePoint.setdPoint(dPoint);
                        gradePoint.setePoint(ePoint);

                        maxid +=1;
                        reference.child(String.valueOf(maxid)).setValue(gradePoint);
                        Toast.makeText(GradePointsAdd.this, "Grade Points Added Successfully", Toast.LENGTH_LONG).show();
                        clear();
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
                Intent gpaMainIntent = new Intent(GradePointsAdd.this, GPASettings.class);
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

    public void clear() {
        apluspointadd.setText(null);
        apointadd.setText(null);
        aminuspointadd.setText(null);
        bpluspointadd.setText(null);
        bpointadd.setText(null);
        bminupointadd.setText(null);
        cpluspointadd.setText(null);
        cpointadd.setText(null);
        cminuspointadd.setText(null);
        dpluspointadd.setText(null);
        dpointadd.setText(null);
        epointadd.setText(null);
    }
}