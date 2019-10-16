package com.Chess;

public class Rook implements Schachfigur {
    String color;
    String name;

    public Rook(String c){
        this.color = c;
        this.name = color +"R";
    }
}
