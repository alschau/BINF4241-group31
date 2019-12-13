package com.Assignment5.Part3;


import com.Assignment5.Part3.uno.card;
import com.Assignment5.Part3.uno.middlestack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

// Test for the middlestack

public class UnoMiddlestackTest {
    com.Assignment5.Part3.uno.middlestack middlestack = new middlestack();

    @Before
    public void setup(){
        middlestack = new middlestack();
    }


    // Test if we can add cart to the middlestack

    @Test
    public void nrofcards(){
        card c1 = new card("b");
        card c2 = new card("b");
        card c3 = new card("g");
        card c4 = new card("r");

        middlestack.addcard(c1);
        middlestack.addcard(c2);
        middlestack.addcard(c3);
        middlestack.addcard(c4);

        Assert.assertEquals(4, middlestack.getsize());
    }


    // Test empty method

    @Test
    public void empty(){
        Assert.assertTrue(middlestack.empty());
        Assert.assertEquals(0, middlestack.getsize());
        card c1 = new card("b");
        card c2 = new card("b");

        middlestack.addcard(c1);
        middlestack.addcard(c2);

        Assert.assertEquals(2, middlestack.getsize());
        Assert.assertFalse(middlestack.empty());


    }


    // Test remove method for middlestack

    @Test
    public void removeCardsWorks(){
        card c1 = new card("b");
        card c2 = new card("b");
        card c3 = new card("g");
        card c4 = new card("r");

        middlestack.addcard(c1);
        middlestack.addcard(c2);
        middlestack.addcard(c3);
        middlestack.addcard(c4);

        ArrayList<card> played = new ArrayList<>() {{
            add(c4);
        }};

        card removed = middlestack.remove();

        Assert.assertEquals(1, middlestack.getsize());

        Assert.assertEquals(played, removed);
    }


    // Test if we get the correct top card

    @Test
    public void getCards(){
        card c1 = new card("b");
        card c2 = new card("b");
        card c3 = new card("g");
        card c4 = new card("r");

        middlestack.addcard(c1);
        middlestack.addcard(c2);
        middlestack.addcard(c3);
        middlestack.addcard(c4);

        card expected = c4;

        Assert.assertEquals(expected, middlestack.gettopcard());
    }
}
