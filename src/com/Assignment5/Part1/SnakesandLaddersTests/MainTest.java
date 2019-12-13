package com.Assignment5.Part1.SnakesandLaddersTests;

import com.Assignment5.Part1.Main;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is for testing our main method. Because the code isn't structured that well,
 * we couldn't test all of it but by altering the code (as discussed on wednesday) we got some testcases.
 */

class MainTest {

    private  final InputStream systemIn = System.in;
    private  final PrintStream systemOut = System.out;

    private  ByteArrayInputStream testIn;
    private  ByteArrayOutputStream testOut;

    private String test_amount;
    int compare_amount;

    /**
     * Setup for generating the user input
     */

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

    /**
     * Testing what happens if there are too few fields.
     * The test should fail bc there isn't a second (and correct) input after rejecting the first one.
     */
    @Test
    public  void TooFewFieldsTest() {
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


    /**
     * Testing what happens if the input of the fields is not an integer.
     * The test should fail bc there isn't a second (and correct) input after rejecting the first one.
     */
    @Test
    public  void WrongInputFieldsTest() {
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

    /**
     * Testing what happens if the input is correct.
     * The output should be equal to the input.
     */
    @Test
    public  void CorrectInputFieldsTest() {
        compare_amount = 13;
        provideInput(Integer.toString(compare_amount));
        int z = Main.amountoffields();
        assertEquals(z, compare_amount);
    }

    /**
     * Testing what happens if the input isn't an integer.
     * The test should fail bc there isn't a second (and correct) input after rejecting the first one.
     */
    @Test
    public void WrongInputPlayersTest() {
        String compare_amount = "";
        try {

            provideInput(compare_amount);
            Main.amountofplayers();

        }
        catch (NoSuchElementException e) {
            return;
        }
        fail("NoSuchElementException excepted");
    }

    /**
     * Testing what happens if there're too few players.
     * The test should fail bc there isn't a second (and correct) input after rejecting the first one.
     */
    @Test
    public void TooFewPlayersTest() {
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

    /**
     * Testing what happens if there're too many players.
     * The test should fail bc there isn't a second (and correct) input after rejecting the first one.
     */
    @Test
    public void TooManyPlayersTest() {
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

    /**
     * Testing what happens if the input is correct.
     * The output should be equal to the input.
     */
    @Test
    public void CorrectAmountOfPlayers() {
        compare_amount = 2;
        provideInput(Integer.toString(compare_amount));
        int z = Main.amountofplayers();
        assertEquals(z, compare_amount);
    }

}
