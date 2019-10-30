package com.Assignment3;

import java.util.ArrayList;
import java.util.Arrays;

public class SuperQueen implements SpecialSchachfigur {
    private String color;
    private String name;
    Boolean notMoved = true;
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );

    public SuperQueen(String c){
        this.color = c;
        this.name = color +"Q";
    }
    public String getColor() {
        return color;
    }

    @Override
    public String getCharacter() {
        return "Q";
    }

    public String getName() {
        return name;
    }

    public Boolean notMoved() {
        return notMoved;
    }

    public void setMoved() {
        this.notMoved = false;
    }

    public Boolean doublemoved() {return false;}

    public Boolean islegal(Board board, int x1, int y1, int x2, int y2, boolean g) {
        return(true);
    }
}