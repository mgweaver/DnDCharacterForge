package com.example.ddcharacterforge;

import java.util.ArrayList;
import java.util.List;

public class Subraces {
    private String name;
    private String displayname;
    private String baserace;
    private List<Features> features = new ArrayList<>();
    private List<AbilityScoreBonuses> abilityscorebonuses = new ArrayList<>();

    public Subraces(){
        name = "forest gnome";
        displayname = "forest gnome";
        baserace = "gnome";
    }
}
