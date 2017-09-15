package com.example.user.ioc_weekendhomework.participants;

import com.example.user.ioc_weekendhomework.medals.Medal;

import java.util.*;

/**
 * Created by user on 15/09/2017.
 */

public class Athlete implements Competitors{
    String name;
    String country;
    ArrayList<Medal> medals;

    public Athlete(String name, String country){
        this.name = name;
        this.country = country;
        this.medals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public ArrayList<Medal> getMedals() {
        return medals;
    }

    public void receive(Medal medal) {
        medals.add(medal);
    }
}
