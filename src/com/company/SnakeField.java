package com.company;

import java.util.ArrayList;
import java.util.Random;

public class SnakeField extends Field {
    int height;
    int target;
    public SnakeField(int number) {
        super(number);
        Random rand = new Random();
        height = 3;
        target = number + height;

    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String getTextNumber() {
        return (number+height) + "<-" + number;
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

    @Override
    public int getTarget() {
        return target;
    }

}
