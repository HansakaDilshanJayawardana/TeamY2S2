package com.example.madexamshedule;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateDetails extends AppCompatActivity {

    //Creating objects
    TextView txtCourse2, txtDate2, txtStart2, txtEnd2, txtVenue2;
    EditText edt_course, edt_date, edt_start, edt_end, edt_venue;
    Button btnUpdate, btnDelete;

    String id, course, date, start, end, venue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details);

        //To find the id
        txtCourse2 = findViewById(R.id.txtCourse2);
        txtDate2 = findViewById(R.id.txtDate2);
        txtStart2 = findViewById(R.id.txtStart2);
        txtEnd2 = findViewById(R.id.txtEnd2);
        txtVenue2 = findViewById(R.id.txtVenue2);

        edt_course = findViewById(R.id.edt_course2);
        edt_date = findViewById(R.id.edt_date2);
        edt_start = findViewById(R.id.edt_start2);
        edt_end = findViewById(R.id.edt_end2);
        edt_venue = findViewById(R.id.edt_venue2);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar actionbar = getSupportActionBar();

        if(actionbar != null) {
            actionbar.setTitle(course);
        }

        btnUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //And only then we call this
                DatabaseHelper dbHelper = new DatabaseHelper(UpdateDetails.this);

                course = edt_course.getText().toString().trim();
                date = edt_date.getText().toString().trim();
                start = edt_start.getText().toString().trim();
                end = edt_end.getText().toString().trim();
                venue = edt_venue.getText().toString().trim();

                dbHelper.updateDetails(id, course, date, start, end, venue);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                dialogConfirmation();
            }
        });


    }

    void getAndSetIntentData() {
        if(getIntent().hasExtra("id") && getIntent().hasExtra("course") && getIntent().hasExtra("date") && getIntent().hasExtra("start") && getIntent().hasExtra("end") && getIntent().hasExtra("venue")){

            //Getting data from Intent
            id = getIntent().getStringExtra("id");
            course = getIntent().getStringExtra("course");
            date = getIntent().getStringExtra("date");
            start = getIntent().getStringExtra("start");
            end = getIntent().getStringExtra("end");
            venue = getIntent().getStringExtra("venue");

            //Setting Intent data
            edt_course.setText(course);
            edt_date.setText(date);
            edt_start.setText(start);
            edt_end.setText(end);
            edt_venue.setText(venue);
        }
        else {
            Toast.makeText(this, "No data available", Toast.LENGTH_LONG).show();
        }
    }

    void dialogConfirmation(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Delete " + course + " ?");
        builder.setMessage("Do you want to delete " + course + " ?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                DatabaseHelper dbHelper = new DatabaseHelper(UpdateDetails.this);
                dbHelper.deleteOneRow(id);
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){

            }
        });
        builder.create().show();
    }
}