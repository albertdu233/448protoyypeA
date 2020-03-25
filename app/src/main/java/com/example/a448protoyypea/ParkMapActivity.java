package com.example.a448protoyypea;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ParkMapActivity extends AppCompatActivity {

    private Button mBtconfirm;
    private boolean ifSelected;
    private ImageView imageMap;
    private TextView lot;
    private  AlertDialog.Builder builder1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mBtconfirm = (Button) findViewById(R.id.confirm_park_button);
        imageMap = (ImageView) findViewById(R.id.map);
        lot = (TextView) findViewById(R.id.lotSelected);
        ifSelected = false;

        imageMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ifSelected = true;
                lot.setText("Selected lot "+(new Random().nextInt(5) + 10));
            }
        });


        builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Please select a parking lot to continue!");
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        mBtconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ifSelected)
                    QueueActivity();
                else{

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }

            }
        });


    }

    private void QueueActivity() {

        Intent intent = new Intent(this, QueueActivity.class);
        startActivity(intent);
    }
}
