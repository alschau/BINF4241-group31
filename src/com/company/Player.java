package com.company;


public class Player {
    Player player;
    int field = 0;
    int reihenfolge = 0;
    String name;

    boolean turn = false;


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

}
