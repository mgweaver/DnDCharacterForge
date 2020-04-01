package com.example.ddcharacterforge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class Test extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //Intent intent = getIntent();
        //Character character = (Character)intent.getSerializableExtra ("sampleChar");

        //Character character = R.raw.testcharacter;

        TextView charName = findViewById(R.id.textView7);
        TextView charRace = findViewById(R.id.textView8);
        TextView charClass = findViewById(R.id.textView9);
        TextView charInit = findViewById(R.id.textView10);
        TextView charHP = findViewById(R.id.textView11);
        TextView charSpeed = findViewById(R.id.textView12);
        TextView charHitDice = findViewById(R.id.textView13);
        TextView charArmorClass = findViewById(R.id.textView14);
        TextView charProf = findViewById(R.id.textView15);
        TextView charInv = findViewById(R.id.textView16);

        //charName.setText(character.name);
    }

    public void diceButton(View view) {
        Intent intent = new Intent(this, DiceActivity.class);
        startActivity(intent);
    }
}
