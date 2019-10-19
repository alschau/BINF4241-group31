package com.Chess;

import java.util.ArrayList;
import java.util.Arrays;

public class Rook implements Schachfigur {


    String color;
    String name;
    String character = "R";
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );

    public Rook(String c){
        this.color = c;
        this.name = color +"R";
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


    public Boolean islegal(int x1, int y1, int x2, int y2) {
        return((x1 == x2 || y1 == y2) && !((x1==x2)&&(y1==y2)));
    }
}
