package com.Chess;

import java.util.ArrayList;
import java.util.Arrays;

public class Bishop implements Schachfigur {
    String color;
    String name;
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );


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
    public Boolean islegal(int x1, int y1, int x2, int y2) {
            return ((Math.abs(x1-x2) == Math.abs(y1-y2)) && !((x1==x2)&&(y1==y2)));
    }
}
