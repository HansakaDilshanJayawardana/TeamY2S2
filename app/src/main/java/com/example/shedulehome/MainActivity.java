package com.example.shedulehome;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private FloatingActionButton add;
    private ListView listView;
    private TextView count;
    private RecyclerView recyclerView;
    Context context;
    private DatabaseHelper databaseHelper;
    private List<Shedule> shedules;


    AdapterShedule adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        context = this;

        databaseHelper = new DatabaseHelper(context);
        add = findViewById(R.id.floatingActionButton);
        listView = findViewById(R.id.sheduleList);
        count = findViewById(R.id.sheduleCount);
        shedules = new ArrayList<>();



        shedules = databaseHelper.getAllshedules();

        AdapterShedule adapter = new AdapterShedule(context, R.layout.activity_single_shedule, shedules);
        listView.setAdapter(adapter);


        //get shedules count
        int countShedules = databaseHelper.countShedule();
        count.setText("You have " +  countShedules  + " Shedules ");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, addNewShedule.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               final Shedule shedule=shedules.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(shedule.getTo());
                builder.setMessage(shedule.getName());



                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(context,MainActivity.class));
                    }

                });
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    databaseHelper.deleteShedule(shedule.mcode);
                    startActivity(new Intent(context,MainActivity.class));
                    }
                });
                    builder.setNeutralButton("Update",new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                           Intent intent=new Intent(context,editShedule.class);
                            intent.putExtra("mcode",String.valueOf(shedule.getMcode()));
                            startActivity(intent);
                        }
                    });
                builder.show();
            }
        });
    }



}







