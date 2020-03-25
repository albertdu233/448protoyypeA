package com.example.a448protoyypea;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RequestAdapter extends ArrayAdapter<Request> {

    private static final String LOG_TAG = RequestAdapter.class.getSimpleName();
    public RequestAdapter(Activity context, ArrayList<Request> Requests) {
        super(context, 0, Requests);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Request currentDesert = getItem(position);
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.request_driver_name);
        nameTextView.setText(currentDesert.getDriver());

        TextView numberTextView = (TextView) listItemView.findViewById(R.id.request_lot);
        numberTextView.setText(String.valueOf(currentDesert.getLot()));
        return listItemView;
    }
}