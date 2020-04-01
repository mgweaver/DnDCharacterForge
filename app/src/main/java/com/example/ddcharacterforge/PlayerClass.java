package com.example.ddcharacterforge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerClass implements Serializable {
    private String name;
    private String displayname;
    private String hitdie;
    private List<String> armorproficiencies = new ArrayList<>();
    private List<String> weaponfroficiences = new ArrayList<>();
    private List<String> toolproficiences = new ArrayList<>();
    private List<String> saveproficiences = new ArrayList<>();
    private List<String> classskills = new ArrayList<>();
    private String skillcount;
    private String spellprogression;
    private String spellcastingability;
    private List<ClassLevel> classlevel = new ArrayList<>();

    public PlayerClass(){
        name = "Fighter";
        displayname = "Fighter";
        hitdie = "10";
        armorproficiencies.add("All armor");
        armorproficiencies.add("shields");
        weaponfroficiences.add("Simple weapons");
        weaponfroficiences.add("Martial weapons");
        toolproficiences.add("None");
        saveproficiences.add("Strength");
        saveproficiences.add("Constitution");
        classskills.addAll(Arrays.asList("Acrobatics","Animal Handling", "Athletics", "History", "Insight", "Intimidation", "Perception", "Survival"));
        skillcount = "2";
        spellprogression = "None";
        spellcastingability = "None";
        classlevel.add(new ClassLevel());
    }
}
