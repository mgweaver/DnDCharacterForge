package com.example.ddcharacterforge;


import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;
    private List<Race> races = new ArrayList<>();
    private Subraces subraces;
    private PlayerClass classes;
    private Archetypes archetypes;
    private Backgroud backgrounds;
    private List<String> inventory = new ArrayList();
    private String level;
    private int hp;
    private int strength;
    private int constitution;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public Character(){
        races.add(new Race());
        classes = new PlayerClass();
        archetypes = new Archetypes();
        backgrounds = new Backgroud();
        name = "Mitchell";
        inventory.add("Longsword");
        level = "1";
        hp = 12;
        strength = 18;
        constitution = 16;
        dexterity = 14;
        intelligence = 12;
        wisdom = 10;
        charisma = 12;
    }
}
