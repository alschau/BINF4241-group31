package com.Chess;

public class Board {

    int boardsize;

    public Board(int boardsize){

        this.boardsize = boardsize;

        Schachfigur[][] board = new Schachfigur[boardsize][boardsize];

        for(int i = 0;i<boardsize;i++){
            for(int j = 0; j<boardsize;j++){

                if((j == 0)&&(i == 0 || i == 7)){
                    board[i][j] = new Pawn();
                }

                else if((j == 7)&&(i == 0 || i == 7)){
                    board[i][j] = new Pawn();
                }

                else{
                    board[i][j] = null;
                }



            }
        }
    }

    public void printboard(){
        System.out.println(" a  b  c  d  e  f  g  h \n");
        for(int i=0; i<boardsize;i++){
            System.out.println("");
        }


    }




}
