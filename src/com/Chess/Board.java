package com.Chess;



import com.sun.nio.sctp.AbstractNotificationHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    Schachfigur[][] board;
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );



    public Board(){



        this.board = new Schachfigur[8][8];

        for(int i = 0;i<8;i++){
            for(int j = 0; j<8;j++){

                if(j == 0){
                    if(i == 0 || i == 7){
                        board[i][j] = new Rook("B");
                    }
                    else if(i == 1 || i ==6){
                        board[i][j] = new Knight("B");
                    }
                    else if(i == 2 || i ==5){
                        board[i][j] = new Bishop("B");
                    }
                    else if(i == 3){
                        board[i][j] = new King("B");
                    }
                    else if(i == 4){
                        board[i][j] = new Queen("B");
                    }
                }

                else if(j==1){
                    board[i][j] = new Pawn("B");
                }

                else if(j ==6){
                    board[i][j] = new Pawn("W");
                }

                else if(j == 7){
                    if(i == 0 || i == 7){
                        board[i][j] = new Rook("W");
                    }
                    else if(i == 1 || i ==6){
                        board[i][j] = new Knight("W");
                    }
                    else if(i == 2 || i ==5){
                        board[i][j] = new Bishop("W");
                    }
                    else if(i == 3){
                        board[i][j] = new King("W");
                    }
                    else if(i == 4){
                        board[i][j] = new Queen("W");
                    }

                }

                else{
                    board[i][j] = null;
                }
            }
        }
    }




    public void printboard(){
        System.out.print("    a   b   c   d   e   f   g   h ");
        for(int j=0; j<8;j++){
            System.out.print("\n" + Integer.toString(j + 1)+ " ");
            for(int i=0; i<8;i++){
                if(board[i][j] != null){
                    System.out.print("["+board[i][j].getName()+"]");
                }
                else{
                    System.out.print("[  ]");
                }

            }
        }
        System.out.println("\n");
    }

    public void move(String a,String b){


        int x1 = names.indexOf(String.valueOf(a.charAt(0))); //letter
        int y1 = Integer.parseInt(String.valueOf(a.charAt(1)))-1; //number

        int x2 = names.indexOf(String.valueOf(b.charAt(0)));
        int y2 = Integer.parseInt(String.valueOf(b.charAt(1)))-1;

        Schachfigur x = board[x1][y1];
        board[x1][y1] = null;
        board[x2][y2] = x;

    }

    public void checkpath(String a, String b){
        int x1 = names.indexOf(String.valueOf(a.charAt(0))); //letter
        int y1 = Integer.parseInt(String.valueOf(a.charAt(1)))-1; //number

        int x2 = names.indexOf(String.valueOf(b.charAt(0)));
        int y2 = Integer.parseInt(String.valueOf(b.charAt(1)))-1;




    }

    public Schachfigur[][] getBoard() {
        return board;
    }
}
