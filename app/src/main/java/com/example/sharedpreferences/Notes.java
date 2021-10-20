package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class Notes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        TextView tv= (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tv.setText("Welcome " + name + "!");

    }

}

