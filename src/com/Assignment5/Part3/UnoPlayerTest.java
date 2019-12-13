package com.Assignment5.Part3;

import com.Assignment5.Part3.uno.player;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

// Test player class

public class UnoPlayerTest {
    player player1;
    String name = "test";

    @BeforeEach
    public void setup() {
        player1 = new player(name);
    }


    // Test correct player name

    @Test
    public void testPlayerName() {
        //check if playername is set correctly
        Assert.assertEquals(player1.getname(), "test");
        player newPlayer = new player("test");
        //check two players having similar names, should be okay
        Assert.assertEquals(player1.getname(), newPlayer.getname());
    }


    // Test correct player score

    @Test
    public void testScore() {
        //check if score is set to zero, when initializized
        Assert.assertEquals(player1.getscore(), 0);
        //check if increasing of score works
        player1.updateScore(10);
        Assert.assertEquals(10, player1.getscore());

    }


    // Test if amount of cards in hand is correct

    @Test
    public void testNrOFHandCards() {
        player1.createHandcards();
        Cards card1 = new NumberCard("r", 6);
        Cards card2 = new NumberCard("b", 4);
        Cards card3 = new NumberCard("g", 2);
        player1.add_to_hand(card1);
        player1.add_to_hand(card2);
        player1.add_to_hand(card3);
        Assert.assertTrue(player1.getnr() == 3);
        player1.playCard(card1);
        Assert.assertTrue(player1.getnr() == 2);
    }


    // Test if getcards method returns correct arraylist

    @Test
    public void testReturnHandCards() {
        player1.createHandcards();
        Cards card1 = new NumberCard("r", 6);
        Cards card2 = new NumberCard("b", 4);
        Cards card3 = new NumberCard("g", 2);
        ArrayList<Cards> cardsList1 = new ArrayList<Cards>();
        cardsList1.add(card1);
        cardsList1.add(card2);
        cardsList1.add(card3);

        ArrayList<Cards> cardsList2 = new ArrayList<Cards>();
        cardsList2.add(card1);
        cardsList2.add(card2);

        player1.add_to_hand(card1);
        player1.add_to_hand(card2);
        player1.add_to_hand(card3);
        Assert.assertTrue(player1.getcards instanceof ArrayList<Cards>);
        Assert.assertTrue(player1.getcards == cardsList);
        player1.playCard(card3);
        Assert.assertTrue(player1.getcards == cardsList2);
    }


    // Test player score

    @Test
    public void testPlayerScore() {
        player1.updateScore(2);
        Assert.assertEquals(2, player1.getScore);
    }
}
