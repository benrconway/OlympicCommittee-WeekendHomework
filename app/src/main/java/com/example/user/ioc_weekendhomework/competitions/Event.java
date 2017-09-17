package com.example.user.ioc_weekendhomework.competitions;

import com.example.user.ioc_weekendhomework.medals.Medal;
import com.example.user.ioc_weekendhomework.medals.MedalType;
import com.example.user.ioc_weekendhomework.participants.Athlete;
import com.example.user.ioc_weekendhomework.participants.Competitors;
import com.example.user.ioc_weekendhomework.participants.Team;

import java.util.ArrayList;

/**
 * Created by user on 15/09/2017.
 */

public class Event {
    private ArrayList<Competitors> competitors;
    private ArrayList<Medal> medals;
    private String name;
    private Referee referee;
    private int athleteCapacity;

    public Event(String name, Referee referee, int athleteCapacity){
        this.name = name;
        this.referee = referee;
        this.competitors = new ArrayList<>();
        this.medals = new ArrayList<>();
        this.setUpMedals();
        this.athleteCapacity = athleteCapacity;
    }

    public ArrayList<Competitors> getCompetitors() {
        return competitors;
    }

    public String getName() {
        return name;
    }

    public Referee getReferee() {
        return referee;
    }

    public ArrayList<Medal> getMedals() {
        return medals;
    }

    public void setUpMedals(){
        Medal gold = new Medal(MedalType.GOLD);
        Medal silver = new Medal(MedalType.SILVER);
        Medal bronze = new Medal(MedalType.BRONZE);
        this.medals.add(gold);
        this.medals.add(silver);
        this.medals.add(bronze);
    }

    public Medal getMedalByType(MedalType type){
        Medal newMedal = null;
        for (Medal medal: medals){
            if(medal.getMedalType() == type){
                newMedal = medal;
            }
        }

        return newMedal;
    }

    public void giveMedal(MedalType medal, Athlete competitor){
        Medal medalToGive = getMedalByType(medal);
        removeMedalByType(medal);
        competitor.receive(medalToGive);
    }

    private void removeMedalByType(MedalType type) {
        for (Medal medal: medals){
            if(medal.getMedalType() == type){
                medals.remove(medal);
            }
        }
    }


    public void addIndividual(Competitors athlete) {
        if(!atMaximumEntrants()) {
            competitors.add(athlete);
        }
    }

    public void addTeam(Team team) {
        for (Competitors athlete: team.getMembers()) {
            if (!atMaximumEntrants()) {
                this.competitors.add(athlete);
            }
        }
    }

    private boolean atMaximumEntrants(){
        if (competitors.size() >= athleteCapacity ){
            return true;
        }
        return false;
    }
}
