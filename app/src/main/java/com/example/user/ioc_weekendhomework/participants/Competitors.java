package com.example.user.ioc_weekendhomework.participants;

import com.example.user.ioc_weekendhomework.medals.Medal;

/**
 * Created by user on 15/09/2017.
 */

public interface Competitors {
    String getCountry();
    String getName();
    int getStrength();
    int getAgility();
    int getCoordination();
    int getConstitution();
    int getSpeed();
    void receive(Medal medal);
}
