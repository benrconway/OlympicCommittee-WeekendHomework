package com.example.user.ioc_weekendhomework.participants;

import com.example.user.ioc_weekendhomework.medals.Medal;

import java.util.*;

/**
 * Created by user on 15/09/2017.
 */

public class Athlete implements Competitors{
    private String name;
    private String country;
    private ArrayList<Medal> medals;
    private int strength;
    private int agility;
    private int coordination;
    private int constituion;

    public Athlete(String name, String country,
                   int strength, int agility, int coordination, int constituion){
        this.name = name;
        this.country = country;
        this.medals = new ArrayList<>();
        this.agility = agility;
        this.strength = strength;
        this.coordination = coordination;
        this.constituion = constituion;

//        Random random = new Random();
//        this.strength = random.nextInt(100);
//        this.agility = random.nextInt(100);
//        this.coordination = random.nextInt(100);
//        this.constituion = random.nextInt(100);

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

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getCoordination() {
        return coordination;
    }

    public int getConstituion() {
        return constituion;
    }

    public void receive(Medal medal) {
        medals.add(medal);
    }
}
