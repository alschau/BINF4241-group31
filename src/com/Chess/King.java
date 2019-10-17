package com.Chess;

import java.util.ArrayList;
import java.util.Arrays;

public class King implements Schachfigur {
    String color;
    String name;
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );

    public King(String c){
        this.color = c;
        this.name = color +"K";
    }
    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    @Override
    public Boolean islegal(int x1, int y1, int x2, int y2) {
        return ((x1+1 == x1 || x1-1 == x1) || (y1+1 == y1 || y1-1 == y1));
    }

}
