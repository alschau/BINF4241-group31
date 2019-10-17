package com.Chess;

public class Rook implements Schachfigur {
    String color;
    String name;

    public Rook(String c){
        this.color = c;
        this.name = color +"R";
    }
    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    @Override
    public Boolean islegal() {
        return null;
    }
}
