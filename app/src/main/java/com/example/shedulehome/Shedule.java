package com.example.shedulehome;

public class Shedule {

    String mcode,name,day,clasrom,frm,to;

    public Shedule(){

    }
    public Shedule(String mcode,String name,String day,String frm,String to,String clasrom) {
        this.mcode = mcode;
        this.name=name;
        this.day=day;
        this.frm=frm;
        this.to=to;
        this.clasrom=clasrom;

    }

    public String getMcode() {
        return mcode;
    }

    public void setMcode(String mcode) {
        this.mcode = mcode;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDay(){
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
    public String getFrm() {
        return frm;
    }

    public void setFrm(String frm) {
        this.frm = frm;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }


    public String getClasrom() {
        return clasrom;
    }

    public void setClasrom(String clasrom) {
        this.clasrom = clasrom;
    }


}
