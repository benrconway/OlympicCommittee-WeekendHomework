package com.example.user.ioc_weekendhomework.competitions;

import com.example.user.ioc_weekendhomework.participants.Athlete;
import com.example.user.ioc_weekendhomework.participants.Competitors;

import java.util.ArrayList;

/**
 * Created by user on 17/09/2017.
 */

public class StrengthJudge implements Referee {

    public StrengthJudge(){

    }

    @Override
    public void judgeEvent(ArrayList<Athlete> athletes) {
        Athlete firstPlace = null;
        Athlete secondPlace = null;
        Athlete thirdPlace = null;
        int firstScore = 0;
        int secondScore = 0;
        int thirdScore = 0;
        for(Athlete athlete: athletes){
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
        awardGold(firstPlace);
        awardSilver(secondPlace);
        awardBronze(thirdPlace);

    }
}
