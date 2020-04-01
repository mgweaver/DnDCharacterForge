package com.example.ddcharacterforge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Archetypes implements Serializable {
    private String name;
    private String displayname;
    private String baseclass;
    private List<String> level1 = new ArrayList<>();
    private List<String> level2 = new ArrayList<>();
    private List<String> level3 = new ArrayList<>();
    private List<String> level4 = new ArrayList<>();
    private List<String> level5 = new ArrayList<>();
    private List<String> level6 = new ArrayList<>();
    private List<String> level7 = new ArrayList<>();
    private List<String> level8 = new ArrayList<>();
    private List<String> level9 = new ArrayList<>();
    private List<String> level10 = new ArrayList<>();
    private List<String> level11 = new ArrayList<>();
    private List<String> level12 = new ArrayList<>();
    private List<String> level13 = new ArrayList<>();
    private List<String> level14 = new ArrayList<>();
    private List<String> level15 = new ArrayList<>();
    private List<String> level16 = new ArrayList<>();
    private List<String> level17 = new ArrayList<>();
    private List<String> level18 = new ArrayList<>();
    private List<String> level19 = new ArrayList<>();
    private List<String> level20 = new ArrayList<>();

    public Archetypes(){
        name = "Champion";
        displayname = "Champion";
        baseclass = "Fighter";
        level3.add("Improved Critical - Your weapon attacks score a critical hit on a roll of 19 or 20.");
        level7.add("Remarkable Athlete - You can add half of your proficiency bonus (round up) to " +
                "any Strength, Dexterity, or Constitution check you make that doesn't already use " +
                "your proficiency bonus. In addition, when you make a running long jump, the " +
                "distance you can cover increases by a number of feet equal to your Strength modifier.");
        level10.add("Additional Fighting Style - Choose a second option from the Fighting Style class feature.");
        level15.add("Superior Critical - Your weapon attacks score a critical hit on a roll of 18-20.");
        level18.add("Survivor - You attain the pinnacle of resilience in battle. At the start of each " +
                "of your turns, you regain hit points equal to 5 + your Constitution modifier if you " +
                "have no more than half of your hit points left. you don't gain this benefit if you have O hit points.");
    }
}
