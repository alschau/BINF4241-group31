package com.Assignment3;

import java.util.ArrayList;
import java.util.Arrays;

public class ArchBishop implements Schachfigur {
    private String color;
    private String name;
    Boolean notMoved = true;
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );


    public ArchBishop(String c){
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
        int absX = Math.abs(x1-x2);
        int absY = Math.abs(y1-y2);
        return (((absX == absY) || ((absX == 1)&&(absY ==2))||((absX == 2)&&(absY ==1))) && !((x1==x2)&&(y1==y2)));
    }
}