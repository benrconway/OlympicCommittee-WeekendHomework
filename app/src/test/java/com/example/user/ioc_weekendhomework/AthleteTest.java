package com.example.user.ioc_weekendhomework;

import com.example.user.ioc_weekendhomework.medals.Medal;
import com.example.user.ioc_weekendhomework.medals.MedalType;
import com.example.user.ioc_weekendhomework.participants.Athlete;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * Created by user on 15/09/2017.
 */

public class AthleteTest {
    Athlete athlete1;
    Medal medal;

    @Before
    public void before(){
        athlete1 = new Athlete("George", "Canada", 72, 40, 54, 80, 60);
        medal = new Medal(MedalType.GOLD);
    }

    @Test
    public void canGetName(){
        assertEquals("George", athlete1.getName());
    }

    @Test
    public void canGetCountry(){
        assertEquals("Canada", athlete1.getCountry());
    }

    @Test
    public void canGetMedals(){
        assertEquals(0, athlete1.getMedals().size());
    }

    @Test
    public void attributesAreGettable(){
        assertEquals(72, athlete1.getStrength());
        assertEquals(40, athlete1.getAgility());
        assertEquals(54, athlete1.getCoordination());
        assertEquals(80, athlete1.getConstitution());
        assertEquals(60, athlete1.getSpeed());
    }

    @Test
    public void canReceiveMedal(){
        athlete1.receive(medal);
        assertEquals(1, athlete1.getMedals().size());
        assertEquals(MedalType.GOLD, athlete1.getMedals().get(0).getMedalType());
    }

}
