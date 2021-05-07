package com.example.edubank;

public class Results {
    //Declare Variables
    private String module, grade, credit;

    //Default Constructor
    public Results() {
    }

    //Parameterized Constructor
    public Results(String module, String grade, String credit) {
        this.module = module;
        this.grade = grade;
        this.credit = credit;
    }

    //Setters and Getters
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }
}
