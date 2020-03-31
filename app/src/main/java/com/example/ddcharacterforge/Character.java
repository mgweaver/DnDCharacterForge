package com.example.ddcharacterforge;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Character {
    // in Creation/Selection activities, use 'Character.myCharacters' to reference
    public static List<Character> myCharacters = new ArrayList<>();
    
    private String name;
    private List<Race> races = new ArrayList<>();
    private Subraces subraces;
    private PlayerClass classes;
    private Archetypes archetypes;
    private Backgroud backgrounds;
    private List<String> inventory = new ArrayList();
    private String level;
    private String hp;
    private String strength;
    private String constitution;
    private String dexterity;
    private String intelligence;
    private String wisdom;
    private String charisma;

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getConstitution() {
        return constitution;
    }

    public void setConstitution(String constitution) {
        this.constitution = constitution;
    }

    public String getDexterity() {
        return dexterity;
    }

    public void setDexterity(String dexterity) {
        this.dexterity = dexterity;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getWisdom() {
        return wisdom;
    }

    public void setWisdom(String wisdom) {
        this.wisdom = wisdom;
    }

    public String getCharisma() {
        return charisma;
    }

    public void setCharisma(String charisma) {
        this.charisma = charisma;
    }

    public Character(){
        races.add(new Race());
        classes = new PlayerClass();
        archetypes = new Archetypes();
        backgrounds = new Backgroud();
        name = "Mitchell";
        inventory.add("Longsword");
        level = "1";
        hp = "12";
        strength = "18";
        constitution = "16";
        dexterity = "14";
        intelligence = "12";
        wisdom = "10";
        charisma = "12";
    }
}
