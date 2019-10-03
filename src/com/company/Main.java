package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Dice dice = new Dice();
        System.out.println(dice.roll());

        ArrayList<Player> player = new ArrayList<>();
        ArrayList<Field> fields = new ArrayList<>();

        Scanner scanner= new Scanner(System.in);
        //System.out.println("How many players? ");
        int number;


        while(true) {
            try {
                System.out.println("How many players? ");
                number = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("fuck you");
            }
        }


        //int number = Integer.parseInt(scanner.nextLine());



        int start = 1;
        System.out.println("How many Fields (>= 10)? ");
        int field_amount = Integer.parseInt(scanner.nextLine());
        // int field_amount = 15;
        System.out.println(field_amount);

        Field starter_field = new Field(0);
        for (int i=1; i<field_amount; i++) {
            Field f = new Field(i);
            fields.add(f);
        }

        while (number >= start) {
            System.out.println("Player "+(start)+": ");
            String name = scanner.nextLine();
            Player P = new Player(name, start, starter_field);
            player.add(P);
            start++;
        }
        System.out.println("Starting the Game!");
        for (Player p : player){
            System.out.println("Player: "+p.getName()+", Field: "+p.getField().getNumber()+", Turn: "+p.getTurn());
        }

        //Game Loop


        //Game over as soon as one player.getField==field_amount

    }
}
