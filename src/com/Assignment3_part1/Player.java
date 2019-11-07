package com.Assignment3_part1;

public class Player {
    private String color;
    private String name;
    public Boolean kingalive = true;

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