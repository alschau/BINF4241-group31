package com.Chess;

public class Pawn implements Schachfigur {
    String color;
    String name;

    public Pawn(String c){
        this.color = c;
        this.name = color +"R";
    }
}
