package com.zatsando.afterformattool;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class MyListViewAdapter extends ArrayAdapter<Application> {

    private final Activity context;
    private ArrayList<Application>applications;
    public MyListViewAdapter(@NonNull Activity context, ArrayList<Application> apps) {
        super(context, R.layout.list_item);
        this.context = context;
        this.applications = apps;
    }


    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_item, null,true);

        TextView textViewName = (TextView) rowView.findViewById(R.id.textViewName);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        CheckBox isChecked = (CheckBox) rowView.findViewById(R.id.isChecked);

        Application application = applications.get(position);

        textViewName.setText(application.getAppName());
        imageView.setImageResource(application.getImageOfApp());
        isChecked.setChecked(application.isChecked());

        return rowView;
    }


}
