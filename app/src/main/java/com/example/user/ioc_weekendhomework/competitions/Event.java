package com.example.user.ioc_weekendhomework.competitions;

import com.example.user.ioc_weekendhomework.medals.Medal;
import com.example.user.ioc_weekendhomework.medals.MedalType;
import com.example.user.ioc_weekendhomework.participants.Athlete;
import com.example.user.ioc_weekendhomework.participants.Competitors;

import java.util.ArrayList;

/**
 * Created by user on 15/09/2017.
 */

public class Event {
    private ArrayList<Competitors> competitors;
    private ArrayList<Medal> medals;
    private String name;
    private Referee referee;

    public Event(String name, Referee referee){
        this.name = name;
        this.referee = referee;
        this.competitors = new ArrayList<>();
        this.medals = new ArrayList<>();
        this.setUpMedals();
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


}
