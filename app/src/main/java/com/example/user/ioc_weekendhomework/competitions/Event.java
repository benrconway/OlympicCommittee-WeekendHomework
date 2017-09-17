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
        competitor.receive(medalToGive);
        removeMedalFromEvent(medalToGive);
    }

//    private void removeMedalByType(MedalType type) {
//        for (Medal medal: medals){
//            if(medal.getMedalType() == type){
//                medals.remove(medal);
//            }
//        }
//    }

    private void removeMedalFromEvent(Medal medal) {
        medals.remove(medal);
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

    public String compete(ArrayList<Competitors> competitors){
        Athlete firstPlace = null;
        Athlete secondPlace = null;
        Athlete thirdPlace = null;
        int firstScore = 0;
        int secondScore = 0;
        int thirdScore = 0;
        for(Competitors athlete: competitors){
            int currentStrength = athlete.getStrength();
            if(currentStrength > firstScore){
                firstPlace = athlete;
                firstScore = currentStrength;
            }else  if((currentStrength < firstScore) && (currentStrength > secondScore)){
                    secondPlace = athlete;
                    secondScore = currentStrength;
                }else{
                    if ((currentStrength < secondScore) && (currentStrength > thirdScore)){
                        thirdPlace = athlete;
                        thirdScore = currentStrength;
                }
            }
        }
        giveMedal(MedalType.GOLD, firstPlace);
        giveMedal(MedalType.SILVER, secondPlace);
        giveMedal(MedalType.BRONZE, thirdPlace);

        return "After intesnse competition, first place and gold go to " + firstPlace.getName() +
                " of " + firstPlace.getCountry() +". Second place and silver for "
                + secondPlace.getName() + " of " + secondPlace.getCountry() + ", and coming in" +
                "third and taking away the bronze is " + thirdPlace.getName() + " of " +
                thirdPlace.getCountry()+".";
    }
    }
}
