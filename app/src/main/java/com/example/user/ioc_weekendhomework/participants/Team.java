package com.example.user.ioc_weekendhomework.participants;

import com.example.user.ioc_weekendhomework.medals.Medal;

import java.util.ArrayList;

/**
 * Created by user on 15/09/2017.
 */

public class Team implements Competitors{
    private String name;
    private String country;
    private ArrayList<Competitors> members;
    private ArrayList<Medal> medals;


    public Team(String country){
        this.country = country;
        this.name = "Team " + country;
        this.members = new ArrayList<>();
        this.medals = new ArrayList<>();
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

    public int getStrength(){
        int strengthTotal = 0;
        for(Competitors competitor: members){
            strengthTotal += competitor.getStrength();
        }
        return strengthTotal / members.size();
    }

    public int getAgility(){
        int agilityTotal = 0;
        for(Competitors competitor: members){
            agilityTotal += competitor.getAgility();
        }
        return agilityTotal / members.size();
    }

    public int getCoordination(){
        int coordinationTotal = 0;
        for(Competitors competitor: members){
            coordinationTotal += competitor.getCoordination();
        }
        return coordinationTotal / members.size();
    }

    public int getConstitution(){
        int constitutionTotal = 0;
        for(Competitors competitor: members){
            constitutionTotal += competitor.getConstitution();
        }
        return constitutionTotal / members.size();
    }

    public int getSpeed(){
        int speedTotal = 0;
        for(Competitors competitor: members){
            speedTotal += competitor.getSpeed();
        }
        return speedTotal / members.size();
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

    public void receive(Medal medal) {
        medals.add(medal);
    }







}


