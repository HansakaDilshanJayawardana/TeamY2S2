package com.example.madexamshedule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList user_id, user_course, user_date, user_start, user_end, user_venue;


    //Constructor
    UserAdapter(Activity activity, Context context, ArrayList user_id, ArrayList user_course, ArrayList user_date, ArrayList user_start, ArrayList user_end, ArrayList user_venue){
        this.activity = activity;
        this.context = context;
        this.user_id = user_id;
        this.user_course = user_course;
        this.user_date = user_date;
        this.user_start = user_start;
        this.user_end = user_end;
        this.user_venue = user_venue;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //To inflate row layout for the recycler view
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.display_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.txt_user_id.setText(String.valueOf(user_id.get(position)));
        holder.txt_user_course.setText(String.valueOf(user_course.get(position)));
        holder.txt_user_date.setText(String.valueOf(user_date.get(position)));
        holder.txt_user_start.setText(String.valueOf(user_start.get(position)));
        holder.txt_user_end.setText(String.valueOf(user_end.get(position)));
        holder.txt_user_venue.setText(String.valueOf(user_venue.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateDetails.class);

                intent.putExtra("id", String.valueOf(user_id.get(position)));
                intent.putExtra("course", String.valueOf(user_course.get(position)));
                intent.putExtra("date", String.valueOf(user_date.get(position)));
                intent.putExtra("start", String.valueOf(user_start.get(position)));
                intent.putExtra("end", String.valueOf(user_end.get(position)));
                intent.putExtra("venue", String.valueOf(user_venue.get(position)));

                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return user_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        //Creating objects
        TextView txt_user_id, txt_user_course, txt_user_date, txt_user_start, txt_user_end, txt_user_venue;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //To get the id
            txt_user_id = itemView.findViewById(R.id.txt_user_id);
            txt_user_course = itemView.findViewById(R.id.txt_user_course);
            txt_user_date = itemView.findViewById(R.id.txt_user_date);
            txt_user_start = itemView.findViewById(R.id.txt_user_start);
            txt_user_end = itemView.findViewById(R.id.txt_user_end);
            txt_user_venue = itemView.findViewById(R.id.txt_user_venue);

            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
