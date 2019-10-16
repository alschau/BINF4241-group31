package com.Chess;

public class Queen implements Schachfigur {
    String color;
    String name;

    public Queen(String c){
        this.color = c;
        this.name = color +"R";
    }
}
