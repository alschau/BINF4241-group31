package com.Chess;

public class Board {

    Schachfigur[][] board;



    public Board(){



        this.board = new Schachfigur[8][8];

        for(int i = 0;i<8;i++){
            for(int j = 0; j<8;j++){

                if(i == 0){
                    if(j == 0 || j == 7){
                        board[i][j] = new Rook("B");
                    }
                    else if(j == 1 || j ==6){
                        board[i][j] = new Knight("B");
                    }
                    else if(j == 2 || j ==5){
                        board[i][j] = new Bishop("B");
                    }
                    else if(j == 3){
                        board[i][j] = new King("B");
                    }
                    else if(j == 4){
                        board[i][j] = new Queen("B");
                    }
                }

                else if(i==1){
                    board[i][j] = new Pawn("B");
                }

                else if(i ==6){
                    board[i][j] = new Pawn("W");
                }

                else if(i == 7){
                    if(j == 0 || j == 7){
                        board[i][j] = new Rook("W");
                    }
                    else if(j == 1 || j ==6){
                        board[i][j] = new Knight("W");
                    }
                    else if(j == 2 || j ==5){
                        board[i][j] = new Bishop("W");
                    }
                    else if(j == 3){
                        board[i][j] = new King("W");
                    }
                    else if(j == 4){
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
        for(int i=0; i<8;i++){
            System.out.print("\n" + Integer.toString(i + 1)+ " ");
            for(int j=0; j<8;j++){
                if(board[i][j] != null){
                    System.out.print("["+board[i][j].getName()+"]");
                }
                else{
                    System.out.print("[  ]");
                }

            }
        }


    }




}
