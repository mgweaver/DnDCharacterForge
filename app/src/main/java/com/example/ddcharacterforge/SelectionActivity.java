package com.example.ddcharacterforge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
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

public class SelectionActivity extends AppCompatActivity {
    Character test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);


        Button selectChar = findViewById(R.id.sampleCharacter);
        selectChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadJSON();
            }
        });;
    }

    private void loadJSON() {
        InputStream is = getResources().openRawResource(R.raw.testcharacter);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String jsonString = writer.toString();
        TextView result = findViewById(R.id.textView7);
        result.setText(jsonString);

        Character test2 = new Character();

        Gson gson = new Gson();
        String characterJSON = gson.toJson(test2);
        result.setText(characterJSON);

        try {
            FileOutputStream fileout = openFileOutput("test_JSON", MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
            outputWriter.write(characterJSON);
            outputWriter.close();

            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void creationButton(View view) {
        Intent intent = new Intent(this, CreationActivity.class);
        startActivity(intent);
    }
}