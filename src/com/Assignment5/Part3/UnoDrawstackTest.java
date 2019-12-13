package com.Assignment5.Part3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.*;

import java.util.ArrayList;

// Testing the Drawstack

public class UnoDrawstackTest {
    Drawstack Drawstack1 = new Drawstack();

    @Before
    public void setup(){
        drawstack = new Drawstack();
    }


    // Test if size of Drawstack is nrofcards

    @Test
    public void nrofcards(){
        ArrayList<card> drawstack = new ArrayList<>() {{
            add(new card("b",5));
            add(new card("b",9));
            add(new card("g",8));
            add(new card("r",7));
        }};

        Drawstack1.addcards(drawstack);

        Assert.assertEquals(drawstack.size(), Drawstack1.getsize());
    }
    // Test if empty returns true if Drawstack is empty

    @Test
    public void empty(){
        Assert.assertTrue(Drawstack1.empty());

        ArrayList<card> drawPileToAdd = new ArrayList<>() {{
            add(new card("b",5));
            add(new card("b",9));
        }};

        Drawstack1.addcards(drawPileToAdd);
        Assert.assertFalse(Drawstack1.empty());
    }


    // Test if we can remove/add cards from/to Drawstack

    @Test
    public void removeCardWorks(){
        ArrayList<card> newCards = new ArrayList<>() {{
            add(new card("b",5));
            add(new card("b",9));
            add(new card("g",8));
            add(new card("r",7));
        }};

        Drawstack1.addcards(newCards);
        Assert.assertEquals(4, Drawstack1.getsize());

        card card = Drawstack1.remove();

        card expected = new card("b",5);

        Assert.assertEquals(expected, card);
        Assert.assertEquals(3, Drawstack1.getsize());

    }


    // Test if shuffle method works (length stays the same)

    @Test
    public void shuffle(){
        ArrayList<card> drawstack = new ArrayList<card>() {{
            add(new card("b",5));
            add(new card("b",9));
            add(new card("g",8));
            add(new card("r",7));
        }};

        Drawstack1.addcards(drawstack);
        Drawstack1.shuffle();

        Assert.assertEquals(4, Drawstack1.getsize());

    }


    // Test if we can remove multiple cards from Drawstack

    @Test
    public void removeMultipleCards(){
        ArrayList<card> drawstack = new ArrayList<>() {{
            add(new card("b",5));
            add(new card("b",9));
            add(new card("g",8));
            add(new card("r",7));
        }};

        Drawstack1.addcards(drawstack);

        card c1 = Drawstack1.remove();
        card c2 = Drawstack1.remove();
        card c3 = Drawstack1.remove();

        card expected = new card("g",9);

        Assert.assertEquals(1, Drawstack1.getsize());
        Assert.assertEquals(expected, c3);
    }


    // Test if pile is empty after all cards are removed

    @Test
    public void isEmptyRemove(){
        ArrayList<card> drawstack = new ArrayList<card>() {{
            add(new card("b",5));
            add(new card("b",9));
            add(new card("g",8));
            add(new card("r",7));
        }};

        Drawstack1.addcards(drawstack);

        card c1 = Drawstack1.remove();
        card c2 = Drawstack1.remove();
        card c3 = Drawstack1.remove();
        card c4 = Drawstack1.remove();


        Assert.assertEquals(0, Drawstack1.getsize());
        Assert.assertTrue(Drawstack1.empty());
    }
}
