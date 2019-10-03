package com.company;

public class Field {
    int number;
    Player player;
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

    public Player getPlayer(){
        return this.player;
    }

    public void setPlayer(Player p){
        this.player = p;
    }

}
