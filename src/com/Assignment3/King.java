package com.Assignment3;

import java.util.ArrayList;
import java.util.Arrays;

public class King implements Schachfigur {
    private String color;
    private String name;
    Boolean notMoved = true;
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );

    public King(String c){
        this.color = c;
        this.name = color +"K";
    }
    public String getColor() {
        return color;
    }

    @Override
    public String getCharacter() {
        return "K";
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

    @Override
    public Boolean islegal(Board board, int x1, int y1, int x2, int y2, boolean g) {
        return ((x1+1 == x2 || x1-1 == x2) || (y1+1 == y2 || y1-1 == y2));
    }

}