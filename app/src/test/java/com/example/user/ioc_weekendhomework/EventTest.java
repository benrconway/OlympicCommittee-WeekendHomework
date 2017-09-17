package com.example.user.ioc_weekendhomework;

import com.example.user.ioc_weekendhomework.competitions.Event;
import com.example.user.ioc_weekendhomework.competitions.LongDistanceRunJudge;
import com.example.user.ioc_weekendhomework.competitions.Referee;
import com.example.user.ioc_weekendhomework.competitions.StrengthJudge;
import com.example.user.ioc_weekendhomework.medals.Medal;
import com.example.user.ioc_weekendhomework.medals.MedalType;
import com.example.user.ioc_weekendhomework.participants.Athlete;
import com.example.user.ioc_weekendhomework.participants.Competitors;
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
    Referee trackJudge;

    @Before
    public void before(){
        athlete1 = new Athlete("Johnny", "USA", 60, 65, 80, 70,70);
        athlete2 = new Athlete("Paula", "Australia", 70, 65, 75, 90, 80);
        athlete3 = new Athlete("George", "Australia", 80, 70, 78, 65, 70);
        athlete4 = new Athlete("Georgina", "USSR", 90, 60, 50, 90, 60);
        team1 = new Team("Australia");
        team2 = new Team("USA");
        trackJudge = new StrengthJudge();
        event = new Event("Track & Field", trackJudge, 3);
    }

    @Test
    public void canGetEventName() {
        assertEquals("Track & Field", event.getName());
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
    public void canAwardSilver(){
        event.giveMedal(MedalType.SILVER, athlete1);
        assertEquals(2, event.getMedals().size());
        assertEquals(MedalType.GOLD, event.getMedals().get(0).getMedalType());
        assertEquals(MedalType.BRONZE, event.getMedals().get(1).getMedalType());
    }

    @Test
    public void canAwardGold(){
        event.giveMedal(MedalType.GOLD, athlete1);
        assertEquals(2, event.getMedals().size());
        assertEquals(MedalType.SILVER, event.getMedals().get(0).getMedalType());
        assertEquals(MedalType.BRONZE, event.getMedals().get(1).getMedalType());
    }

    @Test
    public void canAwardBronze(){
        event.giveMedal(MedalType.BRONZE, athlete1);
        assertEquals(2, event.getMedals().size());
        assertEquals(MedalType.GOLD, event.getMedals().get(0).getMedalType());
        assertEquals(MedalType.SILVER, event.getMedals().get(1).getMedalType());
    }

    @Test
    public void eventCanTakeInAJudgeToScoreAthletes(){
        assertEquals(trackJudge, event.getReferee());
    }

    @Test
    public void canTakeInCompetitorsIndividually(){
        event.addIndividual(athlete1);
        assertEquals(1, event.getCompetitors().size());
    }

    @Test
    public void canTakeInTeamsOfAthletes(){
        team1.add(athlete2);
        team1.add(athlete3);
        event.addTeamMembersIndividually(team1);
        assertEquals(2, event.getCompetitors().size());
    }

    @Test
    public void canLimitPlayerEntrants(){
        team1.add(athlete2);
        team1.add(athlete3);
        event.addTeamMembersIndividually(team1);
        event.addIndividual(athlete1);
        event.addIndividual(athlete4);
        assertEquals(3, event.getCompetitors().size());
    }

    @Test
    public void allowTeamsToCompeteAgainstOneAnother(){
        team1.add(athlete2);
        team1.add(athlete3);
        team2.add(athlete1);
        event.addGroup(team1);
        event.addGroup(team2);
        assertEquals(2, event.getCompetitors().size());
    }


    @Test
    public void canRunCompetitionCompeteIndividualEvent(){
        

    }
}
