package com.uno;

import java.util.ArrayList;

public class Game {
    ArrayList<player> players;
    drawstack drawstack;
    middlestack middlestack;

    public Game(ArrayList<player> players){
        this.players = players;
        this.drawstack = new drawstack();
        this.middlestack = new middlestack();
    }
}
