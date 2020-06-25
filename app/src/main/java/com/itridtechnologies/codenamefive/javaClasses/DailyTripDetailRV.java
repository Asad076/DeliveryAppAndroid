package com.itridtechnologies.codenamefive.javaClasses;

public class DailyTripDetailRV {

    private int mImageResource;
    private String mDate;
    private String mTotalTrips;
    private double mEarningsPerTrip;

    public DailyTripDetailRV(int mImageResource, String mDate, String mTotalTrips, double mEarningsPerTrip) {
        this.mImageResource = mImageResource;
        this.mDate = mDate;
        this.mTotalTrips = mTotalTrips;
        this.mEarningsPerTrip = mEarningsPerTrip;
    }//constructor
    //getter methods

    public int getImageResource() {
        return mImageResource;
    }

    public String getDate() {
        return mDate;
    }

    public String getTotalTrips() {
        return mTotalTrips;
    }

    public double getEarningsPerTrip() {
        return mEarningsPerTrip;
    }
}//end class
