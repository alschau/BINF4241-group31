package com.Chess;



import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    private Schachfigur[][] board;
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );
    ArrayList<Schachfigur> graveyard1 = new ArrayList<>();
    ArrayList<Schachfigur> graveyard2 = new ArrayList<>();


    public Board(){

        board = new Schachfigur[8][8];

        board[0][0] = new Rook("B");
        board[0][2] = new Bishop("B");
        board[0][1] = new Knight("B");
        board[0][3] = new Queen("B");
        board[0][4] = new King("B");
        board[0][5] = new Bishop("B");
        board[0][6] = new Knight("B");
        board[0][7] = new Rook("B");

        board[7][0] = new Rook("W");
        board[7][1] = new Knight("W");
        board[7][2] = new Bishop("W");
        board[7][3] = new Queen("W");
        board[7][4] = new King("W");
        board[7][5] = new Bishop("W");
        board[7][6] = new Knight("W");
        board[7][7] = new Rook("W");

        for(int i=0; i<8; i++){
            board[1][i] = new Pawn("B");
            board[6][i] = new Pawn("W");
        }

        /*
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
                        board[i][j] = new Queen("B");
                    }
                    else if(i == 4){
                        board[i][j] = new King("B");
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
                        board[i][j] = new Queen("W");
                    }
                    else if(i == 4){
                        board[i][j] = new King("W");
                    }



                else{
                    board[i][j] = null;
                }
            }

        }*/
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
        System.out.println("\n");
    }

    public void move(int x1, int y1, int x2, int y2, boolean muchosimportantes){
        System.out.println(muchosimportantes);
        if(muchosimportantes) {
            if (board[x1][y1].getColor() == "W") {
                if (board[(x2+1)][y2] != null && (y1 != y2)) {
                    graveyard1.add(board[(x2+1)][y2]);
                    System.out.println("wieso gaht das ned");
                    board[(x2+1)][y2] = null;
                }
            }
            else {
                if (board[(x2-1)][y2] != null) {
                    graveyard2.add(board[(x2-1)][y2]);
                    board[(x2-1)][y2] = null;
                }
            }
        }

        if (board[x2][y2] != null){
            if(board[x2][y2].getColor()=="W"){
                graveyard1.add(board[x2][y2]);
            }
            else {
                graveyard2.add(board[x2][y2]);
            }

        }
        Schachfigur x = board[x1][y1];
        board[x1][y1] = null;
        board[x2][y2] = x;

    }


    public Schachfigur[][] getBoard() {
        return board;
    }
}
