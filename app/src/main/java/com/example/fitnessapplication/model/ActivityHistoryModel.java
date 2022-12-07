package com.example.fitnessapplication.model;

//This class is used as the activity_history_row.xml model
//That will be used by the adapter class
public class ActivityHistoryModel {

    private String activityName;
    private String caloriesBurned;
    private String amountDone;
    private String duration;
    private int gifSrc;

    public ActivityHistoryModel(String activityName, String caloriesBurned, String amountDone, String duration, int gifSrc) {
        this.activityName = activityName;
        this.caloriesBurned = caloriesBurned;
        this.amountDone = amountDone;
        this.duration = duration;
        this.gifSrc = gifSrc;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getCaloriesBurned() {
        return caloriesBurned;
    }

    public String getAmountDone() {
        return amountDone;
    }

    public String getDuration() {
        return duration;
    }

    public int getGifSrc() {
        return gifSrc;
    }
}
