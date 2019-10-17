package com.Chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //player names
        System.out.println("Name of player 1: ");
        String name1 = scanner.nextLine();
        System.out.println("Name of player 2: ");
        String name2 = scanner.nextLine();


        Board board = new Board();









        board.printboard();

        board.move(1,1,3,3);
        board.printboard();
        board.move(2,2,3,3);
        board.printboard();

        Game game =  new Game(board, name1, name2);


    }
}



