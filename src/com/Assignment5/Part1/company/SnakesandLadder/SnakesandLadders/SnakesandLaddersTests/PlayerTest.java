package com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders.SnakesandLaddersTests;

import com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders.Field;
import com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders.LadderField;
import com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders.NormalField;
import com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



class PlayerTest {
    int test_number1 = 5;
    int test_number2 = 7;
    int test_reihenfolge = 1;
    int compare_reihenfolge = 6;
    String test_name = "Jan";
    String compare_name = "Aline";
    Field LadderFieldtest = new LadderField(test_number1);
    Field compareField = new NormalField(test_number2);
    Player playerTest = new Player(test_name, test_reihenfolge, LadderFieldtest);

    @Test
    public void getFieldTest() {
        compareField = playerTest.getField();
        assertTrue(compareField == LadderFieldtest);
    }

    @Test
    public void getNameTest() {
        String compareString = playerTest.getName();
        assertTrue(compareString == test_name);
    }

    @Test
    public void setFieldTest() {
        Field test_field = new NormalField(test_number2);
        playerTest.setField(test_field);
        compareField = playerTest.getField();
        assertTrue(compareField == test_field);

    }

    @Test
    public void setNameTest() {
        playerTest.setName(compare_name);
        test_name = playerTest.getName();
        assertTrue(test_name.equals(compare_name));

    }

    @Test
    public void getReihenfolgeTest() {
        compare_reihenfolge = playerTest.getReihenfolge();
        assertTrue(compare_reihenfolge == test_reihenfolge);
    }

    @Test
    public void setReihenfolgeTest() {
        playerTest.setReihenfolge(compare_reihenfolge);
        test_reihenfolge = playerTest.getReihenfolge();
        assertTrue(compare_reihenfolge == test_reihenfolge);
    }

}
