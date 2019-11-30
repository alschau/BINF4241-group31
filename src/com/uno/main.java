package com.uno;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        ArrayList<player> players = new ArrayList<player>();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        System.out.println("Welcome to uno! Please enter your playernames (2-10). enter *start* if youre ready!");
        while(players.size() < 9){
            System.out.println("enter here: ");
            input = scanner.nextLine();
            if(input.equals("start")){
                if(players.size() < 2){
                    input = "";
                    System.out.println("sorry you need at least 2 players to play this game");
                    continue;
                }
                break;
            }
            player x = new player(input);
            players.add(x);
        }
        drawstack stack = new drawstack();

        Game game = new Game(players);
        game.start();




    }

}
