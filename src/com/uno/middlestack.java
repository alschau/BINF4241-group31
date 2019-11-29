package com.uno;

import java.util.ArrayList;

public class middlestack {
    ArrayList<card> middlestack;
    private card topcard;

    public card getTopcard() {
        return topcard;
    }

    public void setTopcard(card topcard) {
        this.topcard = topcard;
    }

    public void print_topcard(){
        System.out.println("the topcard is: " + topcard.getRepr());
    }
}
