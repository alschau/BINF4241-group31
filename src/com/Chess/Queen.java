package com.Chess;

public class Queen implements Schachfigur {
    String color;
    String name;

    public Queen(String c){
        this.color = c;
        this.name = color +"Q";
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
