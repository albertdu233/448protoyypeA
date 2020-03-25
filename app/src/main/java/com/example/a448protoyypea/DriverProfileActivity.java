package com.example.a448protoyypea;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DriverProfileActivity extends AppCompatActivity {
    private TextView txtDriverName;
    private TextView txtPhoneNumber;
    private TextView lotNumber;
    private Button mBtCanceltrip;
    private Button mBtContactDriver;
    private  AlertDialog.Builder builder1;
    private  AlertDialog.Builder builder2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_profile);

        txtDriverName = (TextView)findViewById(R.id.driver_name);
        txtPhoneNumber = (TextView)findViewById(R.id.driver_phone);
        lotNumber = (TextView)findViewById(R.id.want_lot);
        mBtContactDriver = (Button) findViewById(R.id.contact_driver_button);
        mBtCanceltrip = (Button) findViewById(R.id.cancel_trip_button);
        String lotnumber = getIntent().getStringExtra("lot_number");

        lotNumber.setText("Want to park at:"+ lotnumber);
        txtDriverName.setText("Somebody");
        txtPhoneNumber.setText("888-888-8888");

        new CountDownTimer(20000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                FinishActivity();
            }
        }.start();

        builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Cancel the trip?");
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        RequestListActivity();
                    }
                });
        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        mBtCanceltrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });

        builder2 = new AlertDialog.Builder(this);
        builder2.setMessage("Your driver is busy right now, try it again later");
        builder2.setCancelable(true);
        builder2.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        mBtContactDriver .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alert12 = builder2.create();
                alert12.show();
            }
        });
    }

    private void FinishActivity() {

        Intent intent = new Intent(this, RequestFinishActivity.class);
        startActivity(intent);
    }
    private void RequestListActivity() {

        Intent intent = new Intent(this, RequestListActivity.class);
        startActivity(intent);
    }
}
