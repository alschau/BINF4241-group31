package com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders;


public class Player {

    // Attributes of Player
    Player player;
    Field field;
    int reihenfolge;
    String name;



    public Player(String name, int reihenfolge, Field field){
        this.name = name;
        this.field = field;
        this.reihenfolge = reihenfolge;
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

    public void setField(Field f){
        this.field = f;
    }


    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

}
