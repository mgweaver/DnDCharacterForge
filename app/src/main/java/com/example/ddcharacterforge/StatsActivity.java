package com.example.ddcharacterforge;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ddcharacterforge.ui.main.SectionsPagerAdapter;

public class StatsActivity extends AppCompatActivity {

    Character charToDisplay;
    Character testCharacter = new Character();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Use this variable 'charName' to loop through myCharacters to check for a match,
        // then load that character's stats and display them
        Intent intent = getIntent();
        String charName = intent.getStringExtra(SelectionActivity.CHAR_NAME_TEXT);

        final TextView displayName = findViewById(R.id.textView17);
        final EditText displayArmorClass = findViewById(R.id.editText4);
        final EditText displayHP = findViewById(R.id.editText5);
        final EditText displayWalkingSpeed = findViewById(R.id.editText6);
        final EditText displayProficiency = findViewById(R.id.editText14);
        final EditText displayInitiative = findViewById(R.id.editText7);
        final EditText displayStrength = findViewById(R.id.editText8);
        final EditText displayDexterity = findViewById(R.id.editText9);
        final EditText displayConstitution = findViewById(R.id.editText10);
        final EditText displayCharisma = findViewById(R.id.editText11);
        final EditText displayIntelligence = findViewById(R.id.editText12);
        final EditText displayWisdom = findViewById(R.id.editText13);

        Character.myCharacters.add(testCharacter);

        // This huge block will get the right character and save it to charToDisplay
        // Ex. Use textview123.setText(charToDisplay.getName()) to display name
        if (Character.myCharacters.size() > 4) {
            for (int i = 4; i > 0; i--) {
                if (charName == Character.myCharacters.get(i).getName()) {
                    charToDisplay = Character.myCharacters.get(i);
                    //initStats(charToDisplay, displayName, displayStrength, displayDexterity, displayConstitution, displayCharisma, displayIntelligence,displayWisdom);
                }
            }
        }
        else if (Character.myCharacters.size() > 3) {
            for (int i = 3; i > 0; i--) {
                if (charName == Character.myCharacters.get(i).getName()) {
                    charToDisplay = Character.myCharacters.get(i);
                    //initStats(charToDisplay, displayName, displayStrength, displayDexterity, displayConstitution, displayCharisma, displayIntelligence,displayWisdom);
                }
            }
        }
        else if (Character.myCharacters.size() > 2) {
            for (int i = 2; i > 0; i--) {
                if (charName == Character.myCharacters.get(i).getName()) {
                    charToDisplay = Character.myCharacters.get(i);
                    //initStats(charToDisplay, displayName, displayStrength, displayDexterity, displayConstitution, displayCharisma, displayIntelligence,displayWisdom);
                }
            }
        }
        else if (Character.myCharacters.size() > 1) {
            for (int i = 1; i > 0; i--) {
                if (charName == Character.myCharacters.get(i).getName()) {
                    charToDisplay = Character.myCharacters.get(i);
                    //initStats(charToDisplay, displayName, displayStrength, displayDexterity, displayConstitution, displayCharisma, displayIntelligence,displayWisdom);
                }
            }
        }
        else if (Character.myCharacters.size() > 0) {
            if (charName == Character.myCharacters.get(0).getName()) {
                charToDisplay = Character.myCharacters.get(0);
                //initStats(charToDisplay, displayName, displayStrength, displayDexterity, displayConstitution, displayCharisma, displayIntelligence,displayWisdom);
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.getTabAt(1).select();
        FloatingActionButton fab = findViewById(R.id.fab);

    }

    public void initStats(Character charToDisplay, TextView displayName, EditText displayStrength, EditText displayDexterity, EditText displayConstitution, EditText displayCharisma, EditText displayIntelligence, EditText displayWisdom) {
        displayName.setText(charToDisplay.getName());
        // displayArmorClass.setText(charToDisplay.getArmorClass());
        // displayHP.setText(charToDisplay.getHP());
        // displayWalkingSpeed.setText(getWalkingSpeed());
        // displayProficiency.setText(charToDisplay.getProficiency());
        // displayInitiative.setText(charToDisplay.getInitiative());
        displayStrength.setText(charToDisplay.getStrength());
        displayDexterity.setText(charToDisplay.getDexterity());
        displayConstitution.setText(charToDisplay.getConstitution());
        displayCharisma.setText(charToDisplay.getCharisma());
        displayIntelligence.setText(charToDisplay.getIntelligence());
        displayWisdom.setText(charToDisplay.getWisdom());
    }

    public void diceButton(View view) {
        Intent intent = new Intent(this, DiceActivity.class);
        startActivity(intent);
    }
}