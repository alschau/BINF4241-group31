package com.Assignment5.Part1;

import java.util.ArrayList;
import java.util.Random;

public class  LadderField extends Field {
    int height;
    int target;
    public LadderField(int number) {
        super(number);
        Random rand = new Random();
        height = 3;
        target = number + height;
    }

    public int getTarget() {return target;}

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String getTextNumber() {
        return number + "->" + (number+height);
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
