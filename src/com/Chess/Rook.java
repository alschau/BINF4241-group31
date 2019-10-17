package com.Chess;

import java.util.ArrayList;
import java.util.Arrays;

public class Rook implements Schachfigur {


    String color;
    String name;
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );

    public Rook(String c){
        this.color = c;
        this.name = color +"R";
    }
    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }


    public Boolean islegal(String a,String b) {
        int x1 = names.indexOf(String.valueOf(a.charAt(0))); //letter
        int y1 = Integer.parseInt(String.valueOf(a.charAt(1)))-1; //number

        int x2 = names.indexOf(String.valueOf(b.charAt(0)));
        int y2 = Integer.parseInt(String.valueOf(b.charAt(1)))-1;

        if(!(x1 - x2 == 0 || y1 - y2 == 0)){
            return false;
        }



        return Boolean.TRUE;
    }
}
