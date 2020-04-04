package com.example.ddcharacterforge;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Build;
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
import java.util.Random;

public class CreationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Character newCharacter = new Character();
    String race;
    String playerclass;
    String background;
    String subrace;

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

        newCharacter = new Character();
    }

    //Builds a pop up dialog that has edit boxes to enter in your ability scores
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

        //Now we do the same for the other five ability scores
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

        //Once all of the edit and text views are created we need to add them to layout and then the
        //dialog builder
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
                //Sets each of the ability scores for the new Character based off what was entered.
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

//        TextView test = findViewById(R.id.textView27);
        EditText name = findViewById(R.id.CharacterName);

        //Sets the new character's name
        newCharacter.setName(name.getText().toString());

        Gson gson = new Gson();

        //Sets the class, race and background for the new character
        //Reads in from the corresponding json file and puts it into the newCharacter object
        newCharacter.classes = gson.fromJson(getJSON(playerclass), PlayerClass.class);
        newCharacter.races = gson.fromJson(getJSON(race), Race.class);
        newCharacter.backgrounds = gson.fromJson(getJSON(background), Backgroud.class);

        //For testing purposes
        String characterJSON = gson.toJson(newCharacter);
//        test.setText(characterJSON);

        //Adds the new character to list of characters created
        Character.myCharacters.add(newCharacter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        String stringofparent = parent.toString();
        String lasttwo = stringofparent.substring(stringofparent.length() - 2);

        //Checks to see which spinner called this function
        //This are the last two characters in each of the spinner's id's
        if("s}".equals(lasttwo)){
            playerclass = text;
        }
        if("e}".equals(lasttwo)){
            race = text;
            //When we select our race we want to check to see if there is a subrace.
            subrace();
        }
        if("d}".equals(lasttwo)){
            background = text;
        }
        //This is the spinner for subrace
        if("4}".equals(lasttwo)){
            subrace = text;
        }


    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    //This function reads in the json file and sends it back as a string
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

    //Randomly selects a name and puts in the edit box for names.
    public void randomNameButton(View view){
        EditText name = findViewById(R.id.CharacterName);
        //Creates an array out of all of the Players Handbook suggested names.
        String[] listOfNames = getResources().getStringArray(R.array.RandomNames);
        String randomName = listOfNames[new Random().nextInt(listOfNames.length)] + " " + listOfNames[new Random().nextInt(listOfNames.length)];
        name.setText(randomName);
    }

    //If the race that was selected is one that has subraces it creates a dialog box to choice from
    //Dwarf, Elf, Halfling, and Gnome are the races that have subraces from the Player's Handbook.
    public void subrace(){
        if(race.equals("dwarf") || race.equals("elf") || race.equals("halfling") || race.equals("gnome")){

            //Just like the ability score button we build a dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LinearLayout lila1= new LinearLayout(this);
            lila1.setOrientation(LinearLayout.VERTICAL);
            builder.setTitle("Choose your subrace");

            Spinner subrac = new Spinner(this);

            if(race.equals("dwarf")){
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.DnD_Subraces_dwarf, android.R.layout.simple_spinner_item);
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // Apply the adapter to the spinner
                subrac.setAdapter(adapter);
            }

            if(race.equals("elf")){
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.DnD_Subraces_Elf, android.R.layout.simple_spinner_item);
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // Apply the adapter to the spinner
                subrac.setAdapter(adapter);
            }

            if(race.equals("halfling")){
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.DnD_Subraces_halflings, android.R.layout.simple_spinner_item);
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // Apply the adapter to the spinner
                subrac.setAdapter(adapter);
            }

            if(race.equals("gnome")){
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.DnD_Subraces_gnome, android.R.layout.simple_spinner_item);
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // Apply the adapter to the spinner
                subrac.setAdapter(adapter);
            }

            subrac.setOnItemSelectedListener(this);

            lila1.addView(subrac);
            builder.setView(lila1);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Gson gson = new Gson();
                    newCharacter.subraces = gson.fromJson(getJSON(subrace), Subraces.class);
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
    }
}

