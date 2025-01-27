package com.example.ddcharacterforge;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Character {
    // in Creation/Selection activities, use 'Character.myCharacters' to reference
    public static List<Character> myCharacters = new ArrayList<>();

    private String name;
    public Race races;
    public Subraces subraces;
    public PlayerClass classes;
    public Archetypes archetypes;
    public Backgroud backgrounds;
    private List<String> inventory = new ArrayList();
    private String level;
    private String hp;
    private String strength;
    private String constitution;
    private String dexterity;
    private String intelligence;
    private String wisdom;
    private String charisma;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

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
//        races.add(new Race());
//        classes = new PlayerClass();
//        archetypes = new Archetypes();
//        backgrounds = new Background();
//        name = "Mitchell";
//        inventory.add("Longsword");
//        level = "1";
//        hp = "12";
//        strength = "18";
//        constitution = "16";
//        dexterity = "14";
//        intelligence = "12";
//        wisdom = "10";
//        charisma = "12";
    }
}
