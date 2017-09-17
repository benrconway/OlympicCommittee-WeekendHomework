package com.example.user.ioc_weekendhomework;

import com.example.user.ioc_weekendhomework.competitions.Event;
import com.example.user.ioc_weekendhomework.medals.Medal;
import com.example.user.ioc_weekendhomework.medals.MedalType;
import com.example.user.ioc_weekendhomework.participants.Athlete;
import com.example.user.ioc_weekendhomework.participants.Team;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 15/09/2017.
 */

public class EventTest {
    Event event;
    Athlete athlete1;
    Athlete athlete2;
    Athlete athlete3;
    Athlete athlete4;
    Team team1;
    Team team2;

    @Before
    public void before(){
        athlete1 = new Athlete("Johnny", "USA");
        athlete2 = new Athlete("Paula", "Australia");
        athlete3 = new Athlete("George", "Australia");
        athlete4 = new Athlete("Georgina", "USSR");
        team1 = new Team("Australia");
        team2 = new Team("USA");
        event = new Event("Beer Drinking");
    }

    @Test
    public void canGetEventName() {
        assertEquals("Beer Drinking", event.getName());
    }

    @Test
    public void canGetMedals() {
        assertEquals(3, event.getMedals().size());
    }

    @Test
    public void getMedalByType() {
        Medal newMedal = event.getMedalByType(MedalType.GOLD);
        assertEquals(MedalType.GOLD, newMedal.getMedalType());
    }

    @Test
    public void canGiveMedalToAthlete(){
        event.giveMedal(MedalType.GOLD, athlete1);
        assertEquals(1, athlete1.getMedals().size());
        assertEquals(MedalType.GOLD, athlete1.getMedals().get(0).getMedalType());
    }

    @Test
    public void givingAMedalRemovesItFromTheEvent(){
        event.giveMedal(MedalType.SILVER, athlete1);
        assertEquals(2, event.getMedals().size());
        assertEquals(MedalType.GOLD, event.getMedals().get(0).getMedalType());
        assertEquals(MedalType.BRONZE, event.getMedals().get(1).getMedalType());
    }

    @Test
    public void eventCanTakeInAJudgeToScoreAthletes(){

    }


}
