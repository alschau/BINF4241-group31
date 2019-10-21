package com.Chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private Board board;
    private int turn = 1;
    private String currentcolor;
    private String player1;
    private String player2;
    private String player;
    private String from;
    private String to;
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
            String x2string;

            int x2;
            int y2;
            int x1 = 4;
            int y1 = 4;
            String hh;

            while(true){
                while(true){
                    System.out.println(player + ", make your move ");
                    from = scanner.nextLine();
                    if (from.contains("x")) {
                        StringBuilder kk = new StringBuilder(from);
                        int v = from.indexOf("x");
                        from = kk.deleteCharAt(v).toString();
                    }

                    if (Character.isUpperCase(from.indexOf(0))){

                        y2 = names.indexOf(String.valueOf(from.charAt(from.length() - 2 ))); //letter
                        x2 = Integer.parseInt(String.valueOf(from.charAt(from.length() - 1 )))-1; //number
                        System.out.println(x2);
                        System.out.println(y2);
                        break;
                    }
                    else if(Character.isLowerCase(from.indexOf(0))) {

                        //en passant
                        if(from.substring(from.length()-1) == ".") {
                            x2 = Integer.parseInt(String.valueOf(from.charAt(from.length() -5 )))-1; //number
                            y2 = names.indexOf(String.valueOf(from.charAt(from.length() -6 ))); //letter
                            System.out.println(x2);
                            System.out.println(y2);
                            break;
                        }
                        //promotion
                        else if(from.contains("=")) {
                            x2 = Integer.parseInt(String.valueOf(from.charAt(1)))-1; //number
                            y2 = names.indexOf(String.valueOf(from.charAt(0 ))); //letter
                            hh = from.substring(from.length()-1);
                        }

                        else {
                            x2 = Integer.parseInt(String.valueOf(from.charAt(1)))-1; //number
                            y2 = names.indexOf(String.valueOf(from.charAt(0 ))); //letter
                        }
                    }

                    else {
                        //error
                    }


                    /*if(from.length() == 2){
                        y2 = names.indexOf(String.valueOf(from.charAt(0))); //letter
                        x2 = Integer.parseInt(String.valueOf(from.charAt(1)))-1; //number
                        break;
                    }
                    if(from.length() == 3) {
                        hh = from.substring(0,1);
                        from = from.substring(1);
                        y2 = names.indexOf(String.valueOf(from.charAt(0))); //letter
                        x2 = Integer.parseInt(String.valueOf(from.charAt(1)))-1; //number
                    }
                    if(from.contains("x")) {

                    }*/

                }
               // y1 = names.indexOf(String.valueOf(from.charAt(0))); //letter
                //  x1 = Integer.parseInt(String.valueOf(from.charAt(1)))-1; //number

                if((board.getBoard()[x1][y1] == null) || !(board.getBoard()[x1][y1].getColor() == currentcolor)){
                    System.out.println("I'm sorry on this field is either no piece or one from your opponent");
                    continue;
                }
                else{
                    break;
                }

            }

            System.out.println(x2);
            System.out.println(y2);

            while(true){
                System.out.println(player + " Enter the field where you want to move your figure: ");
                to = scanner.nextLine();
                if(coordinates.contains(to)){
                    break;
                }
                else{
                    System.out.println("Please enter a valid field");
                }
            }
            /*
            int y2 = names.indexOf(String.valueOf(to.charAt(0)));
            int x2 = Integer.parseInt(String.valueOf(to.charAt(1)))-1; */
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
                if (board.getBoard()[x1][y1].islegal(x1, y1, x2, y2)) {
                    // i need to check the fields in between
                    if ("QBR".contains(board.getBoard()[x1][y1].getCharacter())) {
                        // Check if the Path is empty
                        if (isPathEmpty(board, x1, y1, x2, y2)) {
                            board.move(x1, y1, x2, y2);
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

            //Todo check if king (enemy or own) is in danger

            printBoard();
            System.out.println(b.graveyard);
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
