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
    public static final String CHAR_NAME_TEXT = "com.example.ddcharactergorge.charName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        //characterListLayout = findViewById(R.id.characterList);

        // Set buttons to invisible to start
        findViewById(R.id.button4).setVisibility(View.INVISIBLE);
        findViewById(R.id.d20).setVisibility(View.INVISIBLE);
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
            findViewById(R.id.d20).setVisibility(View.VISIBLE);
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

    // Intent to CreationActivity
    public void creationButton(View view) {
        Intent intent = new Intent(this, CreationActivity.class);
        startActivity(intent);
    }

    // Intents to StatsActivity
    public void statsButtonChar1(View view){
        String charName = Character.myCharacters.get(0).getName();

        Intent intent = new Intent(this, StatsActivity.class);
        intent.putExtra(CHAR_NAME_TEXT, charName);
        startActivity(intent);
    }
    public void statsButtonChar2(View view){
        String charName = Character.myCharacters.get(1).getName();

        Intent intent = new Intent(this, StatsActivity.class);
        intent.putExtra(CHAR_NAME_TEXT, charName);
        startActivity(intent);
    }
    public void statsButtonChar3(View view){
        String charName = Character.myCharacters.get(2).getName();

        Intent intent = new Intent(this, StatsActivity.class);
        intent.putExtra(CHAR_NAME_TEXT, charName);
        startActivity(intent);
    }
    public void statsButtonChar4(View view){
        String charName = Character.myCharacters.get(3).getName();

        Intent intent = new Intent(this, StatsActivity.class);
        intent.putExtra(CHAR_NAME_TEXT, charName);
        startActivity(intent);
    }
    public void statsButtonChar5(View view){
        String charName = Character.myCharacters.get(4).getName();

        Intent intent = new Intent(this, StatsActivity.class);
        intent.putExtra(CHAR_NAME_TEXT, charName);
        startActivity(intent);
    }
}