package com.Assignment3_part1;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Board {

    private static Board uniqueinstance;
    private Schachfigur[][] board;
    ArrayList<String> names = new ArrayList<String>( Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h") );
    ArrayList<Schachfigur> graveyard1 = new ArrayList<>();
    ArrayList<Schachfigur> graveyard2 = new ArrayList<>();


    private Board(){

        board = new Schachfigur[8][8];

        board[0][0] = new Rook("B");
        board[0][1] = new Knight("B");
        board[0][2] = new Bishop("B");
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
    }

    public static Board getInstance() {
        if (uniqueinstance == null) {
            uniqueinstance = new Board();
        }
        return uniqueinstance;
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

    public void move(int x1, int y1, int x2, int y2, boolean doublemoved){
        if(doublemoved) {
            if (board[x1][y1].getColor().equals("W")) {
                if (board[(x2+1)][y2] != null && (y1 != y2)) {
                    graveyard1.add(board[(x2+1)][y2]);
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
            if(board[x2][y2].getColor().equals("W")){
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

    public void promotion(int x1,int y1){

        Scanner s = new Scanner(System.in);
        System.out.println("Congratulations, you can promote a Pawn. Enter the character of the figure you want :R,N,B,Q. Other inputs will resolve in a Queen:");
        String figure = s.nextLine();

        Schachfigur f;

        if(x1 == 0) {
            if (figure.equals("R")) {
                f = new Rook("W");
            } else if (figure.equals("N")) {
                f = new Knight("W");
            } else if (figure.equals("B")) {
                f = new Bishop("W");
            } else {
                f = new Queen("W");
            }
            board[x1][y1] = f;

        } else if(x1==7){
            if (figure.equals("R")) {
                f = new Rook("B");
            } else if (figure.equals("N")) {
                f = new Knight("B");
            } else if (figure.equals("B")) {
                f = new Bishop("B");
            } else {
                f = new Queen("B");
            }
            board[x1][y1]=f;
        }

    }
}
