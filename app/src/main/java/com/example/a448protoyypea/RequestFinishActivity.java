package com.example.a448protoyypea;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RequestFinishActivity extends AppCompatActivity {
    private TextView txtResponserName;
    private TextView txtDriverName;
    private Button mBtok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_finish);
        txtDriverName = (TextView) findViewById(R.id.name_driver);
        txtResponserName = (TextView) findViewById(R.id.name_responser);
        mBtok = (Button) findViewById(R.id.button_ok);

        txtDriverName.setText("Some driver");
        txtDriverName.setText("Some responser");
        mBtok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Restart();
            }
        });

    }
    private void Restart() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
