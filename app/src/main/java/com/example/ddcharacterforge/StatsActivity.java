package com.example.ddcharacterforge;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.ddcharacterforge.ui.main.SectionsPagerAdapter;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Use this variable 'charName' to loop through myCharacters to check for a match,
        // then load that character's stats and display them
        Intent intent = getIntent();
        String charName = intent.getStringExtra(SelectionActivity.CHAR_NAME_TEXT);

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
    public void diceButton(View view) {
        Intent intent = new Intent(this, DiceActivity.class);
        startActivity(intent);
    }
}