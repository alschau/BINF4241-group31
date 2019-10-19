package com.Chess;

import java.util.ArrayList;
import java.util.Arrays;

public class Pawn implements Schachfigur {
    private String color;
    private String name;
    Boolean notMoved = true;
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );

    public Pawn(String c){
        this.color = c;
        this.name = color +"P";
    }
    public String getColor() {
        return color;
    }

    @Override
    public String getCharacter() {
        return "P";
    }

    public String getName() {
        return name;
    }

    public Boolean notMoved() {
        return notMoved;
    }

    public void setMoved() {
        this.notMoved = false;
    }

    public Boolean islegal(int x1, int y1, int x2, int y2) {
        //TODO 2 Felder wenn er auf Startposition ist & fressen einbauen
        if(this.color.equals("W")){
            return(y2 == y1-1);
        } else {
            return(y1 == y2-1);
        }
    }

}
