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

    public void giveMedal(MedalType medal, Competitors competitor){
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

    public void addTeamMembersIndividually(Team team) {
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

    public void addGroup(Team team) {
        team.calculateAttributes();
        competitors.add(team);
    }

    public String compete(){
        Competitors firstPlace = null;
        Competitors secondPlace = null;
        Competitors thirdPlace = null;
        int firstScore = 0;
        int secondScore = 0;
        int thirdScore = 0;
        for(Competitors competitor: competitors){
            int currentScore = referee.judgeAthletePerformance(competitor);
            if(currentScore > firstScore){
                thirdPlace = secondPlace;
                secondPlace = firstPlace;
                firstPlace = competitor;
                firstScore = currentScore;
            }else  if((currentScore < firstScore) && (currentScore > secondScore)){
                    thirdPlace = secondPlace;
                    secondPlace = competitor;
                    secondScore = currentScore;
                }else{
                    if ((currentScore < secondScore) && (currentScore > thirdScore)){
                        thirdPlace = competitor;
                        thirdScore = currentScore;
                }
            }
        }
        if(firstPlace != null ) { giveMedal(MedalType.GOLD, firstPlace); }
        if(secondPlace != null ) { giveMedal(MedalType.SILVER, secondPlace); }
        if(thirdPlace != null ) {giveMedal(MedalType.BRONZE, thirdPlace); }

        if(thirdPlace !=null){ return "After intense competition, first place and gold go to " + firstPlace.getName() +
                " of " + firstPlace.getCountry() +". Second place and silver for "
                + secondPlace.getName() + " of " + secondPlace.getCountry() + ", and coming in" +
                "third and taking away the bronze is " + thirdPlace.getName() + " of " +
                thirdPlace.getCountry()+".";} else { return "After intense competition, first place and gold go to " + firstPlace.getName() +
                    " of " + firstPlace.getCountry() +". Second place and silver for "
                    + secondPlace.getName() + " of " + secondPlace.getCountry() + ".";}
    }

}

