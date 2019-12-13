package com.Assignment5.Part1;

import java.util.ArrayList;

public class NormalField extends Field {

    public NormalField(int number) {
        super(number);
    }


    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String getTextNumber() {
        return number+"";
    }


    @Override
    public boolean getFree() {
        return players.size() == 0;
    }

    @Override
    public ArrayList<Player> getPlayer() {
        return players;
    }

    @Override
    public void setPlayer(Player p) {
        players.add(p);
    }

    @Override
    public void removePlayer(Player p) {
        players.remove(p);
    }

    @Override
    public int getTarget() {
        return 0;
    }

}
