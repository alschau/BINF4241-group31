package com.company;


public class Player {

    // Attributes of Player
    Player player;
    Field field;
    int reihenfolge;
    String name;
    boolean turn = false;



    public Player(String name, int reihenfolge, Field field){
        this.name = name;
        this.field = field;
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


    public Field getField(){
        return this.field;
    }

    public void setField(int die){
        this.field.number = this.field.number + die;
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
