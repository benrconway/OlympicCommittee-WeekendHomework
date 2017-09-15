package com.example.user.ioc_weekendhomework;

import com.example.user.ioc_weekendhomework.participants.Athlete;
import com.example.user.ioc_weekendhomework.participants.Team;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 15/09/2017.
 */

public class TeamTest {
    Team team;
    Athlete athlete1;
    Athlete athlete2;

    @Before
    public void before() {
        team = new Team("Brazil");
        athlete1 = new Athlete("Bonny", "Brazil");
        athlete2 = new Athlete("Tickles", "UK");
    }

    @Test
    public void canGetCountry(){
        assertEquals("Brazil", team.getCountry());
    }

    @Test
    public void teamIsEmptyToBegin(){
        assertEquals(0, team.getMembers().size());
    }

    @Test
    public void canAddMembers(){
        team.add(athlete1);
        assertEquals(1, team.getMembers().size());
    }

    @Test
    public void athletesCannotJoinADifferentCountrysTeam(){
        team.add(athlete1);
        team.add(athlete2);
        assertEquals(1, team.getMembers().size());
    }
}