package com.Chess;

import java.util.ArrayList;
import java.util.Arrays;

public class Queen implements Schachfigur {
    String color;
    String name;
    String character = "Q";
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );

    public Queen(String c){
        this.color = c;
        this.name = color +"Q";
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

        if((!(x1-x2 == y1-y2)) || (!(x1 - x2 == 0 || y1 - y2 == 0))){
            return false;
        }
        return null;
    }

}
