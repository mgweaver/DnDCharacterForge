package com.example.ddcharacterforge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SelectionActivity extends AppCompatActivity {

    // Create a sample character
    public Character testCharacter = new Character();
    private LinearLayout characterListLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        //characterListLayout = findViewById(R.id.characterList);

        // Set buttons to invisible to start
        findViewById(R.id.button4).setVisibility(View.INVISIBLE);
        findViewById(R.id.button5).setVisibility(View.INVISIBLE);
        findViewById(R.id.button6).setVisibility(View.INVISIBLE);
        findViewById(R.id.button7).setVisibility(View.INVISIBLE);
        findViewById(R.id.button9).setVisibility(View.INVISIBLE);

        // Add test character to ArrayList of character objects
        Character.myCharacters.add(testCharacter);

        // Display buttons depending on number of character objects in myCharacters
        if (Character.myCharacters.size() != 0)
        {
            findViewById(R.id.button4).setVisibility(View.VISIBLE);
        }
        if (Character.myCharacters.size() > 1)
        {
            findViewById(R.id.button5).setVisibility(View.VISIBLE);
        }
        if (Character.myCharacters.size() > 2)
        {
            findViewById(R.id.button6).setVisibility(View.VISIBLE);
        }
        if (Character.myCharacters.size() > 3)
        {
            findViewById(R.id.button7).setVisibility(View.VISIBLE);
        }
        if (Character.myCharacters.size() > 4)
        {
            findViewById(R.id.button9).setVisibility(View.VISIBLE);
        }
    }

    // Button to CreationActivity
    public void creationButton(View view) {
        Intent intent = new Intent(this, CreationActivity.class);
        startActivity(intent);
    }

    //Button to StatsActivity
    public void statsButton(View view){
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }

}