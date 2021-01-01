package com.zatsando.afterformattool;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyListViewAdapter extends ArrayAdapter<Application> {

    private final Activity context;
    private ArrayList<Application> applications;
    private Button clearBtn;
    Button downloadBtn;

    @SuppressLint("ResourceType")
    public MyListViewAdapter(@NonNull Activity context, ArrayList<Application> apps) {
        super(context, 0, apps);
        this.context = context;
        this.applications = apps;
        clearBtn = context.findViewById(R.id.clearBtn);
        downloadBtn = context.findViewById(R.id.downloadBtn);

    }


    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        }

        TextView textViewName = (TextView) view.findViewById(R.id.textViewName);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        CheckBox isChecked = (CheckBox) view.findViewById(R.id.isChecked);

        Application application = applications.get(position);

        textViewName.setText(application.getAppName());
        imageView.setImageResource(application.getImageOfApp());
        isChecked.setChecked(application.isChecked());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageCheckedItem(application, isChecked);

//                if (isChecked.isChecked()) {
//                    linearLayout.setBackgroundColor(R.color.white);
//                } else {
//                    linearLayout.setBackgroundColor(R.color.selected);
//
//                }
            }
        });

        isChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageCheckedItem(application, isChecked);
            }
        });

        return view;
    }

    private void manageCheckedItem(Application application, CheckBox isChecked) {
        if (application.isChecked()) {
            Toast.makeText(context, "Removed " + application.getAppName(), Toast.LENGTH_SHORT).show();
            isChecked.setChecked(false);
            application.setChecked(false);
        } else {
            Toast.makeText(context, "Added " + application.getAppName(), Toast.LENGTH_SHORT).show();
            isChecked.setChecked(true);
            application.setChecked(true);
        }

//        HERE HIDES THE BUTTONS IF IS NOONE CHECKED ITEM
        boolean isAnyChecked = false;
        int countSelectedApps = 0;
        for (Application app : applications) {

            if (app.isChecked()) {
                clearBtn.setVisibility(View.VISIBLE);
                downloadBtn.setVisibility(View.VISIBLE);
                isAnyChecked = true;
                countSelectedApps++;
            }
            if (!isAnyChecked) {
                clearBtn.setVisibility(View.GONE);
                downloadBtn.setVisibility(View.GONE);
            }
        }
        downloadBtn.setText("(" + countSelectedApps + ") TO DOWNLOAD");


    }

}
