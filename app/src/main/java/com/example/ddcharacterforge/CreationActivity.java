package com.example.ddcharacterforge;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class CreationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Character newCharacter = new Character();
    String race;
    String playerclass;
    String background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        Spinner races = (Spinner) findViewById(R.id.Race);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.DnD_Races, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        races.setAdapter(adapter);

        Spinner playerClasses = (Spinner) findViewById(R.id.Classes);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.DnD_Classes, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        playerClasses.setAdapter(adapter2);

        Spinner backgrounds = (Spinner) findViewById(R.id.background);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.DnD_backgrounds, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        backgrounds.setAdapter(adapter3);

        races.setOnItemSelectedListener(this);
        playerClasses.setOnItemSelectedListener(this);
        backgrounds.setOnItemSelectedListener(this);
    }

    public void abilityScoreButton(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LinearLayout lila1= new LinearLayout(this);
        lila1.setOrientation(LinearLayout.VERTICAL);
        builder.setTitle("Ability Score");

// Set up the input for strength
        final EditText str = new EditText(this);
        final TextView strength = new TextView(this);
        strength.setText("Strength");
// Specify the type of input expected;
        str.setInputType(InputType.TYPE_CLASS_NUMBER);

        final EditText dex = new EditText(this);
        final TextView dexterity = new TextView(this);
        dex.setInputType(InputType.TYPE_CLASS_NUMBER);
        dexterity.setText("Dexterity");

        final EditText con = new EditText(this);
        final TextView constitution = new TextView(this);
        con.setInputType(InputType.TYPE_CLASS_NUMBER);
        constitution.setText("Constitution");

        final EditText intel = new EditText(this);
        final TextView intelligence = new TextView(this);
        intel.setInputType(InputType.TYPE_CLASS_NUMBER);
        intelligence.setText("Intelligence");

        final EditText wis = new EditText(this);
        final TextView wisdom = new TextView(this);
        wis.setInputType(InputType.TYPE_CLASS_NUMBER);
        wisdom.setText("Wisdom");

        final EditText chari = new EditText(this);
        final TextView charisma = new TextView(this);
        chari.setInputType(InputType.TYPE_CLASS_NUMBER);
        charisma.setText("Charisma");

        lila1.addView(str);
        lila1.addView(strength);

        lila1.addView(con);
        lila1.addView(constitution);

        lila1.addView(dex);
        lila1.addView(dexterity);

        lila1.addView(intel);
        lila1.addView(intelligence);

        lila1.addView(wis);
        lila1.addView(wisdom);

        lila1.addView(chari);
        lila1.addView(charisma);

        builder.setView(lila1);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                newCharacter.setStrength(str.getText().toString());
                newCharacter.setDexterity(dex.getText().toString());
                newCharacter.setConstitution(con.getText().toString());
                newCharacter.setIntelligence(intel.getText().toString());
                newCharacter.setWisdom(wis.getText().toString());
                newCharacter.setCharisma(chari.getText().toString());
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void saveButton(View view){
        TextView test = findViewById(R.id.textView13);
        EditText name = findViewById(R.id.CharacterName);
        newCharacter.setName(name.getText().toString());



        Gson gson = new Gson();

        newCharacter.classes = gson.fromJson(getJSON("fighter"), PlayerClass.class);
        newCharacter.races = gson.fromJson(getJSON("human"), Race.class);
        newCharacter.backgrounds = gson.fromJson(getJSON("acolyte"), Backgroud.class);
        String characterJSON = gson.toJson(newCharacter);
        test.setText(characterJSON);
        Character.myCharacters.add(newCharacter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        String stringofparent = parent.toString();
        String lasttwo = stringofparent.substring(stringofparent.length() - 2);
        TextView spinnertest = findViewById(R.id.textView13);
        spinnertest.setText(text);
        String races = "s}";
        if("s}" == lasttwo){
            playerclass = text;
            spinnertest.setText("playerclass");
        }
        if(lasttwo == "e}"){
            race = text;
            spinnertest.setText("races");
        }
        if(lasttwo == "d}"){
            background = text;
            spinnertest.setText("background");
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    public String getJSON(String jsonfile){
        int resid = getResources().getIdentifier(jsonfile, "raw", this.getPackageName());

        InputStream is = getResources().openRawResource(resid);
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
        return jsonString;
    }
}
