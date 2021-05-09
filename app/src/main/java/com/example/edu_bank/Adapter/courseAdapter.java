package com.example.edu_bank.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.edu_bank.AddNewTask;
import com.example.edu_bank.Courses;
import com.example.edu_bank.Model.courseModel;
import com.example.edu_bank.R;
import com.example.edu_bank.Utils.DatabaseHandler;

import java.util.List;

public class courseAdapter extends RecyclerView.Adapter<courseAdapter.ViewHolder>{

    private List <courseModel> courseList;
    private Courses activity;
    private DatabaseHandler db;

    public courseAdapter(DatabaseHandler db,Courses activity) {

        this.activity = activity;
        this.db=db;
    }

    public static void setCourses(List<courseModel> courseList) {
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(itemView);
    }


    public void onBindViewHolder(@NonNull courseAdapter.ViewHolder holder, int position) {
        final courseModel item = courseList.get(position);
        holder.course.setText(item.getCourse());
        holder.course.setChecked(toBoolean(item.getStatus()));
        db.openDatabase();

        holder.course.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    db.updateStatus(item.getId(), 1);
                } else {
                    db.updateStatus(item.getId(), 0);
                }
            }
        });
    }

    private boolean toBoolean(int n) {
        return n != 0;
    }


    public int getItemCount() {
        return courseList.size();
    }


    public void setCourse(List<courseModel> courseList) {
        this.courseList = courseList;
        notifyDataSetChanged();
    }



    public void deleteItem(int position) {
        courseModel item = courseList.get(position);
        db.deleteTask(item.getId());
        courseList.remove(position);
        notifyItemRemoved(position);
    }

    public void editItem(int position) {
        courseModel item = courseList.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("id", item.getId());
        bundle.putString("task", item.getCourse());
        AddNewTask fragment = new AddNewTask();
        fragment.setArguments(bundle);
        fragment.show(activity.getSupportFragmentManager(), AddNewTask.TAG);
    }

    public Context getContext() {
        return activity;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox course;

        ViewHolder(View view) {
            super(view);
            course = view.findViewById(R.id.todoCheckBox);
        }
    }
}








