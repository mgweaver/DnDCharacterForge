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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class CreationActivity extends AppCompatActivity {
    Character newCharacter = new Character();

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
        String characterJSON = gson.toJson(newCharacter);
        test.setText(characterJSON);
    }
}
