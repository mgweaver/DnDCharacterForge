package com.example.ddcharacterforge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backgroud implements Serializable {
    private String backgroundname;
    private String backgroundfeature;
    private List<String> languages = new ArrayList<>();
    private List<String> toolproficiences = new ArrayList<>();
    private List<SetSkillProficiency> setskillproficiency = new ArrayList<>();
    private String equipment;

    public Backgroud(){
        backgroundfeature = "You have a military rank from your career as a soldier. Soldiers loyal " +
                "to your former military organization still recognize your authority and influence," +
                " and they defer to you if they are of a lower rank. You can invoke your rank to " +
                "exert influence over other soldiers and requisition simple equipment or horses for " +
                "temporary use. You can aIso usually gain access to friendly military encampments " +
                "and fortresses where your rank is recognized.";
        backgroundname = "Soldier";
        setskillproficiency.add(new SetSkillProficiency(1));
        toolproficiences.addAll(Arrays.asList("One type of gaming set.", "Vehicles (land)."));
        equipment = "An insignia of rank, a trophy taken from a fallen enemy (a dagger, broken " +
                "blade, or piece of a banner), a set of bone dice or deck of cards, a set of common " +
                "clothes, and a beIt pouch containing 10 gp";
    }
}
