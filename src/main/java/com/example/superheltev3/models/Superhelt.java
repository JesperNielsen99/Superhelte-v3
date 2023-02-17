package com.example.superheltev3.models;

import java.time.LocalDateTime;


public class Superhelt {

    private String heroName;
    private String privateName;


    public Superhelt() {}

    public Superhelt(String heroName) {
        this.heroName = heroName;
    }

    public Superhelt(String heroName, String privateName) {
        this.heroName = heroName;
        this.privateName = privateName;
    }

    //Get methods
    public String getHeroName() { return heroName; }
    public String getPrivateName() { return privateName; }

    //Set methods
    public void setHeroName(String heroName) {
        if (!heroName.isEmpty()) {
            this.heroName = heroName;
        } else {
            this.heroName = "";
        }
    }

    public void setPrivateName(String privateName) { this.privateName = privateName;}
}
