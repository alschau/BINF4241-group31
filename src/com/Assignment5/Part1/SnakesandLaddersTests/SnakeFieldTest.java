package com.Assignment5.Part1.SnakesandLaddersTests;

import com.Assignment5.Part1.SnakeField;
import com.Assignment5.Part1.Field;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SnakeFieldTest {

    int inputnumber = 5;
    Field snakefieldtest = new SnakeField(inputnumber);
    int result;
    String result_str;
    Boolean result_bool;

    /**
     * All getter methods should do the same:
     * Give something back or set something to something else.
     */

    @Test
    public void getTargetTest() {
        result = snakefieldtest.getTarget();
        assertEquals((inputnumber + 3), 8);
    }

    @Test
    public void getNumberTest() {
        result = snakefieldtest.getNumber();
        assertEquals(result, inputnumber);
    }

    @Test
    public void getTextNumberTest() {
        result_str = snakefieldtest.getTextNumber();
        String comparestring = "8<-5";
        assertTrue(result_str.equals(comparestring));
    }

    @Test
    public void getFreeTest() {
        result_bool = snakefieldtest.getFree();
        assertEquals(result_bool, true);
    }

    @Test
    public void getPlayerTest() {


    }



}
