package com.example.a448protoyypea;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button mBtneedpark;
private Button mBtnleave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBtneedpark = (Button) findViewById(R.id.need_park_button);

        mBtneedpark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                needParkActivity();
            }
        });

        mBtnleave= (Button) findViewById(R.id.leave_button);

        mBtnleave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestListActivity();
            }
        });
    }

    private void needParkActivity() {

        Intent intent = new Intent(this, ParkMapActivity.class);
        startActivity(intent);
    }

    private void RequestListActivity() {

        Intent intent = new Intent(this, RequestListActivity.class);
        startActivity(intent);
    }
}
