package com.company;

import java.util.ArrayList;
import java.util.Random;

public class SnakeField extends Field {
    int target;
    public SnakeField(int number) {
        super(number);
        Random rand = new Random();
        target = (-rand.nextInt(3) - 1);
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String getTextNumber() {
        return (number+target) + "<-" + number;
    }


    @Override
    public boolean getFree() {
        return true;
    }

    @Override
    public ArrayList<Player> getPlayer() {
        return null;
    }

    @Override
    public void setPlayer(Player p) {

    }

    @Override
    public void removePlayer(Player p) {

    }
}
