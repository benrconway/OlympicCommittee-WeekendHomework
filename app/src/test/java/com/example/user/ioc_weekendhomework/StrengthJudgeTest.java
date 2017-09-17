package com.example.user.ioc_weekendhomework;

import com.example.user.ioc_weekendhomework.competitions.Event;
import com.example.user.ioc_weekendhomework.competitions.Referee;
import com.example.user.ioc_weekendhomework.competitions.StrengthJudge;
import com.example.user.ioc_weekendhomework.participants.Athlete;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 17/09/2017.
 */

public class StrengthJudgeTest {
    @Test
    public void judgeCanReturnStrength(){
        Athlete athlete1 = new Athlete("Georgina", "USSR", 90, 60, 50, 90, 60);
        Referee judge = new StrengthJudge();
        int result = judge.judgeAthletePerformance(athlete1);
        assertEquals(90, result);
    }
}
