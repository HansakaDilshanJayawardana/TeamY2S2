package com.example.shedulehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.recyclerview.widget.LinearLayoutManager;

public class addNewShedule extends AppCompatActivity {

   private EditText mcode,mname,mfrom,mto,mclasroom,mday;
     private Button cancel,save;
  private DatabaseHelper databaseHelper;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_shedule);

        //getting user inputs from the textfields
        mcode=findViewById(R.id.inmcode);
        mname=findViewById(R.id.inmod);
        mfrom=findViewById(R.id.intimefrom);
        mto=findViewById(R.id.intimeto);
        mclasroom=findViewById(R.id.intclass);
        mday=findViewById(R.id.inday);

        cancel=findViewById(R.id.cacnel);
        save=findViewById(R.id.Save);
        context=this;

        databaseHelper=new DatabaseHelper(context);

        save.setOnClickListener(v -> {
            String stringMcode=mcode.getText().toString();
            String stringMname=mname.getText().toString();
            String stringfrom=mfrom.getText().toString();
            String stringTo=mto.getText().toString();
            String stringDay=mday.getText().toString();
            String stringClass=mclasroom.getText().toString();

            Shedule shedule1=new Shedule(stringMcode,stringMname, stringfrom,stringTo,stringDay,stringClass);
            databaseHelper.addShedule(shedule1);
            Intent intent=new Intent(addNewShedule.this,MainActivity.class);

            startActivity(intent);

        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(addNewShedule.this,MainActivity.class);
                startActivity(intent);

            }
        });

      /*   save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringMcode=mcode.getText().toString();
                String stringMname=mname.getText().toString();
                String stringfrom=from.getText().toString();
                String stringTo=to.getText().toString();
                String stringClass=clasroom.getText().toString();
                String stringDay=day.getText().toString();

                DatabaseHelper databaseHelper=new DatabaseHelper(addNewShedule.this);
                Shedule shedule=new Shedule(stringMcode,stringMname,stringDay,stringClass,stringfrom,stringTo);
                databaseHelper.addShedule(stringMcode,stringMname,stringfrom,stringTo,stringClass,stringDay);

                startActivity(new Intent(context,MainActivity.class));

              //  if(stringDay=="Monday"||stringDay=="Tuesday"||stringDay=="Wednesday"||stringDay=="Thursday"||stringDay=="Friday"
               //         ||stringDay=="Saturday"||stringDay=="Sunday"){
                  //  DatabaseHelper databaseHelper=new DatabaseHelper(addNewShedule.this);
                    //Shedule shedule=new Shedule(stringMcode,stringMname,stringfrom,stringTo,stringClass,stringDay);
                    //databaseHelper.addshedule(shedule);
                    //Toast.makeText(addNewShedule.this,"Shedule Added Successfully",Toast.LENGTH_SHORT).show();
                    //finish();
                    //startActivity(getIntent());
              //  Intent intent =new Intent(addNewShedule.this,main_page.class);
                //startActivity(intent);
               // }
                //else{
                  //  Toast.makeText(addNewShedule.this,"Invalid day",Toast.LENGTH_SHORT).show();
                    //finish();
                    //startActivity(getIntent());
                //}
            }
        });*/
    }

}