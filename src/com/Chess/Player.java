package com.Chess;

public class Player {
    private String color;
    private String name;

    public Player(String name, String color){
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}