package com.Chess;

public class King implements Schachfigur {
    String color;
    String name;

    public King(String c){
        this.color = c;
        this.name = color +"R";
    }
}
