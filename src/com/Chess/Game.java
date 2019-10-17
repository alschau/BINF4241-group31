package com.Chess;

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


        while(true){
            if(this.turn%2 == 1){
                this.player = player1;
            } else {
                this.player = player2;
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println(player + ", make your move: ");
            String move = scanner.nextLine();


            // Check


            b.printboard();
            this.turn++;
        }








    }

    private int dupl(int i){
        return 2*i;
    }



    public void printBoard(){
        board.printboard();
    }


}
