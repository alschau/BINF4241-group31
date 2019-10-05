package com.company;

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
    public void setNumber(int n) {
        number = n;
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
}
