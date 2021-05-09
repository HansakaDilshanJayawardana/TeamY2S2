package com.example.shedulehome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;



public class  AdapterShedule extends ArrayAdapter<Shedule>{


    private Context context;
    DatabaseHelper databaseHelper;
    private int resource;
    List<Shedule>shedules;

    //private TextView mname,mcode,date,timeFrm,timeTo,classrom;

    AdapterShedule(Context context,int resource,List<Shedule>shedules){
        super(context,resource,shedules);
        this.context=context;
        this.resource=resource;
        this.shedules=shedules;
    }

    /*public AdapterShedule(@NonNull Context context, int resource,List<Shedule>shedules) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
        this.shedules=shedules;
    }*/

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View row=inflater.inflate(resource,parent,false);

        TextView mday=row.findViewById(R.id.moduleDay);
        TextView mname=row.findViewById(R.id.moduleName);
        TextView mfrom=row.findViewById(R.id.moduleFrom);
        TextView mto=row.findViewById(R.id.mouledTo);
        TextView mclassroom=row.findViewById(R.id.moduleclassroom);
        TextView mcode=row.findViewById(R.id.moduleCode);





        //shedules
        Shedule shedule=shedules.get(position);
        mday.setText(shedule.getDay());
        mname.setText(shedule.getName());
        mfrom.setText(shedule.getFrm());
        mto.setText(shedule.getTo());
        mclassroom.setText(shedule.getClasrom());
        mcode.setText(shedule.getMcode());






        return row;
        //return super.getView(position, convertView, parent);
    }
}
    /*  public AdapterShedule(List<Shedule> shedules, main_page main_page){
          this.shedules=shedules;
          this.context=context;
          databaseHelper=new DatabaseHelper(context);
      }*/

  /*  @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
       LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.activity_main,viewGroup,false);
       //View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main,viewGroup,false);

        return new MyViewHolder(view);
    }*/


  /*  @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

         Shedule shedule=shedules.get(i);

        myViewHolder.mcode.setText(shedule.getMcode());
        myViewHolder.mname.setText(shedule.getName());
        myViewHolder.mday.setText(shedule.getDay());
       myViewHolder.from.setText(shedule.getFrm());
        myViewHolder.to.setText(shedule.getTo());
        myViewHolder.classroom.setText(shedule.getClasrom());
    }

    @Override
    public int getItemCount() {
        return shedules.size();
    }

        }
*/