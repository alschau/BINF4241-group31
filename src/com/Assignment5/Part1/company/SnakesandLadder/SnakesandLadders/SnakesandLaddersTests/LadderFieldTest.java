package com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders.SnakesandLaddersTests;

import com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders.Field;
import com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders.LadderField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LadderFieldTest {

    int inputnumber = 5;
    Field ladderfieldtest = new LadderField(inputnumber);
    int result;
    String result_str;
    Boolean result_bool;

    @Test
    public void getTargetTest() {
        result = ladderfieldtest.getTarget();
        assertEquals((inputnumber + 3), 8);
    }

    @Test
    public void getNumberTest() {
        result = ladderfieldtest.getNumber();
        assertEquals(result, inputnumber);
    }

    @Test
    public void getTextNumberTest() {
        result_str = ladderfieldtest.getTextNumber();
        String comparestring = "5->8";
        assertTrue(result_str.equals(comparestring));
    }

    @Test
    public void getFreeTest() {
        result_bool = ladderfieldtest.getFree();
        assertEquals(result_bool, true);
    }


}