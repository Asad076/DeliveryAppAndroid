package com.itridtechnologies.codenamefive.javaClasses;

public class TripDayDataRV {

    private int mImageResource;
    private String restaurantName;
    private String tripStartTime;
    private String tripEndTime;
    private double riderTip;
    private double tripCost;

    public TripDayDataRV(int mImageResource, String restaurantName, String tripStartTime, String tripEndTime, double riderTip, double tripCost) {
        this.mImageResource = mImageResource;
        this.restaurantName = restaurantName;
        this.tripStartTime = tripStartTime;
        this.tripEndTime = tripEndTime;
        this.riderTip = riderTip;
        this.tripCost = tripCost;
    }//constructor

    //getter methods

    public int getImageResource() {
        return mImageResource;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getTripStartTime() {
        return tripStartTime;
    }

    public String getTripEndTime() {
        return tripEndTime;
    }

    public double getRiderTip() {
        return riderTip;
    }

    public double getTripCost() {
        return tripCost;
    }
}//end class
