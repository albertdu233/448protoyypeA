package com.example.a448protoyypea;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class RequestListActivity extends AppCompatActivity {
    private  AlertDialog.Builder builder1;
    private AlertDialog alert11;
    int selection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestlist);

        ArrayList<Request> requests = new ArrayList<Request>();

        requests.add(new Request("Somebody", 10));
        requests.add(new Request("Somebody", 11));
        requests.add(new Request("Somebody", 12));
        requests.add(new Request("Somebody", 13));

        RequestAdapter adapter = new RequestAdapter(this, requests);

        ListView listView = (ListView) findViewById(R.id.List);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Dessert dessert = desserts.get(i);
                switch(i) {
                    case 0:
                        selection = 10;
                        NewDialog();
                        alert11 = builder1.create();
                        alert11.show();
                        break;
                    case 1:
                        selection = 11;
                        NewDialog();
                        alert11 = builder1.create();
                        alert11.show();
                        break;
                    case 2:
                        selection = 12;
                        NewDialog();
                        alert11 = builder1.create();
                        alert11.show();
                        break;
                    case 3:
                        selection = 13;
                        NewDialog();
                        alert11 = builder1.create();
                        alert11.show();
                        break;
                }
            }
        });
    }

    private void ProfileActivity( int lot) {

        Intent intent = new Intent(this, DriverProfileActivity.class);
        intent.putExtra("lot_number", String.valueOf(lot));
        startActivity(intent);
    }

    private void NewDialog(){
        builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Accept the request?");
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ProfileActivity(selection);
                    }
                });
        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
    }
}



