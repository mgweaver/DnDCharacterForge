package com.example.ddcharacterforge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //code to read in saved JSON file
//        StringBuilder text = new StringBuilder();
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("/data/data/com.example.ddcharacterforge/files/MyCharacters_JSON"));
//            String line;
//
//            while ((line = br.readLine()) != null) {
//                text.append(line);
//                text.append('\n');
//            }
//            br.close();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        Gson gson= new Gson();
//
//        Character.myCharacters = gson.fromJson(text, Character.class);

    }

    // Intent to Creation Activity
    public void creationButton(View view){
        Intent intent = new Intent(this, CreationActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra("message", message);
        startActivity(intent);
    }

    // Intent to SelectionActivity
    public void selectButton(View view){
        Intent intent = new Intent(this, SelectionActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra("message", message);
        startActivity(intent);
    }

    // Intent to DiceActivity
    public void diceButton(View view) {
        Intent intent = new Intent(this, DiceActivity.class);
        startActivity(intent);
    }

}
