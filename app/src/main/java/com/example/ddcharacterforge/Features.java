package com.example.ddcharacterforge;

import java.util.ArrayList;
import java.util.List;

public class Features {
    private List<SetSkillProficiency> setskillproficiency = new ArrayList<>();
    private List<String> featuretextwithbullet = new ArrayList<>();

    public Features(){
        featuretextwithbullet.add("Feature #1");
        featuretextwithbullet.add("Feature #2");
        setskillproficiency.add(new SetSkillProficiency());
    }
}
