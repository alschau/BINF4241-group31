package com.Chess;

public class Pawn extends Schachfigur {

    public Pawn(int player){

        which_color(player);
    }

    public String toString() {
        return color + "P";
    }

}
