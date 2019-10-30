package com.Assignment3;

import java.util.ArrayList;
import java.util.Arrays;

public class Pawn implements Schachfigur {
    private String color;
    private String name;
    Boolean notMoved = true;
    Boolean doublemoved = false;
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

    public Boolean doublemoved() { return doublemoved; }

    public void setMoved() {
        this.notMoved = false;
    }





    public Boolean islegal(Board board, int x1, int y1, int x2, int y2, boolean doublemovedbefore) {

        // White Pawn
        if(this.color.equals("W")){
            if(x1==6 && board.getBoard()[x2][y2]==null){
                return((x2 == x1-1 && y1==y2)||(y1==y2 && x2 == x1-2));
            }


            else if(board.getBoard()[x2][y2]!=null){
                return((x1-1==x2 && y1-1==y2) || (x1-1==x2 && y1+1==y2));
            }

            else {
                return (x2 == x1-1 && y1==y2);
            }

            // Black Pawn
        } else {
            if(x1==1 && board.getBoard()[x2][y2]==null) {
                return (x2 == x1 + 1 && y1 == y2) || (y1 == y2 && x2 == x1 + 2);
                // En Passant here as well
            }else if(board.getBoard()[x2][y2]!=null){
                return((x1+1==x2 && y1-1==y2) || (x1+1==x2 && y1+1==y2));
            } else {
                return (x1 == x2 - 1 && y1 == y2);
            }
        }
    }

}