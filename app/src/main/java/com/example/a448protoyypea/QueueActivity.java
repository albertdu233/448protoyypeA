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
import java.util.Date;

public class QueueActivity extends AppCompatActivity {
    private  TextView waitTime;
    private Button mBtcancel;
    private  AlertDialog.Builder builder1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);

        mBtcancel = (Button) findViewById(R.id.cancelButton);
        waitTime = (TextView)findViewById(R.id.estimatedTime);

        new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {
                waitTime.setText("Estimated Waiting Time" + new SimpleDateFormat("00:mm:ss").format(millisUntilFinished));
            }

            public void onFinish() {
                MatchedActivity();
            }
        }.start();

        builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Cancel the request?");
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        mBtcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });
    }

    private void MatchedActivity() {

        Intent intent = new Intent(this, MatchedActivity.class);
        startActivity(intent);
    }


}
