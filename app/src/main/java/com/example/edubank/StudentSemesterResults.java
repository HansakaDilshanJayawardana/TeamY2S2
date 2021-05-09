package com.example.edubank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StudentSemesterResults extends AppCompatActivity {
    //Initialize variable
    ImageView backbtn;
    Button calculategpasubmitbtn;
    EditText module1, module2, module3, module4, module5;
    Results results;
    long maxid = 0;
    float gpa =0.f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_semester_results);

        //Assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        backbtn = findViewById(R.id.backbtn);
        calculategpasubmitbtn = findViewById(R.id.calculategpasubmitbtn);
        module1 = findViewById(R.id.module1);
        module2 = findViewById(R.id.module2);
        module3 = findViewById(R.id.module3);
        module4 = findViewById(R.id.module4);
        module5 = findViewById(R.id.module5);

        //Create a results model class object
        results = new Results();

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


        //Module 1
        //Grades Picker
        Spinner mod1spinner = findViewById(R.id.module1gradepicker);

        ArrayAdapter<String> mod1adapter = new ArrayAdapter<>(
                this,
                R.layout.picker_styles,
                getResources().getStringArray(R.array.grades_picker_array)
        );
        mod1adapter.setDropDownViewResource(R.layout.picker_dropdown);
        mod1spinner.setAdapter(mod1adapter);

        //Credits Picker
        Spinner mod1spinner2 = findViewById(R.id.module1creditspicker);

        ArrayAdapter<String> mod1adapter2 = new ArrayAdapter<>(
                this,
                R.layout.picker_styles,
                getResources().getStringArray(R.array.credits_picker_array)
        );
        mod1adapter2.setDropDownViewResource(R.layout.picker_dropdown);
        mod1spinner2.setAdapter(mod1adapter2);


        //Module 2
        //Grades Picker
        Spinner mod2spinner = findViewById(R.id.module2gradepicker);

        ArrayAdapter<String> mod2adapter = new ArrayAdapter<>(
                this,
                R.layout.picker_styles,
                getResources().getStringArray(R.array.grades_picker_array)
        );
        mod2adapter.setDropDownViewResource(R.layout.picker_dropdown);
        mod2spinner.setAdapter(mod2adapter);

        //Credits Picker
        Spinner mod2spinner1 = findViewById(R.id.module2creditspicker);

        ArrayAdapter<String> mod2adapter1 = new ArrayAdapter<>(
                this,
                R.layout.picker_styles,
                getResources().getStringArray(R.array.credits_picker_array)
        );
        mod2adapter1.setDropDownViewResource(R.layout.picker_dropdown);
        mod2spinner1.setAdapter(mod2adapter1);


        //Module 3
        //Grades Picker
        Spinner mod3spinner = findViewById(R.id.module3gradepicker);

        ArrayAdapter<String> mod3adapter = new ArrayAdapter<>(
                this,
                R.layout.picker_styles,
                getResources().getStringArray(R.array.grades_picker_array)
        );
        mod3adapter.setDropDownViewResource(R.layout.picker_dropdown);
        mod3spinner.setAdapter(mod3adapter);

        //Credits Picker
        Spinner mod3spinner1 = findViewById(R.id.module3creditspicker);

        ArrayAdapter<String> mod3adapter1 = new ArrayAdapter<>(
                this,
                R.layout.picker_styles,
                getResources().getStringArray(R.array.credits_picker_array)
        );
        mod3adapter1.setDropDownViewResource(R.layout.picker_dropdown);
        mod3spinner1.setAdapter(mod3adapter1);


        //Module 4
        //Grades Picker
        Spinner mod4spinner = findViewById(R.id.module4gradepicker);

        ArrayAdapter<String> mod4adapter = new ArrayAdapter<>(
                this,
                R.layout.picker_styles,
                getResources().getStringArray(R.array.grades_picker_array)
        );
        mod4adapter.setDropDownViewResource(R.layout.picker_dropdown);
        mod4spinner.setAdapter(mod4adapter);

        //Credits Picker
        Spinner mod4spinner1 = findViewById(R.id.module4creditspicker);

        ArrayAdapter<String> mod4adapter1 = new ArrayAdapter<>(
                this,
                R.layout.picker_styles,
                getResources().getStringArray(R.array.credits_picker_array)
        );
        mod4adapter1.setDropDownViewResource(R.layout.picker_dropdown);
        mod4spinner1.setAdapter(mod4adapter1);


        //Module 5
        //Grades Picker
        Spinner mod5spinner = findViewById(R.id.module5gradepicker);

        ArrayAdapter<String> mod5adapter = new ArrayAdapter<>(
                this,
                R.layout.picker_styles,
                getResources().getStringArray(R.array.grades_picker_array)
        );
        mod5adapter.setDropDownViewResource(R.layout.picker_dropdown);
        mod5spinner.setAdapter(mod5adapter);

        //Credits Picker
        Spinner mod5spinner1 = findViewById(R.id.module5creditspicker);

        ArrayAdapter<String> mod5adapter1 = new ArrayAdapter<>(
                this,
                R.layout.picker_styles,
                getResources().getStringArray(R.array.credits_picker_array)
        );
        mod5adapter1.setDropDownViewResource(R.layout.picker_dropdown);
        mod5spinner1.setAdapter(mod5adapter1);


        //Direct to Previous Interface
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent semesterModNoIntent = new Intent(StudentSemesterResults.this, CalculateGPA.class);
                startActivity(semesterModNoIntent);
                finish();
            }
        });

        //Accessing child nodes
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Semester1").child("Results");

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

        //Data Inputs Module Names, Grades, and Credits and Save data in FireBase on button click Direct to Next Interface
        calculategpasubmitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (TextUtils.isEmpty(module1.getText().toString()) || TextUtils.isEmpty(module2.getText().toString()) || TextUtils.isEmpty(module3.getText().toString()) || TextUtils.isEmpty(module4.getText().toString()) || TextUtils.isEmpty(module5.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Module Names", Toast.LENGTH_LONG).show();
                    else {
                        reference.child("Module");
                        //Module 1
                        //Get all the Module 1 Details
                        String module1Name = module1.getText().toString();

                        //Set values in Module 1 Details Model Class
                        results.setModule(module1Name);
                        results.setGrade(mod1spinner.getSelectedItem().toString());
                        results.setCredit(mod1spinner2.getSelectedItem().toString());

                        maxid +=1;
                        reference.child("Module").child(String.valueOf(maxid)).setValue(results);
                        Toast.makeText(StudentSemesterResults.this, "Module 1 Details Added Successfully", Toast.LENGTH_LONG).show();

                        //Module 2
                        //Get all the Module 2 Details
                        String module2Name = module2.getText().toString();

                        //Set values in Module 2 Details Model Class
                        results.setModule(module2Name);
                        results.setGrade(mod2spinner.getSelectedItem().toString());
                        results.setCredit(mod2spinner1.getSelectedItem().toString());

                        maxid +=1;
                        reference.child("Module").child(String.valueOf(maxid)).setValue(results);
                        Toast.makeText(StudentSemesterResults.this, "Module 2 Details Added Successfully", Toast.LENGTH_LONG).show();

                        //Module 3
                        //Get all the Module 3 Details
                        String module3Name = module3.getText().toString();

                        //Set values in Module 3 Details Model Class
                        results.setModule(module3Name);
                        results.setGrade(mod3spinner.getSelectedItem().toString());
                        results.setCredit(mod3spinner1.getSelectedItem().toString());

                        maxid +=1;
                        reference.child("Module").child(String.valueOf(maxid)).setValue(results);
                        Toast.makeText(StudentSemesterResults.this, "Module 3 Details Added Successfully", Toast.LENGTH_LONG).show();

                        //Module 4
                        //Get all the Module 4 Details
                        String module4Name = module4.getText().toString();

                        //Set values in Module 4 Details Model Class
                        results.setModule(module4Name);
                        results.setGrade(mod4spinner.getSelectedItem().toString());
                        results.setCredit(mod4spinner1.getSelectedItem().toString());

                        maxid +=1;
                        reference.child("Module").child(String.valueOf(maxid)).setValue(results);
                        Toast.makeText(StudentSemesterResults.this, "Module 4 Details Added Successfully", Toast.LENGTH_LONG).show();

                        //Module 5
                        //Get all the Module 5 Details
                        String module5Name = module5.getText().toString();

                        //Set values in Module 5 Details Model Class
                        results.setModule(module5Name);
                        results.setGrade(mod5spinner.getSelectedItem().toString());
                        results.setCredit(mod5spinner1.getSelectedItem().toString());

                        maxid +=1;
                        reference.child("Module").child(String.valueOf(maxid)).setValue(results);
                        Toast.makeText(StudentSemesterResults.this, "Module 5 Details Added Successfully", Toast.LENGTH_LONG).show();
                        clear();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid Number Type", Toast.LENGTH_LONG).show();
                }
                //Retrieve Grades Data
//                ArrayList<Results> ary = new ArrayList<>();//Create array list object
//                ary.add(new Results(module1.getText().toString(), mod1spinner.getSelectedItem().toString(), mod1spinner2.getSelectedItem().toString()));
//                ary.add(new Results(module2.getText().toString(), mod2spinner.getSelectedItem().toString(), mod2spinner1.getSelectedItem().toString()));
//                ary.add(new Results(module3.getText().toString(), mod3spinner.getSelectedItem().toString(), mod3spinner1.getSelectedItem().toString()));
//                ary.add(new Results(module4.getText().toString(), mod4spinner.getSelectedItem().toString(), mod4spinner1.getSelectedItem().toString()));
//                ary.add(new Results(module5.getText().toString(), mod5spinner.getSelectedItem().toString(), mod5spinner1.getSelectedItem().toString()));
//
//                System.out.println(ary);
//                //Calculate GPA
//                for (Results i:ary){
//                    gpa=(gpa+getGradePoint(i))/5f;
//                }
//                System.out.println(gpa);
                Intent finalGPAIntent = new Intent(StudentSemesterResults.this, FinalGPA.class);
                finalGPAIntent.putExtra("grade1", mod1spinner.getSelectedItem().toString());
                finalGPAIntent.putExtra("grade2", mod2spinner.getSelectedItem().toString());
                finalGPAIntent.putExtra("grade3", mod3spinner.getSelectedItem().toString());
                finalGPAIntent.putExtra("grade4", mod4spinner.getSelectedItem().toString());
                finalGPAIntent.putExtra("grade5", mod5spinner.getSelectedItem().toString());
                startActivity(finalGPAIntent);
            }
        });

    }


    //Clear Module Names Method
    public void clear() {
        module1.setText(null);
        module2.setText(null);
        module3.setText(null);
        module4.setText(null);
        module5.setText(null);
    }


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