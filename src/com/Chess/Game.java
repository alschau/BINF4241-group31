package com.Chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    Board board;
    int turn = 1;
    String currentcolor;
    String player1;
    String player2;
    String player;
    String from;
    String to;
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );


    public Game(Board b, String p1, String p2){
        this.board = b;
        this.player1 = p1;
        this.player2 = p2;
        b.printboard();
        System.out.println("The Game starts!");

        ArrayList<String> coordinates = new ArrayList<String>( Arrays.asList("a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1", "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2", "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3", "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4", "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5", "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6", "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7", "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"));


        while(true){
            if(this.turn%2 == 1){
                this.player = player1;
                this.currentcolor = "W";
            } else {
                this.player = player2;
                this.currentcolor = "B";
            }

            Scanner scanner = new Scanner(System.in);

            int x1;
            int y1;

            while(true){
                while(true){
                    System.out.println(player + ", choose a valid field of a figure ");
                    from = scanner.nextLine();
                    if(coordinates.contains(from)){
                        break;
                    }

                    //TODO: Check if one of my figures is on that field

                }

                x1 = names.indexOf(String.valueOf(from.charAt(0))); //letter
                y1 = Integer.parseInt(String.valueOf(from.charAt(1)))-1; //number

                if((board.getBoard()[x1][y1] == null) || !(board.getBoard()[x1][y1].getColor() == currentcolor)){
                    System.out.println("tut mir leid auf diesem feld befindet sich keine oder eine gegnerische figur");
                    continue;
                }
                else{
                    break;
                }

            }



            while(true){
                System.out.println(player + " Enter the field where you want to move your figure: ");
                to = scanner.nextLine();
                if(coordinates.contains(to)){
                    break;
                }
                else{
                    System.out.println("Please enter a valid field");
                }

                //TODO: Check if I can go to that field

            }


            int x2 = names.indexOf(String.valueOf(to.charAt(0)));
            int y2 = Integer.parseInt(String.valueOf(to.charAt(1)))-1;


            board.move(x1,y1,x2,y2);




            b.printboard();
            this.turn++;

        }
    }


    public void printBoard(){
        board.printboard();
    }

    public ArrayList getFields(Board board, int x1, int y1, int x2, int y2){
        ArrayList<int[]> path = new ArrayList<>();
        Arrays.asList();

        int delta;
        int sign;

        if((x1==x2) && (y1 -y2<0)){
            for(int i =y1;i<y2;i++){
                int[] x = new int[]{x1,i};
                path.add(x);
            }

        }

        else if((x1==x2) && (y1 -y2>0)){
            for(int i =y1;i>y2;i--) {
                int[] x = new int[]{x1, i};
                path.add(x);
            }
        }

        else if((y1==y2) && (x1 -x2>0)){
            for(int i =x1;i>x2;i--) {
                int[] x = new int[]{i, y1};
                path.add(x);
            }
        }

        else if((y1==y2) && (x1 -x2<0)){
            for(int i =x1;i<x2;i++) {
                int[] x = new int[]{i, y1};
                path.add(x);
            }
        }


        return null;

    }

}
