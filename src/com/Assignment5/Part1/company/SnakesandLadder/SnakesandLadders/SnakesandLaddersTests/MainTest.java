package com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders.SnakesandLaddersTests;

import com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders.Main;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


import com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders.Field;
import com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders.SnakeField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private  final InputStream systemIn = System.in;
    private  final PrintStream systemOut = System.out;

    private  ByteArrayInputStream testIn;
    private  ByteArrayOutputStream testOut;

    private String test_amount;
    private int compare_amount;


    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @Test
    public  void testtoofewfields() {
        compare_amount = 3;
        try {

            provideInput(Integer.toString(compare_amount));
            Main.amountoffields();

        }
        catch (NoSuchElementException e) {
            return;
        }
        fail("NoSuchElementException excepted");
    }

    @Test
    public  void testwornginputfields() {
        String compare_amount = "s";
        try {

            provideInput(compare_amount);
            Main.amountoffields();

        }
        catch (NoSuchElementException e) {
            return;
        }
        fail("NoSuchElementException excepted");
    }

    @Test
    public void NotTooFewPlayersTest() {
        compare_amount = 1;
        try {

            provideInput(Integer.toString(compare_amount));
            Main.amountofplayers();

        }
        catch (NoSuchElementException e) {
            return;
        }
        fail("NoSuchElementException excepted");
    }

    @Test
    public void NotTooManyPlayersTest() {
        compare_amount = 5;
        try {

            provideInput(Integer.toString(compare_amount));
            Main.amountofplayers();

        }
        catch (NoSuchElementException e) {
            return;
        }
        fail("NoSuchElementException excepted");
    }

}
