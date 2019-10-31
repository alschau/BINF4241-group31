package com.Chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private Board board;
    private int turn = 1;
    private String currentcolor;
    private Player player1;
    private Player player2;
    private Player player;
    private String from;
    private String to;
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );


    public Game(Board b, String p1, String p2){
        this.board = b;
        Player player1 = new Player(p1, "W");
        Player player2 = new Player(p2, "B");
        b.printboard();
        System.out.println("The Game starts!");

        ArrayList<String> coordinates = new ArrayList<String>( Arrays.asList("a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1", "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2", "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3", "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4", "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5", "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6", "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7", "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"));


        while(true){
            if(this.turn%2 == 1){
                this.player = player1;
            } else {
                this.player = player2;
            }
            this.currentcolor = player.getColor();

            Scanner scanner = new Scanner(System.in);

            int x1;
            int y1;

            while(true){
                while(true){
                    System.out.println(player.getName() + ", choose a valid field of a figure ");
                    from = scanner.nextLine();
                    if(coordinates.contains(from)){
                        break;
                    }

                }

                y1 = names.indexOf(String.valueOf(from.charAt(0))); //letter
                x1 = Integer.parseInt(String.valueOf(from.charAt(1)))-1; //number

                if((board.getBoard()[x1][y1] == null) || !(board.getBoard()[x1][y1].getColor() == currentcolor)){
                    System.out.println("tut mir leid auf diesem feld befindet sich keine oder eine gegnerische figur");
                    continue;
                }
                else{
                    break;
                }

            }



            while(true){
                System.out.println(player.getName() + " Enter the field where you want to move your figure: ");
                to = scanner.nextLine();
                if(coordinates.contains(to)){
                    break;
                }
                else{
                    System.out.println("Please enter a valid field");
                }
            }

            int y2 = names.indexOf(String.valueOf(to.charAt(0)));
            int x2 = Integer.parseInt(String.valueOf(to.charAt(1)))-1;
            boolean rochade = false;

            // Rochade
            if(board.getBoard()[x1][y1].getCharacter().equals("K") && board.getBoard()[x2][y2].getCharacter().equals("R")){
                if(board.getBoard()[x1][y1].notMoved() && board.getBoard()[x2][y2].notMoved() && board.getBoard()[x1][y1].getColor().equals(currentcolor)){
                    // Grosse Rochade (links)
                    System.out.println("rochade");
                    if(y2==0 && isPathEmpty(board, x1, y1, x2, y2)){
                        System.out.println("gross");
                        board.move(x1, y1, x1, y1-2);
                        board.move(x2, y2, x2, y2+3);
                    }
                    // Kleine Rochade (rechts)
                    else if(y2 == 7){
                        System.out.println("chli");
                        board.move(x1, y1, x1, y1+2);
                        board.move(x2, y2, x2, y2-2);
                    }
                    rochade = true;
                }
            }

            // Normaler Zug
            if(!rochade) {
                if (board.getBoard()[x1][y1].islegal(board, x1, y1, x2, y2)) {
                    // i need to check the fields in between
                    if ("QBRP".contains(board.getBoard()[x1][y1].getCharacter())) {
                        // Check if the Path is empty
                        if (isPathEmpty(board, x1, y1, x2, y2)) {
                            board.move(x1, y1, x2, y2);
                            if (board.getBoard()[x2][y2].getCharacter().equals("P") && (x2==0 || x2==7)){
                                board.promotion(x2, y2);
                            }

                        } else {
                            // if not, start turn again
                            System.out.println("you cant move there!");
                            turn--;
                        }
                    } else {
                        // no need to check fields in between
                        board.move(x1, y1, x2, y2);
                    }
                } else {
                    System.out.println("You can't move there with this figure");
                    turn--;
                }
            }
            /*
            // is check
            Boolean check = false;
            Boolean othercheck = false;
            int kingx=0;
            int kingy=0;
            int otherkingx=0;
            int otherkingy=0;

            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    if(board.getBoard()[i][j].getCharacter().equals("K") && board.getBoard()[i][j].getColor().equals(player.getColor())){
                        kingx = i;
                        kingy = j;
                    } else if (board.getBoard()[i][j].getCharacter().equals("K") && !board.getBoard()[i][j].getColor().equals(player.getColor())){
                        otherkingx = i;
                        otherkingy = j;
                    }
                }
            }
            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    if((board.getBoard()[i][j].islegal(board, i, j, kingx, kingy))&& isPathEmpty(board, i, j, kingx, kingy)){
                        check = true;
                    } else if((board.getBoard()[i][j].islegal(board, i, j, otherkingx, otherkingy))&& isPathEmpty(board, i, j, otherkingx, otherkingy)){
                        othercheck = true;
                    }
                }
            }
            */



            printBoard();
            if(player.getColor().equals("W")){
                String grave = "Graveyard of " + player.getName() + ": ";
                for(Schachfigur a: b.graveyard1){
                    grave = grave + a.getCharacter();
                }
                System.out.println(grave);
            } else {
                String grave = "Graveyard of " + player.getName() + ": ";
                for(Schachfigur a: b.graveyard2){
                    grave = grave + a.getCharacter();
                }
                System.out.println(grave);
            }

            this.turn++;

        }
    }


    public void printBoard(){
        board.printboard();
    }


    private Boolean isPathEmpty(Board board, int x1, int y1, int x2, int y2){
        ArrayList<int[]> path = new ArrayList<>();
        int delta;

        if((x1==x2) && (y1 -y2<0)){
            for(int i =y1+1;i<y2;i++){
                int[] x = new int[]{x1, i};
                path.add(x);
            }

        }

        else if((x1==x2) && (y1 -y2>0)){
            for(int i =y1-1;i>y2;i--) {
                int[] x = new int[]{x1, i};
                path.add(x);
            }
        }

        else if((y1==y2) && (x1 -x2>0)){
            for(int i =x1-1;i>x2;i--) {
                int[] x = new int[]{i, y1};
                path.add(x);
            }
        }

        else if((y1==y2) && (x1 -x2<0)){
            for(int i =x1+1;i<x2;i++) {
                int[] x = new int[]{i, y1};
                path.add(x);
            }
        }

        else if((x1>x2)&&(y1>y2)){
            delta = Math.abs(x1-x2);
            for(int i=1; i<delta;i++){
                int[] x = new int[]{x1-i, y1-i};
                path.add(x);
            }
        }

        else if((x1>x2)&&(y1<y2)){
            delta = Math.abs(x1-x2);
            for(int i=1; i<delta;i++){
                int[] x = new int[]{x1-i, y1+i};
                path.add(x);
            }
        }

        else if((x1<x2)&&(y1>y2)){
            delta = Math.abs(x1-x2);
            for(int i=1; i<delta;i++){
                int[] x = new int[]{x1+i, y1-i};
                path.add(x);
            }
        }

        else if((x1<x2)&&(y1<y2)){
            delta = Math.abs(x1-x2);
            for(int i=1; i<delta;i++){
                int[] x = new int[]{x1+i, y1+i};
                path.add(x);
            }
        }

        // Return True if all Fields between are empty, else return False
        for(int[] i : path){
            System.out.println(i[0]);
            System.out.println(i[1]);
            if(board.getBoard()[i[0]][i[1]] != null){
                return false;
            }
        }

        return true;

    }

}
