package com.company;

import java.util.ArrayList;

public class Field {
    int number;
    ArrayList<Player> players = new ArrayList<>();
    boolean free;

    public Field(int n){
        this.number = n;
    }

    // Setter and Getter

    public int getNumber(){
        return this.number;
    }

    public void setNumber(int n){
        this.number = n;
    }

    public boolean getFree(){
        return this.free;
    }

    public void setFree(boolean f){
        this.free = f;
    }

    public ArrayList<Player> getPlayer(){
        return this.players;
    }

    public void setPlayer(Player p){
        this.players.add(p);
    }
    public void removePlayer(Player p){
        this.players.remove(p);
    }

}
