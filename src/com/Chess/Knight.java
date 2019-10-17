package com.Chess;

import java.util.ArrayList;
import java.util.Arrays;

public class Knight implements Schachfigur {
    String color;
    String name;
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );

    public Knight(String c){
        this.color = c;
        this.name = color +"N";
    }
    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    @Override
    public Boolean islegal(int x1, int y1, int x2, int y2) {
        return null;
    }

}
