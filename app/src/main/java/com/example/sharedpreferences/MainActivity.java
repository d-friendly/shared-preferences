package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        EditText name = (EditText) findViewById(R.id.editText);
        String str = name.getText().toString();

        goToActivity2(str);

    }
    public void goToActivity2(String name){
        Intent intent = new Intent(this, Notes.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

}