package com.example.fitnessapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.fitnessapplication.R;
import com.example.fitnessapplication.model.ActivityHistoryModel;

import java.util.List;

import pl.droidsonroids.gif.GifImageView;

// This class is used to assign value to activity_history_row.xml
public class ActivityHistoryAdapter extends ArrayAdapter<ActivityHistoryModel> {

    //This is the constructor of the class
    public ActivityHistoryAdapter(Context context, List<ActivityHistoryModel> activityHistories) {
        super(context, 0, activityHistories);
    }

    //The getView method is an inherited method from ArrayAdapter class
    //This method is used to get the elements in the xml file and
    //inject the value and it will return the View that has been injected
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ActivityHistoryModel activityHistoryModel = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_history_row, parent, false);
        }

        //Initializing all the variables for the TextView and GifImageView
        //The TextView and GifImageView are from the activity_history_row.xml
        //by getting the id
        TextView activityText = convertView.findViewById(R.id.activityText);
        TextView caloriesBurnedText = convertView.findViewById(R.id.caloriesBurnedText);
        TextView amountDoneText = convertView.findViewById(R.id.activityAmountText);
        TextView durationText = convertView.findViewById(R.id.durationText);
        GifImageView gifImageView = convertView.findViewById(R.id.gifImage);

        //Setting the value of the TextView and GifImageView
        activityText.setText(activityHistoryModel.getActivityName());
        caloriesBurnedText.setText(activityHistoryModel.getCaloriesBurned());
        amountDoneText.setText(activityHistoryModel.getAmountDone());
        durationText.setText(activityHistoryModel.getDuration());
        gifImageView.setImageResource(activityHistoryModel.getGifSrc());

        return convertView;
    }

}
