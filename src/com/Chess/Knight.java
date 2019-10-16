package com.Chess;

public class Knight implements Schachfigur {
    String color;
    String name;

    public Knight(String c){
        this.color = c;
        this.name = color +"R";
    }
}
