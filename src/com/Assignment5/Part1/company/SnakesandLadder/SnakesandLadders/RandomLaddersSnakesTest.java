package com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static org.junit.Assert.*;
import java.io.*;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomLaddersSnakesTest {

    /*private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

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

*/
    ArrayList<Player> player = new ArrayList<>();
    ArrayList<Field> fields= new ArrayList<>();
    Field starter_field = new NormalField(1);


    @Test
    public void testMain() {

        fields.add(starter_field);
        Player aline = new Player("Aline", 1, starter_field);
        player.add(aline);
        Player jan = new Player("Jan", 2, starter_field);
        player.add(jan);
        Player aljoscha = new Player("Aljoscha", 1, starter_field);
        player.add(aljoscha);






    }

}