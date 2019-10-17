package com.Chess;
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


        Board board = new Board();
        Game game =  new Game(board);

        board.printboard();

        board.move("c1","h7");
        board.printboard();
        board.move("h7","d5");
        board.printboard();

        System.out.println(board.getBoard()[0][1].getName());



    }
}



