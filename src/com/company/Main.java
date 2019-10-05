package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Dice dice = new Dice();

        ArrayList<Player> player = new ArrayList<>();
        ArrayList<Field> fields = new ArrayList<>();

        Scanner scanner= new Scanner(System.in);
        //System.out.println("How many players? ");
        int number;


        while(true) {
            try {
                System.out.println("How many players? ");
                number = Integer.parseInt(scanner.nextLine());
                if(number<2){
                    System.out.println("you need some friends to play this you lonely fuck");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("fuck you retard cant even input a number");
            }
        }


        int field_amount;
        while(true) {
            try {
                System.out.println("How many Fields (>= 10)? ");
                field_amount = Integer.parseInt(scanner.nextLine());
                if(field_amount<10){
                    System.out.println("can you fucking read????");
                    continue;
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("fuck you retard cant even input a number");
            }
        }

        int start = 1;

        Field starter_field = new Field(0);
        for (int i=1; i< +1; i++) {
            Field f = new Field(i);
            fields.add(f);
        }

        while (number >= start) {
            System.out.println("Player "+(start)+": ");
            String name = scanner.nextLine();
            Player P = new Player(name, start, starter_field);
            player.add(P);
            start++;
        }
        System.out.println("Starting the Game!");
        for (Player p : player){
            System.out.println("Player: "+p.getName()+", Field: "+p.getField().getNumber()+", Turn: "+p.getTurn());
        }

        /*

        //Game Loop
        boolean running = true;
        while (running){
            int die = dice.roll();
            for (Player p : player){
                if (p.getTurn()){
                    p.setField();
                }
            }
        }

        Player current_player = player.get(0);

        while(current_player.getField().getNumber() != field_amount){

            for(int i = 0; i < player.size();i++ ){

                current_player = player.get(i);
                int current_fieldnumber = current_player.getField().getNumber();

                System.out.println("Its your turn, " + current_player.getName());

                int roll = dice.roll();

                System.out.println("You rolled a " + Integer.toString(roll) );

                current_player.setField(fields.get(current_fieldnumber + roll));

                System.out.println(current_player.getName() + ", du befindest dich nun auf dem Feld " + Integer.toString(current_fieldnumber) );



            }


        }






        //Game over as soon as one player.getField==field_amount


        public Field getFieldByNumber(int n){
            for (Field i : fields){
                if (i.getNumber() == n){
                    return i;
                }
            }
        }
        */
    }

}
