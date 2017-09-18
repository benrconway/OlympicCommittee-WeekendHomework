package com.example.user.ioc_weekendhomework;

import com.example.user.ioc_weekendhomework.competitions.LongDistanceRunJudge;
import com.example.user.ioc_weekendhomework.competitions.Referee;
import com.example.user.ioc_weekendhomework.participants.Athlete;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 18/09/2017.
 */
public class LongDistanceRunJudgeTest {
    @Test
    public void canMakeCalculation() {
        Referee lDRJudge = new LongDistanceRunJudge();
        Athlete athlete = new Athlete("John", "Johnville", 90, 90, 90, 90, 90);
        int expected = athlete.getConstitution() + athlete.getSpeed();
        assertEquals(expected, lDRJudge.judgeAthletePerformance(athlete));
    }
}