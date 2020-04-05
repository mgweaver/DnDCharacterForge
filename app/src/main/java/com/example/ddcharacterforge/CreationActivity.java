package com.example.ddcharacterforge;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.Writer;
import android.content.DialogInterface;
import android.content.Intent;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
    String subclasses;

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
        //Adds the new character to list of characters created
        Character.myCharacters.add(newCharacter);

        String characterJSON = gson.toJson(Character.myCharacters);
        try {
            FileOutputStream fileout = openFileOutput("MyCharacters_JSON.txt", MODE_PRIVATE);
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


        //Takes you to the Selection Activity
        Intent intent = new Intent(this, SelectionActivity.class);
        startActivity(intent);





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
            subclass();
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
        //This is the spinner for subclasses
        if("9}".equals(lasttwo)){
            subclasses = text;
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

    //If the class needs to select a subclass at level one a dialog box is created and displayed
    //this is all done just like the subrace function.
    public void subclass(){
        if(playerclass.equals("cleric") || playerclass.equals("sorcerer") || playerclass.equals("warlock")){
            //Just like the ability score button we build a dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LinearLayout lila1= new LinearLayout(this);
            lila1.setOrientation(LinearLayout.VERTICAL);
            builder.setTitle("Choose your class Archetype");

            Spinner subclass = new Spinner(this);
            int id = 1000089;
            subclass.setId(id);

            //Only three classes choose their subclass at level 1; Cleric, Sorcerer, and Warlock.

            if(playerclass.equals("cleric")){
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.DnD_Subclasses_cleric, android.R.layout.simple_spinner_item);
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // Apply the adapter to the spinner
                subclass.setAdapter(adapter);
            }

            if(playerclass.equals("sorcerer")){
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.DnD_Subclasses_sorcerer, android.R.layout.simple_spinner_item);
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // Apply the adapter to the spinner
                subclass.setAdapter(adapter);
            }

            if(playerclass.equals("warlock")){
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.DnD_Subclasses_warlock, android.R.layout.simple_spinner_item);
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // Apply the adapter to the spinner
                subclass.setAdapter(adapter);
            }


            subclass.setOnItemSelectedListener(this);

            lila1.addView(subclass);
            builder.setView(lila1);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Gson gson = new Gson();
                    newCharacter.archetypes = gson.fromJson(getJSON(subclasses), Archetypes.class);
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

    //This will randomly select a name, race, class, background, and ability scores.
    public void randomCharacterButton(View view){
        Gson gson = new Gson();

        String[] listOfNames = getResources().getStringArray(R.array.RandomNames);
        String randomName = listOfNames[new Random().nextInt(listOfNames.length)] + " " + listOfNames[new Random().nextInt(listOfNames.length)];
        newCharacter.setName(randomName);

        String[] listOfRaces = getResources().getStringArray(R.array.DnD_Races);
        String randomRace = listOfRaces[new Random().nextInt(listOfRaces.length)];
        newCharacter.races = gson.fromJson(getJSON(randomRace), Race.class);

        if(randomRace.equals("dwarf") || randomRace.equals("elf") || randomRace.equals("halfling") || randomRace.equals("gnome")) {
            if (randomRace.equals("dwarf")) {
                String[] listOfSubrace = getResources().getStringArray(R.array.DnD_Subraces_dwarf);
                String randomSubrace = listOfSubrace[new Random().nextInt(listOfSubrace.length)];
                newCharacter.subraces = gson.fromJson(getJSON(randomSubrace), Subraces.class);
            }
            if (randomRace.equals("elf")) {
                String[] listOfSubrace = getResources().getStringArray(R.array.DnD_Subraces_Elf);
                String randomSubrace = listOfSubrace[new Random().nextInt(listOfSubrace.length)];
                newCharacter.subraces = gson.fromJson(getJSON(randomSubrace), Subraces.class);
            }
            if (randomRace.equals("halfling")) {
                String[] listOfSubrace = getResources().getStringArray(R.array.DnD_Subraces_halflings);
                String randomSubrace = listOfSubrace[new Random().nextInt(listOfSubrace.length)];
                newCharacter.subraces = gson.fromJson(getJSON(randomSubrace), Subraces.class);
            }
            if (randomRace.equals("gnome")) {
                String[] listOfSubrace = getResources().getStringArray(R.array.DnD_Subraces_gnome);
                String randomSubrace = listOfSubrace[new Random().nextInt(listOfSubrace.length)];
                newCharacter.subraces = gson.fromJson(getJSON(randomSubrace), Subraces.class);
            }
        }

        String[] listOfClasses = getResources().getStringArray(R.array.DnD_Classes);
        String randomClass = listOfClasses[new Random().nextInt(listOfClasses.length)];
        newCharacter.classes = gson.fromJson(getJSON(randomClass), PlayerClass.class);

        if(randomClass.equals("cleric") || randomClass.equals("sorcerer") || randomClass.equals("warlock")){
            if (randomClass.equals("cleric")) {
                String[] listOfSubclasses = getResources().getStringArray(R.array.DnD_Subclasses_cleric);
                String randomSubclass = listOfSubclasses[new Random().nextInt(listOfSubclasses.length)];
                newCharacter.archetypes = gson.fromJson(getJSON(randomSubclass), Archetypes.class);
            }
            if (randomClass.equals("sorcerer")) {
                String[] listOfSubclasses = getResources().getStringArray(R.array.DnD_Subclasses_sorcerer);
                String randomSubclass = listOfSubclasses[new Random().nextInt(listOfSubclasses.length)];
                newCharacter.archetypes = gson.fromJson(getJSON(randomSubclass), Archetypes.class);
            }
            if (randomClass.equals("warlock")) {
                String[] listOfSubclasses = getResources().getStringArray(R.array.DnD_Subclasses_warlock);
                String randomSubclass = listOfSubclasses[new Random().nextInt(listOfSubclasses.length)];
                newCharacter.archetypes = gson.fromJson(getJSON(randomSubclass), Archetypes.class);
            }
        }

        String[] listOfBackgrounds = getResources().getStringArray(R.array.DnD_backgrounds);
        String randomBackground = listOfBackgrounds[new Random().nextInt(listOfBackgrounds.length)];
        newCharacter.classes = gson.fromJson(getJSON(randomBackground), PlayerClass.class);

        Character.myCharacters.add(newCharacter);

        Intent intent = new Intent(this, SelectionActivity.class);
        startActivity(intent);
    }
}

