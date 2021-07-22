package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> versionList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        versionList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        TextView tvSinger = rowView.findViewById(R.id.tvSingers);
        TextView tvStars = rowView.findViewById(R.id.tvStars);

        // Obtain the Android Version information based on the position
        Song currentSong = versionList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentSong.getTitle());
        tvYear.setText(currentSong.getYearReleased() + "");
        tvSinger.setText(currentSong.getSingers());

        if (currentSong.getStars() == 1) {
            tvStars.setText("*");
        }
        else if (currentSong.getStars() == 2) {
            tvStars.setText("**");
        }
        else if (currentSong.getStars() == 3) {
            tvStars.setText("***");
        }
        else if (currentSong.getStars() == 4) {
            tvStars.setText("****");
        }
        else if (currentSong.getStars() == 5) {
            tvStars.setText("*****");
        }

        return rowView;
    }
}