package com.Chess;

public class Bishop implements Schachfigur {
    String color;
    String name;

    public Bishop(String c){
        this.color = c;
        this.name = color +"R";
    }
}
