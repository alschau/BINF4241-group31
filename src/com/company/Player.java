package com.company;


public class Player {

    // Attributes of Player
    Player player;
    int field = 0;
    int reihenfolge;
    String name;
    boolean turn = false;



    public Player(String name, int reihenfolge){
        this.name = name;
        this.reihenfolge = reihenfolge;
        if (this.reihenfolge == 1){
            turn = true;
        }
    }


    // Setters and Getters

    public int getReihenfolge(){
        return this.reihenfolge;
    }

    public void setReihenfolge(int n){
        this.reihenfolge = n;
    }


    public int getField(){
        return this.field;
    }

    public void setField(int anzahl){
        this.field += anzahl;
    }


    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }


    public boolean getTurn(){
        return this.turn;
    }

    public void setTurn(boolean b){
        this.turn = b;
    }

}
