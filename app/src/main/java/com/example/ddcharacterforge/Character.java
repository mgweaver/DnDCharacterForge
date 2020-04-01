package com.example.ddcharacterforge;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Character implements Serializable {
    public String name;
    public List<Race> races = new ArrayList<>();
    public PlayerClass classes;
    public Archetypes archetypes;
    public Backgroud backgrounds;
    public List<String> inventory = new ArrayList();
    public String level;
    public int hp;
    public int strength;
    public int constitution;
    public int dexterity;
    public int intelligence;
    public int wisdom;
    public int charisma;

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
