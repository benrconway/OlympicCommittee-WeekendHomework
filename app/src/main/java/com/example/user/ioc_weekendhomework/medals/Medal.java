package com.example.user.ioc_weekendhomework.medals;

/**
 * Created by user on 15/09/2017.
 */

public class Medal {
    private Enum<MedalType> medalType;

    public Medal(MedalType medalType){
        this.medalType = medalType;
    }

    public Enum<MedalType> getMedalType() {
        return medalType;
    }
}
