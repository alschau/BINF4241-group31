package com.Chess;

import java.util.ArrayList;
import java.util.Arrays;

public class Pawn implements Schachfigur {
    String color;
    String name;
    String character = "P";
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );

    public Pawn(String c){
        this.color = c;
        this.name = color +"P";
    }
    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getCharacter(){
        return character;
    }

    public Boolean islegal(int x1, int y1, int x2, int y2) {
        return null;
    }

}
