package com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders;

import java.util.ArrayList;

public abstract class Field {
    int number;
    ArrayList<Player> players = new ArrayList<>();

    public Field(int a){
        this.number = a;
    }

    // Setter and Getter

    abstract public int getNumber();

    abstract public String getTextNumber();

    abstract public boolean getFree();

    abstract public ArrayList<Player> getPlayer();

    abstract public void setPlayer(Player p);

    abstract public void removePlayer(Player p);

    public abstract int getTarget();
}
