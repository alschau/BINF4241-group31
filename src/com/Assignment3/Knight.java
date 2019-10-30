package com.Assignment3;

import java.util.ArrayList;
import java.util.Arrays;

public class Knight implements Schachfigur {
    private String color;
    private String name;
    Boolean notMoved = true;
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );

    public Knight(String c){
        this.color = c;
        this.name = color +"N";
    }
    public String getColor() {
        return color;
    }

    @Override
    public String getCharacter() {
        return "N";
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
        int absX = Math.abs(x1-x2);
        int absY = Math.abs(y1-y2);
        return (((absX == 1)&&(absY ==2))||((absX == 2)&&(absY ==1)));
    }

}