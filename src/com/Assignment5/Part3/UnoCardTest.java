package com.Assignment5.Part3;

import com.Assignment5.Part3.uno.card;
import com.Assignment5.Part3.uno.player;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

// Testing the special Cards (Wildcard Draw 4 & Color change, draw 2 and skip card)

public class UnoCardTest {
    private int nrofplayers;
    private int scoreToWin;
    private player testplayer1;
    private player testplayer2;
    private String[] playerNames;
    private game game;

    @BeforeEach
    public void setup() {
        nrofplayers = 2;
        playerNames = new String[nrofplayers];
        playerNames[0] = "test1";
        playerNames[1] = "test2";
        scoreToWin = 20;
        %parlament
        game = new game(nrofplayers, playerNames, scoreToWin);
    }

    // Wildcard Draw 4 Test

    public void testWildCardDraw4() {
        ArrayList<player> players = game.getplayer();
        player testplayer2 = players.remove(1);
        player testplayer1 =  players.remove(0);
        card wildCard = new WildCard("WildDraw4",4);
        testplayer1.addHandCard(wildCard);
        game.checklegalturn("BlackWildDraw4",testplayer1);
        testplayer1.playCard(wildCard);
        Assert.assertEqual(4,testplayer2.nrofcards);
    }

    // Wildcard color change Test

    public void testWildCardDrawColor() {
        card newCard = new card("game",5);
        ArrayList<player> players = game.getplayer();
        player testplayer2 = players.remove(1);
        player testplayer1 =  players.remove(0);

        game.add_middlestack(newCard);
        Wild wildCard = new WildCard("Wild",0);
        testplayer1.addHandCard(wildCard);
        game.checklegalturn("BlackWild",testplayer1);
        testplayer1.playCard(wildCard);
        Assert.assertFalse(game.checklegalturn("Blue6",testplayer2));
        Assert.assertTrue(game.checklegalturn("Red7",testplayer2));
    }

    // Draw Two Test

    public void testDrawTwo() {
        card newCard = new card("r",5);
        ArrayList<player> players = game.getplayer();
        player testplayer2 = players.remove(1);
        player testplayer1 =  players.remove(0);

        game.add_middlestack(newCard);
        DrawTwo drawTwo = new DrawTwo("r");
        testplayer1.addHandCard(drawTwo);
        game.checklegalturn("RedDraw2",testplayer1);
        testplayer1.playCard(drawTwo);
        Assert.assertNotEqual(0,testplayer2.nrOfHandCards);
        Assert.assertEqual(2,testplayer2.nrOfHandCards);
    }

    // Skip Card Test

    public void testSkip() {
        card newCard = new card("r",5);
        ArrayList<player> players = game.getplayer();
        player testplayer2 = players.remove(1);
        player testplayer1 =  players.remove(0);

        game.add_middlestack(newCard);
        skip skipCard = new skip("r",2);
        game.checklegalturn("RedSkip",testplayer1);
        testplayer1.playCard(skipCard);
        Assert.assertEquals(2,game.returnDirectionNextPlayer());
    }

    // Reverse Card Test

    @Test
    public void testReverse() {
        card newCard = new card("r",5);
        ArrayList<player> players = game.getplayer();
        player testplayer2 = players.remove(1);
        player testplayer1 =  players.remove(0);

        game.add_middlestack(newCard);
        reverse reverseCard = new reverse("r",-1);
        game.checklegalturn("RedSkip",testplayer1);
        testplayer1.playCard(skipCard);
        Assert.assertEquals(-1,game.returnDirectionNextPlayer());

        reverse reverseCard2 = new reverse("r",-1);
        testplayer1.playCard(skipCard2);
        game.checklegalturn("RedSkip",testplayer1);
        Assert.assertEquals(1,game.returnDirectionNextPlayer());
    }
}
