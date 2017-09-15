package com.example.user.ioc_weekendhomework;

import com.example.user.ioc_weekendhomework.medals.Medal;
import com.example.user.ioc_weekendhomework.medals.MedalType;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 15/09/2017.
 */

public class MedalTest {
    Medal medal1;
    Medal medal2;
    Medal medal3;

    @Before
    public void before(){
        medal1 = new Medal(MedalType.BRONZE);
        medal2 = new Medal(MedalType.SILVER);
        medal3 = new Medal(MedalType.GOLD);
    }

    @Test
    public void canGetType(){
        assertEquals(MedalType.BRONZE, medal1.getMedalType());
        assertEquals(MedalType.SILVER, medal2.getMedalType());
        assertEquals(MedalType.GOLD, medal3.getMedalType());
    }
}
