package com.example.fitnessapplication.model;

//This class is used as the activity_history_row.xml model
//That will be used by the adapter class
public class ActivityHistoryModel {

    //Creating variables that will be used by the activity_history_row.xml
    private final String activityName;
    private final String caloriesBurned;
    private final String amountDone;
    private final String duration;
    private final int gifSrc;

    //This is the constructor of the class
    public ActivityHistoryModel(String activityName, String caloriesBurned, String amountDone, String duration, int gifSrc) {
        this.activityName = activityName;
        this.caloriesBurned = caloriesBurned;
        this.amountDone = amountDone;
        this.duration = duration;
        this.gifSrc = gifSrc;
    }

    //The methods bellow is the getter of the variables that were created.
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
