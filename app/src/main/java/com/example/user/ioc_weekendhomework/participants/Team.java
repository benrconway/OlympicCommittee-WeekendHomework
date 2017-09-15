package com.example.user.ioc_weekendhomework.participants;

import java.util.ArrayList;

/**
 * Created by user on 15/09/2017.
 */

public class Team implements Competitors{
    private String name;
    private String country;
    private ArrayList<Competitors> members;

    public Team(String country){
        this.country = country;
        this.name = "Team " + country;
        this.members = new ArrayList<>();
    }



    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public String getName() {
        return name;
    }

    public ArrayList<Competitors> getMembers() {
        return members;
    }

    public void add(Competitors competitor) {
        if (competitorCanJoin(competitor)) {
            members.add(competitor);
        }
    }

    private boolean competitorCanJoin(Competitors competitor) {
        boolean canJoin = false;
        if (competitor.getCountry().equals(this.country)){
            canJoin = true;
        }
        return canJoin;
    }

    public Competitors memberByIndex(int index) {
        return members.get(index);
    }
}
