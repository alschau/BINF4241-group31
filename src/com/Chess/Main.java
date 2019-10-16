package com.Chess;
import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner scanner = new Scanner(System.in);
        //player names
        System.out.println("Name of player 1: ");
        String name1 = scanner.nextLine();
        System.out.println("Name of player 2: ");
        String name2 = scanner.nextLine();
        //System.out.println(name1);

        /*for (int i = 1; i < 9; i++) {

            Pawn x = new Pawn(1);
        }

        */
        Pawn x = new Pawn(2);
        System.out.println(x.color);
        System.out.println(x);

    }
}



       /* System.out.println("Did you decide who wants to start? (yes or no)");
                String decision = scanner.nextLine();

        if (decision == "yes"){
            System.out.println("Player 1 or Player 2?");
            String which_player = scanner.nextLine();
            if (which_player == "Player 1") {
                player1_color = "w";
                player2_color = "b";
            }
            else {
                player1_color = "b";
                player2_color = "w";
            }
        }
        else {


        }*/




