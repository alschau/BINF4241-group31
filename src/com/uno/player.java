package com.uno;

import com.Chess.Player;

import java.util.ArrayList;

public class player {
    private String name;
    private int age = 20;
    ArrayList<card> handcards = new ArrayList<card>();

    public player(String name){
        this.name = name;
    }

    public void printhand(){
        System.out.println(name + "'s hand is:");

        for(card temp: handcards){
            System.out.print(temp.getRepr() + "  ");
        }
        System.out.println("\n");
    }

    public void remove_from_hand(card card){
        handcards.remove(card);
    }

    public void add_to_hand(card card){
        handcards.add(card);
    }

    public String getName() {
        return name;
    }

}
