package com.Assignment5.Part3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

public class UnoTest {



    // Age test
    @Test
    public void AgeTest(){

        player1 = new Player("Timmy", 12);
        player2 = new Player("Jean-Claude van Ramme", 6);

        ArrayList<Player> players = ArrayList<>(){player1, player2};

        game = new Game(players);
        game.start();

        thrown.exceptMessage("Jean-Claude van Ramme not old enough.");
    }

    // Player amount test only 1 Player
    @Test
    public void AmountTooFewTest(){

        player1 = new Player("Timmy", 12);

        ArrayList<> players = ArrayList<>(){player1};

        game = new Game(players);
        game.start();

        thrown.exceptMessage("The game is for 2-10 players!");
    }

    // Player Amount Test too many
    @Test
    public void AmountTooManyTest(){

        Player player1 = new Player("Timmy", 12);
        Player player2 = new Player("Jean-Claude van Ramme", 14);
        Player player3 = new Player("Cosmo", 30);
        Player player4 = new Player("Timmy Turners Mom", 12);
        Player player5 = new Player("Timmy Turners Dad", 14);
        Player player6 = new Player("Vicksy", 13);
        Player player7 = new Player("Doug Dimmadome, owner of the Dimstale Dimmadome", 70);
        Player player8 = new Player("Wanda", 30);
        Player player9 = new Player("A.J", 13);
        Player player10 = new Player("Chester", 12);
        Player player11 = new Player("Trixie", 14);
        Player player12 = new Player("Chin Crimson", 13);

        ArrayList<> players = ArrayList<>(){player1, player2, player3, player4, player5, player6, player7, player8, player9, player10, player11, player12};

        game = new Game(players);
        game.start();

        thrown.exceptMessage("The game is for 2-10 players!");

    }


}
