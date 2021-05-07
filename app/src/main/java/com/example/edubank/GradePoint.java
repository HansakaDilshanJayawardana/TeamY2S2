package com.example.edubank;

public class GradePoint {
    //Declare Variables
    private float aPlusPoint, aPoint, aMinusPoint, bPlusPoint, bPoint, bMinusPoint, cPlusPoint, cPoint, cMinusPoint, dPlusPoint, dPoint, ePoint;

    //Default Constructor
    public GradePoint() {
    }

    //Parameterized Constructor
    public GradePoint(float aPlusPoint, float aPoint, float aMinusPoint, float bPlusPoint, float bPoint, float bMinusPoint, float cPlusPoint, float cPoint, float cMinusPoint, float dPlusPoint, float dPoint, float ePoint) {
        this.aPlusPoint = aPlusPoint;
        this.aPoint = aPoint;
        this.aMinusPoint = aMinusPoint;
        this.bPlusPoint = bPlusPoint;
        this.bPoint = bPoint;
        this.bMinusPoint = bMinusPoint;
        this.cPlusPoint = cPlusPoint;
        this.cPoint = cPoint;
        this.cMinusPoint = cMinusPoint;
        this.dPlusPoint = dPlusPoint;
        this.dPoint = dPoint;
        this.ePoint = ePoint;
    }

    //Setters and Getters
    public float getaPlusPoint() {
        return aPlusPoint;
    }

    public void setaPlusPoint(float aPlusPoint) {
        this.aPlusPoint = aPlusPoint;
    }

    public float getaPoint() {
        return aPoint;
    }

    public void setaPoint(float aPoint) {
        this.aPoint = aPoint;
    }

    public float getaMinusPoint() {
        return aMinusPoint;
    }

    public void setaMinusPoint(float aMinusPoint) {
        this.aMinusPoint = aMinusPoint;
    }

    public float getbPlusPoint() {
        return bPlusPoint;
    }

    public void setbPlusPoint(float bPlusPoint) {
        this.bPlusPoint = bPlusPoint;
    }

    public float getbPoint() {
        return bPoint;
    }

    public void setbPoint(float bPoint) {
        this.bPoint = bPoint;
    }

    public float getbMinusPoint() {
        return bMinusPoint;
    }

    public void setbMinusPoint(float bMinusPoint) {
        this.bMinusPoint = bMinusPoint;
    }

    public float getcPlusPoint() {
        return cPlusPoint;
    }

    public void setcPlusPoint(float cPlusPoint) {
        this.cPlusPoint = cPlusPoint;
    }

    public float getcPoint() {
        return cPoint;
    }

    public void setcPoint(float cPoint) {
        this.cPoint = cPoint;
    }

    public float getcMinusPoint() {
        return cMinusPoint;
    }

    public void setcMinusPoint(float cMinusPoint) {
        this.cMinusPoint = cMinusPoint;
    }

    public float getdPlusPoint() {
        return dPlusPoint;
    }

    public void setdPlusPoint(float dPlusPoint) {
        this.dPlusPoint = dPlusPoint;
    }

    public float getdPoint() {
        return dPoint;
    }

    public void setdPoint(float dPoint) {
        this.dPoint = dPoint;
    }

    public float getePoint() {
        return ePoint;
    }

    public void setePoint(float ePoint) {
        this.ePoint = ePoint;
    }
}
