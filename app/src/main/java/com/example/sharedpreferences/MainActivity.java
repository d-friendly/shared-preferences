package com.example.sharedpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import android.view.View;
import android.widget.EditText;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {


    private NavigationBarView menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        String usernameKey = "username";


        SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
        if(!sharedPreferences.getString(usernameKey,"").equals("")) {
            String str = sharedPreferences.getString(usernameKey,"");
            goToActivity2(str);
        }else{
            setContentView(R.layout.activity_main);
        }
    }

    public void onButtonClick(View view) {
        EditText name = (EditText) findViewById(R.id.editText);
        String str = name.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", str).apply();

        goToActivity2(str);
    }
    public void goToActivity2(String name){
        Intent intent = new Intent(this, Notes.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }




}