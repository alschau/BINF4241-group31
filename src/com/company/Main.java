package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        ArrayList<Player> player = new ArrayList<>();
        ArrayList<Field> fields = new ArrayList<>();


        Scanner scanner= new Scanner(System.in);
        System.out.println("How many players? ");
        int number = Integer.parseInt(scanner.nextLine());
        int start = 1;

        int field_amount = 15;

        while (number >= start) {
            System.out.println("Player "+(start)+": ");
            String name = scanner.nextLine();
            Player P = new Player(name, start);
            player.add(P);
            start++;
        }
        System.out.println("Starting the Game!");
        for (Player p : player){
            System.out.println("Player: "+p.getName()+", Field: "+p.getField()+", Turn: "+p.getTurn());
        }

        //Game Loop

        //Game over as soon as one player.getField==field_amount

    }
}
