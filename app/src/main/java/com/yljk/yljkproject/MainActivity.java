package com.yljk.yljkproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.yljk.imdoctor.IMDoctorActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textviewBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textviewBt = findViewById(R.id.textview_bt);

        textviewBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, IMDoctorActivity.class));
            }
        });


    }


}