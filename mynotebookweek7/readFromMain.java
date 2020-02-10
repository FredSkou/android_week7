package com.example.mynotebookweek7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class readFromMain extends AppCompatActivity {


    public void setText(View view){
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.mynotebookweek7", Context.MODE_PRIVATE);
        String myNotes = sharedPreferences.getString("notes","");
        TextView notesFromMain = findViewById(R.id.textFromMain);
        notesFromMain.setText(myNotes);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_from_main);
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.mynotebookweek7", Context.MODE_PRIVATE);
        String myNotes = sharedPreferences.getString("notes","");
        TextView notesFromMain = findViewById(R.id.textFromMain);
        notesFromMain.setText(myNotes);

    }
}
