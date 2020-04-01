package com.example.ddcharacterforge;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

public class DiceActivity extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        ImageButton d20 = findViewById(R.id.imageButton);
        ImageButton d12 = findViewById(R.id.imageButton2);
        ImageButton d10 = findViewById(R.id.imageButton3);
        ImageButton d8 = findViewById(R.id.imageButton4);
        ImageButton d6 = findViewById(R.id.imageButton5);
        ImageButton d4 = findViewById(R.id.imageButton6);

        result = (TextView) findViewById(R.id.displayResult);

        d20.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                rollD20();
            }
        });

        d12.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                rollD12();
            }
        });

        d10.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                rollD10();
            }
        });

        d8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                rollD8();
            }
        });

        d6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                rollD6();
            }
        });

        d4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                rollD4();
            }
        });
    }

    private void rollD20() {
        double d20result = (int) (Math.random() * 20) + 1;
        result.setText("You rolled a" + " " + Math.round(d20result));
    }
    private void rollD12() {
        double d12result = (int) (Math.random() * 12) + 1;
        result.setText("You rolled a" + " " + Math.round(d12result));
    }

    private void rollD10() {
        double d10result = (int) (Math.random() * 10) + 1;
        result.setText("You rolled a" + " " + Math.round(d10result));
    }

    private void rollD8() {
        double d8result = (int) (Math.random() * 8) + 1;
        result.setText("You rolled a" + " " + Math.round(d8result));
    }

    private void rollD6() {
        double d6result = (int) (Math.random() * 6) + 1;
        result.setText("You rolled a" + " " + Math.round(d6result));
    }

    private void rollD4() {
        double d4result = (int) (Math.random() * 4) + 1;
        result.setText("You rolled a" + " " + Math.round(d4result));
    }
}
