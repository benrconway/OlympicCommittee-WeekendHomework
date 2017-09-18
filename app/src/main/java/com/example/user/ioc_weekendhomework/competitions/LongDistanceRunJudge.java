package com.example.user.ioc_weekendhomework.competitions;

import com.example.user.ioc_weekendhomework.participants.Competitors;

import java.util.ArrayList;

/**
 * Created by user on 15/09/2017.
 */

public class LongDistanceRunJudge implements Referee {


    @Override
    public int judgeAthletePerformance(Competitors athlete) {
        return athlete.getConstitution() + athlete.getSpeed();
    }
}
