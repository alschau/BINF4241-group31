package com.Chess;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        /**System.out.println("hello");
        Scanner scanner = new Scanner(System.in);
        //player names
        System.out.println("Name of player 1: ");
        String name1 = scanner.nextLine();
        System.out.println("Name of player 2: ");
        String name2 = scanner.nextLine();
        System.out.println(name1);

        String color_name1 = "w";
        String color_name2 = "b";
         */

        ArrayList<String> names = new ArrayList<String>( Arrays.asList("nigger", "a", "b", "c", "d", "e", "f", "g", "h") );
        names.indexOf("Apple");


        Board board = new Board();




        board.printboard();

        board.move("a2","c3");
        board.printboard();



    }
}



