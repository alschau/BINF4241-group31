package com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NormalFieldTest {

    int inputnumber = 5;
    int result;

    String result_str;
    Boolean result_bool;
    NormalField NormalFieldTest = new NormalField(inputnumber);


    @Test
    public void getNumberTest() {
        result = NormalFieldTest.getNumber();
        assertTrue(result == inputnumber);
    }

    @Test
    public void getTextNumberTest() {
        result_str = NormalFieldTest.getTextNumber();
        assertTrue(result_str.equals (inputnumber+""));
    }

    @Test
    public void getFreeTest() {

    }

    @Test
    public void getTargetTest() {

    }
}
