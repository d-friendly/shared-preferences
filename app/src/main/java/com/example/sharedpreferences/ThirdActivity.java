package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ThirdActivity extends AppCompatActivity {


    int noteid = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //get EditText View
        EditText editText = (EditText) findViewById(R.id.editText3);
        //Get Intent
        Intent intent = getIntent();
        //Get value of noteid from inent

        if (intent.hasExtra("noteid")) {
            noteid = intent.getExtras().getInt("noteid");
        }
        //intialitze class variable noteid'


        if(noteid != -1) {

            //issue might be HERE
            Note note = Notes.notes.get(noteid);
            String noteContent = note.getContent();
            //use editText.setText() to to display contents of notes
            editText.setText(noteContent);
        }
    }

    public void onButtonClicked(View view){
        //get EditText View
        EditText editText = (EditText) findViewById(R.id.editText3);
        //nitialize SQLite database connection
        Context context = getApplicationContext();
        SQLiteDatabase sqLiteDatabase = context.openOrCreateDatabase("notes", Context.MODE_PRIVATE,null);
        //intiiilize dbhelper
        DBHelper dbHelper = new DBHelper(sqLiteDatabase);
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);

        String username = sharedPreferences.getString("username","");

        String title;
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy HH:mm:ss");
        String date = dateFormat.format(new Date());

        String content = editText.getText().toString();

        if(noteid == -1) {
            title = "NOTE_" + (Notes.notes.size() + 1);
        }else {
            title = "NOTE_" + (noteid + 1);
        }
        dbHelper.saveNotes(username,title,content,date);
        Intent intent = new Intent(getApplicationContext(), Notes.class);
        startActivity(intent);
    }

}
