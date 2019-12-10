package com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders.SnakesandLaddersTests;

import com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders.Field;
import com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders.NormalField;
import com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NormalFieldTest {

    int test_number = 5;
    int result;
    int test_reihenfolge = 1;
    int size;
    String test_name = "Aline";
    String result_str;
    Boolean result_bool;
    Field NormalFieldTest = new NormalField(test_number);
    Player testPlayer = new Player(test_name, test_reihenfolge, NormalFieldTest);



    @Test
    public void getNumberTest() {
        result = NormalFieldTest.getNumber();
        assertEquals(result, test_number);
    }

    @Test
    public void getTextNumberTest() {
        result_str = NormalFieldTest.getTextNumber();
        assertTrue(result_str.equals (test_number+""));
    }

    @Test
    public void getFreeTest() {
        NormalFieldTest.getFree();
    }

    @Test
    public void getTargetTest() {
        result = NormalFieldTest.getTarget();
        assertEquals(result, 0, "Correct int");

    }
}
