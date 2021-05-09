package com.example.edu_bank;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.edu_bank.Adapter.courseAdapter;
import com.example.edu_bank.Model.courseModel;
import com.example.edu_bank.Utils.DatabaseHandler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Courses extends AppCompatActivity implements DialogCloseListener {

    private RecyclerView tasksRecyclerView;
    private courseAdapter CAdapter;
    private List<courseModel> courseList;
    private DatabaseHandler db;
    private FloatingActionButton fab;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        getSupportActionBar().hide();

        db = new DatabaseHandler(this);
        db.openDatabase();

        courseList=new ArrayList<>();


        tasksRecyclerView = findViewById(R.id.tasksRecyclerView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        CAdapter=new courseAdapter(db,Courses.this);
        tasksRecyclerView.setAdapter(CAdapter);

        ItemTouchHelper itemTouchHelper = new
                ItemTouchHelper(new RecyclerItemTouchHelper(CAdapter));
        itemTouchHelper.attachToRecyclerView(tasksRecyclerView);

        fab = findViewById(R.id.imageButton5);

        courseList = db.getAllTasks();
        Collections.reverse(courseList);
        CAdapter.setCourses(courseList);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewTask.newInstance().show(getSupportFragmentManager(), AddNewTask.TAG);
            }
        });
    }
    @Override
    public void handleDialogClose(DialogInterface dialog){
        courseList = db.getAllTasks();
        Collections.reverse(courseList);
        CAdapter.setCourses(courseList);
        CAdapter.notifyDataSetChanged();
    }
}