package com.Assignment5.Part1.SnakesandLaddersTests;

import com.Assignment5.Part1.Dice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    public Dice diceTest = new Dice();
    int result;

    /**
     * Testing the dice method, the output should be an integer between 1 and 6.
     */
    @Test
    public void testRoll() {
        result = diceTest.roll();
        assertTrue(result < 7 && result > 0);
    }

}