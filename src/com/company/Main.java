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

        while (number >= start) {
            System.out.println("Player "+(start)+": ");
            String name = scanner.nextLine();
            Player P = new Player(name, start);
            player.add(P);
            start++;
        }

        for (Player p : player){
            System.out.println(p.getName());
        }
    }
}
