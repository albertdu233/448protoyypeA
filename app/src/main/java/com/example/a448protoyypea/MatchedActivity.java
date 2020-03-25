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

import java.text.SimpleDateFormat;

public class MatchedActivity extends AppCompatActivity {
    private TextView txtResponserName;
    private TextView txtPhoneNumber;
    private Button mBtContact;
    private Button mBtCancel;
    private  AlertDialog.Builder builder1;
    private  AlertDialog.Builder builder2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matched);

        txtResponserName = (TextView)findViewById(R.id.responser_name);
        txtPhoneNumber = (TextView)findViewById(R.id.responser_phone);
        mBtCancel = (Button) findViewById(R.id.cancel_request_button);
        mBtContact = (Button) findViewById(R.id.responser_contact_button);

        txtResponserName.setText("Responser Somebody");
        txtPhoneNumber.setText("888-888-8888");
        new CountDownTimer(20000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                FinishActivity();
            }
        }.start();

        builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Cancel the request?");
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        needParkActivity();
                    }
                });
        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        mBtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });

        builder2 = new AlertDialog.Builder(this);
        builder2.setMessage("Your responser is busy right now, try it again later");
        builder2.setCancelable(true);
        builder2.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        mBtContact.setOnClickListener(new View.OnClickListener() {
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
    private void needParkActivity() {

        Intent intent = new Intent(this, ParkMapActivity.class);
        startActivity(intent);
    }
}
