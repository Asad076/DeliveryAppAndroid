package com.itridtechnologies.codenamefive.javaClasses;

public class RiderTripDetailRV {

    private int mImageResource;
    private String mEarningsFromDate;
    private String mEarningsToDate;
    private double mEarnedRupees;

    public RiderTripDetailRV(int mImageResource, String mEarningsFromDate, String mEarningsToDate, double mEarnedRupees) {
        this.mImageResource = mImageResource;
        this.mEarningsFromDate = mEarningsFromDate;
        this.mEarningsToDate = mEarningsToDate;
        this.mEarnedRupees = mEarnedRupees;
    }//constructor

    //getter methods

    public int getImageResource() {
        return mImageResource;
    }

    public String getEarningsFromDate() {
        return mEarningsFromDate;
    }

    public String getEarningsToDate() {
        return mEarningsToDate;
    }

    public double getEarnedRupees() {
        return mEarnedRupees;
    }
}//end class
