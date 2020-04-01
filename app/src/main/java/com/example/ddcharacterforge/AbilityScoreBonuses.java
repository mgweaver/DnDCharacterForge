package com.example.ddcharacterforge;

import java.io.Serializable;

public class AbilityScoreBonuses implements Serializable {
    private String Strength;
    private String Dexterity;
    private String Constitution;
    private String Intelligence;
    private String Wisdom;
    private String Charisma;

    public AbilityScoreBonuses(){
        Strength = "1";
        Dexterity = "1";
        Constitution = "1";
        Intelligence = "1";
        Wisdom = "1";
        Charisma = "1";
    }
}
