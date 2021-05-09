package com.example.shedulehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editShedule extends AppCompatActivity {
    private EditText mcode,mname,day,classroom,from,to;
    private Button save;
    private DatabaseHelper databaseHelper;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_shedule);

        context=this;
        databaseHelper=new DatabaseHelper(context);

        mcode=findViewById(R.id.editmcode);
        mname=findViewById(R.id.editmname);
        day=findViewById(R.id.editday);
        classroom=findViewById(R.id.editclass);
        from=findViewById(R.id.editfrom);
        to=findViewById(R.id.editTo);
        save=findViewById(R.id.btnSave);


        final String mCode=getIntent().getStringExtra("mcode");
        Shedule shedule=databaseHelper.getSingleShedule(mCode);

        mcode.setText(shedule.getMcode());
        mname.setText(shedule.getName());
        day.setText(shedule.getDay());
        classroom.setText(shedule.getClasrom());
        from.setText(shedule.getFrm());
        to.setText(shedule.getTo());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mcodeText=mcode.getText().toString();
                String mnameText=mname.getText().toString();
                String mdayText=day.getText().toString();
                String mclassroomText=classroom.getText().toString();
                String mfromText=from.getText().toString();
                String mtoText=to.getText().toString();

                Shedule shedule=new Shedule(mcodeText,mnameText, mdayText,mclassroomText, mfromText,mtoText);
                int state=databaseHelper.updateSingleShedule(shedule);
                startActivity(new Intent(context,MainActivity .class));
            }
        });

    }
}