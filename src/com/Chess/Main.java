package com.Chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        //todo exception handling

        Scanner scanner = new Scanner(System.in);
        String name1;
        String name2;
        //player names
        while(true){
            System.out.println("Name of player 1: ");
            name1 = scanner.nextLine();

            if(name1 != null && !name1.isEmpty()){
                break;
            }
            System.out.println("Please enter a name");

        }

        while(true){
            System.out.println("Name of player 2: ");
            name2 = scanner.nextLine();

            if(name2 != null && !name2.isEmpty()){
                break;
            }
            System.out.println("Please enter a name");

        }


        Board board = new Board();

        Game game =  new Game(board, name1, name2);


    }
}

