package com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    public Dice diceTest = new Dice();
    int result;

    @Test
    public void testRoll() {
        result = diceTest.roll();
        assertTrue(result < 7 && result > 0);
    }

}