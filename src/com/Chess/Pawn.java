package com.Chess;

import java.util.ArrayList;
import java.util.Arrays;

public class Pawn implements Schachfigur {
    String color;
    String name;
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

    @Override
    public Boolean islegal(String a, String b) {
        int x1 = names.indexOf(String.valueOf(a.charAt(0))); //letter
        int y1 = Integer.parseInt(String.valueOf(a.charAt(1)))-1; //number

        int x2 = names.indexOf(String.valueOf(b.charAt(0)));
        int y2 = Integer.parseInt(String.valueOf(b.charAt(1)))-1;
        return null;
    }

}
