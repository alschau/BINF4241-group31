package com.Assignment3_part1;

import java.util.ArrayList;
import java.util.Arrays;

public class Bishop implements Schachfigur {
    private String color;
    private String name;
    Boolean notMoved = true;
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );


    public Bishop(String c){
        this.color = c;
        this.name = color +"B";
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getCharacter() {
        return "B";
    }

    public Boolean doublemoved() {return false;}

    public String getName() {
        return name;
    }

    public Boolean notMoved() {
        return notMoved;
    }

    public void setMoved() {
        this.notMoved = false;
    }

    public Boolean islegal(Board board, int x1, int y1, int x2, int y2, boolean g) {
        return ((Math.abs(x1-x2) == Math.abs(y1-y2)) && !((x1==x2)&&(y1==y2)));
    }
}