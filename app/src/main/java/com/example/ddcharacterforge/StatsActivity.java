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

import static com.example.ddcharacterforge.R.id.textView17;

public class StatsActivity extends AppCompatActivity {

    //Character charToDisplay;
    Character testCharacter = new Character();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        String charName = intent.getStringExtra(SelectionActivity.CHAR_NAME_TEXT);

        TextView displayName = findViewById(textView17);
        EditText displayArmorClass = findViewById(R.id.editText4);
        EditText displayHP = findViewById(R.id.editText5);
        EditText displayWalkingSpeed = findViewById(R.id.editText6);
        EditText displayProficiency = findViewById(R.id.editText14);
        EditText displayInitiative = findViewById(R.id.editText7);
        EditText displayStrength = findViewById(R.id.editText8);
        EditText displayDexterity = findViewById(R.id.editText9);
        EditText displayConstitution = findViewById(R.id.editText10);
        EditText displayCharisma = findViewById(R.id.editText11);
        EditText displayIntelligence = findViewById(R.id.editText12);
        EditText displayWisdom = findViewById(R.id.editText13);

        // Get the right Character and save it to charToDisplay
        for (int i = 0; i < 4; i++) {
            if (Character.myCharacters[i] != null && charName == Character.myCharacters[i].getName()) {
                Character charToDisplay = Character.myCharacters[i];
                initStats(charToDisplay, displayName, displayStrength, displayDexterity, displayConstitution, displayCharisma, displayIntelligence,displayWisdom);
                break;
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
        String temp = charToDisplay.getName();

        displayName.setText(temp);
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