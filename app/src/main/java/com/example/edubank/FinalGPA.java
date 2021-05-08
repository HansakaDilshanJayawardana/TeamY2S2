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

import java.util.ArrayList;

public class FinalGPA extends AppCompatActivity {
    //Initialize variable
    ImageView backbtn;
    TextView gpaView;
    Button backtocalculategpabtn;
    DatabaseReference dbref;
    FirebaseDatabase firebaseDatabase;
    float gpa =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_g_p);

        //Assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        backbtn = findViewById(R.id.backbtn);
        backtocalculategpabtn = findViewById(R.id.backtocalculategpabtn);
        gpaView = findViewById(R.id.gpafinal);

//        //Retrieve Grades Data
//        ArrayList<Results> ary = new ArrayList<>();//Create array list object
//
//        //Accessing child nodes
//        dbref = firebaseDatabase.getInstance().getReference().child("Semester1").child("Results").child("Module");
//
//        dbref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(final com.google.firebase.database.DataSnapshot dataSnapshot) {
//                Log.i("check7", String.valueOf(dataSnapshot));
//                ary.clear(); // ArrayList<Pojo/Object> \\
//                int i=1;
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//
//                    Log.i("check9", String.valueOf(dataSnapshot));
//                    Results results = postSnapshot.child("Module").getValue(Results.class);
//                    Log.i("check8", String.valueOf(results));
//
//                    //Use the dataType you are using and also use the reference of those childs inside arrays\\
//
//                    // Putting Data into Getter Setter \\
//                    System.out.println(results);
//                    ary.add(results);
//                    i++;
//
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//
//        });

//        //Calculate GPA
//        for (Results i:ary){
//            gpa=(gpa+getGradePoint(i))/5f;
//        }
//
//        //View Calculated GPA
//        gpaView.setText(String.valueOf(gpa));

        //Direct to Previous Interface
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studentSemesterRsultsIntent = new Intent(FinalGPA.this, StudentSemesterResults.class);
                startActivity(studentSemesterRsultsIntent);
                finish();
            }
        });

        //Direct to Calculate GPA Interface
        backtocalculategpabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backCalculateGPAIntent = new Intent(FinalGPA.this, CalculateGPA.class);
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
//    public float getGradePoint(Results results){
//        if(results.getGrade().equals("A")|| results.getGrade().equals("A+"))
//            return 4f;
//        else if(results.getGrade().equals("A-"))
//            return 3.7f;
//        else if(results.getGrade().equals("B+"))
//            return 3.3f;
//        else if(results.getGrade().equals("B"))
//            return 3f;
//        else if(results.getGrade().equals("B-"))
//            return 2.7f;
//        else if(results.getGrade().equals("C+"))
//            return 2.3f;
//        else if(results.getGrade().equals("C"))
//            return 2f;
//        else if(results.getGrade().equals("C-"))
//            return 1.7f;
//        else if(results.getGrade().equals("D+"))
//            return 1.3f;
//        else if(results.getGrade().equals("D"))
//            return 1f;
//        else
//            return 0f;
//    }
}