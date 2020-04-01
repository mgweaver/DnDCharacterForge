package com.example.ddcharacterforge;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    public Character testCharacter = new Character();
    private LinearLayout characterListLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        //characterListLayout = findViewById(R.id.characterList);

        findViewById(R.id.button4).setVisibility(View.INVISIBLE);
        findViewById(R.id.button5).setVisibility(View.INVISIBLE);
        findViewById(R.id.button6).setVisibility(View.INVISIBLE);
        findViewById(R.id.button7).setVisibility(View.INVISIBLE);
        findViewById(R.id.button9).setVisibility(View.INVISIBLE);

        Character.myCharacters.add(testCharacter);

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

    public void creationButton(View view) {
        Intent intent = new Intent(this, CreationActivity.class);
        startActivity(intent);
    }

    public void statsButton(View view){
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }

}