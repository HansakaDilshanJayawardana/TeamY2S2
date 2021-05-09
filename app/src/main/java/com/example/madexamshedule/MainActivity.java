package com.example.madexamshedule;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Creating objects
    RecyclerView recyclerView;
    FloatingActionButton btn_add;

    DatabaseHelper dbHelper;
    ArrayList<String> user_id, user_course, user_date, user_start, user_end, user_venue;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To find the id
        recyclerView = findViewById(R.id.recyclerView);
        btn_add = findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddDetails.class);
                startActivity(intent);
            }
        });

        dbHelper = new DatabaseHelper(MainActivity.this);

        //Initializing
        user_id = new ArrayList<>();
        user_course = new ArrayList<>();
        user_date = new ArrayList<>();
        user_start = new ArrayList<>();
        user_end = new ArrayList<>();
        user_venue = new ArrayList<>();

        storeDataInArray();

        userAdapter = new UserAdapter(MainActivity.this, this, user_id, user_course, user_date, user_start, user_end, user_venue);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            //To refresh the main activity to start again
            recreate();
        }
    }

    void storeDataInArray(){
        Cursor cursor = dbHelper.readAllData();

        if(cursor.getCount() == 0) {
            Toast.makeText(this, "No data available", Toast.LENGTH_LONG).show();
        }
        else {
            while(cursor.moveToNext()) {
                user_id.add(cursor.getString(0));
                user_course.add(cursor.getString(1));
                user_date.add(cursor.getString(2));
                user_start.add(cursor.getString(3));
                user_end.add(cursor.getString(4));
                user_venue.add(cursor.getString(5));
            }
        }
    }
}