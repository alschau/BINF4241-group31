package com.Chess;

import java.util.ArrayList;
import java.util.Arrays;

public class Knight implements Schachfigur {
    String color;
    String name;
    String character = "N";
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );

    public Knight(String c){
        this.color = c;
        this.name = color +"N";
    }
    public String getColor() {
        return color;
    }

    @Override
    public String getCaracter() {
        return character;
    }

    public String getName() {
        return name;
    }



    @Override
    public Boolean islegal(int x1, int y1, int x2, int y2) {
        int absX = Math.abs(x1-x2);
        int absY = Math.abs(y1-y2);
        return (((absX == 1)&&(absY ==2))||((absX == 2)&&(absY ==1)));
    }

}
