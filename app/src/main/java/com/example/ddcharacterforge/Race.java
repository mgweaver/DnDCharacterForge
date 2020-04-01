package com.example.ddcharacterforge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Race implements Serializable {
    private String name;
    private String displayname;
    private List<AbilityScoreBonuses> abilityscorebonuses = new ArrayList<>();
    private String speed;
    private List<String> languages = new ArrayList<>();
    private List<Features> features = new ArrayList<>();

    public Race(){
//        name = "Human";
//        displayname = "Human";
//        abilityscorebonuses.add(new AbilityScoreBonuses());
//        speed = "30";
//        languages.add("Common");
//        languages.add("One Extra Language");
//        features.add(new Features());
    }
}
