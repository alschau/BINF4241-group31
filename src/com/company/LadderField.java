package com.company;

import java.util.ArrayList;
import java.util.Random;

public class LadderField extends Field{
    int target;
    public LadderField(int number) {
        super(number);
        Random rand = new Random();
        target = (rand.nextInt(3) + 1);
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String getTextNumber() {
        return number + "->" + (number+target);
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
