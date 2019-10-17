package com.Chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    Board board;
    int turn = 1;
    String color1 = "W";
    String color2 = "B";
    String player1;
    String player2;
    String player;


    public Game(Board b, String p1, String p2){
        this.board = b;
        this.player1 = p1;
        this.player2 = p2;
        b.printboard();
        System.out.println("The Game starts!");
        ArrayList<String> coordinates = new ArrayList<String>( Arrays.asList("a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1", "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2", "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3", "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4", "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5", "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6", "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7", "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"));
        Boolean from_check = true;
        Boolean to_check = true;


        while(true){
            if(this.turn%2 == 1){
                this.player = player1;
            } else {
                this.player = player2;
            }

            Scanner scanner = new Scanner(System.in);
            while(from_check){
                System.out.println(player + ", choose a valid field of a figure ");
                String from = scanner.nextLine();
                if(coordinates.contains(from)){
                    from_check = false;
                }

                //TODO: Check if one of my figures is on that field

                to_check = true;
            }
            while(to_check){
                System.out.println(player + ", make your move: ");
                String to = scanner.nextLine();
                if(coordinates.contains(to)){
                    to_check = false;
                }

                //TODO: Check if I can go to that field

                from_check = true;
            }

            b.printboard();
            this.turn++;

        }
    }


    public void printBoard(){
        board.printboard();
    }


}
