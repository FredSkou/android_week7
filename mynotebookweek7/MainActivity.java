package com.example.mynotebookweek7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List myNotesList = new ArrayList();
    boolean darkmodeIsOn = false;

    public void darkMode(View view) {
        EditText notesField = (EditText) findViewById(R.id.notesField);
        View background = (View) findViewById(R.id.background);
        Button darkModeButton = findViewById(R.id.darkModeButton);
        EditText colorField = findViewById(R.id.colorField);
        if (!darkmodeIsOn) {
            darkmodeIsOn = true;
            background.setBackgroundColor(Color.BLACK);
            notesField.setTextColor(Color.WHITE);
            darkModeButton.setBackgroundColor(Color.WHITE);
            darkModeButton.setTextColor(Color.WHITE);
            darkModeButton.setText("Light Mode");
            colorField.setTextColor(Color.WHITE);


        } else {
            darkmodeIsOn = false;
            background.setBackgroundColor(Color.WHITE);
            notesField.setTextColor(Color.BLACK);
            darkModeButton.setBackgroundColor(Color.GRAY);
            darkModeButton.setTextColor(Color.BLACK);
            darkModeButton.setText("Dark Mode");
            colorField.setTextColor(Color.BLACK);
        }
    }


    public void saveNotes(View view) {
        EditText notesField = (EditText) findViewById(R.id.notesField);
        String notesString = notesField.getText().toString();
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.mynotebookweek7", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("notes", notesString).apply();
        Toast.makeText(this,"Note has been saved!",Toast.LENGTH_LONG);


    }

    public void colorSwitchCase(View view) {
        EditText colorInput = findViewById(R.id.colorField);
        String input = colorInput.getText().toString();
        EditText notesField = (EditText) findViewById(R.id.notesField);
        View background = (View) findViewById(R.id.background);
        Button setColorButton = (Button) findViewById(R.id.setColorButton);
        Button darkModeButton = findViewById(R.id.darkModeButton);
        switch (input) {
            case "red":
                background.setBackgroundColor(Color.RED);
                notesField.setTextColor(Color.BLACK);
                colorInput.setTextColor(Color.BLACK);
                break;

            case "black":
                background.setBackgroundColor(Color.BLACK);
                notesField.setTextColor(Color.WHITE);
                darkModeButton.setBackgroundColor(Color.WHITE);
                colorInput.setTextColor(Color.WHITE);

                break;

            case "white":
                background.setBackgroundColor(Color.WHITE);
                notesField.setTextColor(Color.BLACK);
                colorInput.setTextColor(Color.BLACK);

                break;
            case "yellow":
                background.setBackgroundColor(Color.YELLOW);
                notesField.setTextColor(Color.BLACK);
                colorInput.setTextColor(Color.BLACK);
                break;
            case "blue":
                background.setBackgroundColor(Color.BLUE);
                notesField.setTextColor(Color.BLACK);
                colorInput.setTextColor(Color.BLACK);
                break;
            case "green":
                background.setBackgroundColor(Color.GREEN);
                notesField.setTextColor(Color.BLACK);
                colorInput.setTextColor(Color.BLACK);
                break;
            case "gray":
                background.setBackgroundColor(Color.GRAY);
                notesField.setTextColor(Color.BLACK);
                colorInput.setTextColor(Color.BLACK);
                break;

            default:
                Toast.makeText(this, "Color Not Available. Try again!", Toast.LENGTH_LONG).show();
                System.out.println("this is the input:"+input);


        }
    }
    public void toReadFromMain(View view){
        Button goToReadFromMainButton = findViewById(R.id.fromMainToReadButton);
        Intent goToReadFromMain = new Intent(this,readFromMain.class);
        startActivity(goToReadFromMain);
    }
    public void goToListView(View view){
        Intent goToList = new Intent(this,readFromMain.class);
        startActivity(goToList);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.mynotebookweek7", Context.MODE_PRIVATE);
        String myNotes = sharedPreferences.getString("notes", "");


        EditText noteFieldOnCreate = (EditText) findViewById(R.id.notesField);
        noteFieldOnCreate.setText(myNotes);

        Log.i("My notes ", myNotes);

    }

}

