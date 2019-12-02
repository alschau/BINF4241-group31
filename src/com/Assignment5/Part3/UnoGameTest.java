package com.Assignment5.Part3;

import com.Assignment5.Part3.uno.Game;
import org.junit.Before;
import org.junit.Test;

public class UnoGameTest {
    private Player player1;
    private Player player2;
    private Player player3;
    private Game game;


    @Before
    public void setup(){
        player1 = new Player("Timmy", 12);
        player2 = new Player("Jean-Claude van Ramme", 14);
        player3 = new Player("Cosmo", 30);

        ArrayList<Player> players = ArrayList<>(){player1, player2, player3};

        game = new Game(players);
        game.start();
    }

    // 7 cards

    // player 1 starts

    // if action card on top

    // if player cant play

    //



    @Test
    public void normalCard(){

    }

    @Test
    public void reverseCard(){

    }

    @Test
    public void skipCard(){

    }

    @Test
    public void drawTwoCard(){

    }

    @Test
    public void wildCard(){

    }

    @Test
    public void wildDrawFourCard(){

    }


}
