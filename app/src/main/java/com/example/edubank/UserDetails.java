package com.example.edubank;

public class UserDetails {
    //Declare Variables
    private String userName, universityName;

    //Default Constructor
    public UserDetails() {
    }

    //Parameterized Constructor
    public UserDetails(String userName, String universityName) {
        this.userName = userName;
        this.universityName = universityName;
    }

    //Setters and Getters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
