package com.example.madexamshedule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddDetails extends AppCompatActivity {

    //Creating objects
    TextView txt_add_schedule, textView, textView3, textView4, textView5, textView6;
    EditText edt_course, edt_date, edt_start, edt_end, edt_venue;
    Button btn_add_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        //To find the id
        txt_add_schedule = findViewById(R.id.txt_add_schedule);
        textView = findViewById(R.id.textView);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);

        edt_course = findViewById(R.id.edt_course);
        edt_date = findViewById(R.id.edt_date);
        edt_start = findViewById(R.id.edt_start);
        edt_end = findViewById(R.id.edt_end);
        edt_venue = findViewById(R.id.edt_venue);

        btn_add_details = findViewById(R.id.btn_add_details);

        btn_add_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                DatabaseHelper dbHelper = new DatabaseHelper(AddDetails.this);

                //Validations
                if(TextUtils.isEmpty(edt_course.getText())) {
                    edt_course.setError("Please enter the exam details");
                    edt_course.requestFocus();
                }
                else if(TextUtils.isEmpty(edt_date.getText())) {
                    edt_date.setError("Please enter the exam date");
                    edt_date.requestFocus();
                }
                else if(TextUtils.isEmpty(edt_start.getText())) {
                    edt_start.setError("Please enter the starting time");
                    edt_start.requestFocus();
                }
                else if(TextUtils.isEmpty(edt_end.getText())) {
                    edt_end.setError("Please enter the ending time");
                    edt_end.requestFocus();
                }
                else if(TextUtils.isEmpty(edt_venue.getText())) {
                    edt_venue.setError("Please enter the venue");
                    edt_venue.requestFocus();
                }
                else {
                    dbHelper.addSchedule(edt_course.getText().toString().trim(),
                            edt_date.getText().toString().trim(),
                            edt_start.getText().toString().trim(),
                            edt_end.getText().toString().trim(),
                            edt_venue.getText().toString().trim());
                }
            }
        });
    }
}