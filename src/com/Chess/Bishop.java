package com.Chess;

public class Bishop implements Schachfigur {
    String color;
    String name;

    public Bishop(String c){
        this.color = c;
        this.name = color +"B";
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
