package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Dice dice = new Dice();

        ArrayList<Player> player = new ArrayList<>();
        ArrayList<Field> fields = new ArrayList<>();

        Scanner scanner= new Scanner(System.in);
        //System.out.println("How many players? ");
        int number; // was ist das für eine number?
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

        Field starter_field = new NormalField(1);
        fields.add(starter_field);
        for (int i=2; i< field_amount+1; i++) {
            Field f;
            if(i == 3)
                f = new LadderField(i);
            else
                f = new NormalField(i);
            fields.add(f);
        }

        while (number >= start) {
            System.out.println("Player "+(start)+": ");
            String name = scanner.nextLine();
            Player P = new Player(name, start, starter_field);
            player.add(P);
            starter_field.setPlayer(P);
            start++;
        }
        System.out.println("Starting the Game!");
        for (Player p : player){
            System.out.println("Player: "+p.getName()+", Field: "+p.getField().getNumber());
        }

        // GAME LOOP
        System.out.println("Initial state: " + output(fields));

        int turn = 0;
        Player winner;
        while(player.get(turn % number).getField().getNumber() < field_amount){
            Player current_player = player.get(turn % number);
            int roll = dice.roll();
            System.out.println(current_player.getName() +" rolls "+roll);
            if (current_player.getField().getNumber() + roll < field_amount) {
                current_player.getField().removePlayer(current_player);
                current_player.setField(fields.get(current_player.getField().getNumber() + roll -1));
                current_player.getField().setPlayer(current_player);
                turn++;
            } else if (current_player.getField().getNumber() + roll == field_amount){
                current_player.getField().removePlayer(current_player);
                current_player.setField(fields.get(current_player.getField().getNumber() + roll -1));
                current_player.getField().setPlayer(current_player);
                winner = current_player;
                break;
            } else if (current_player.getField().getNumber() + roll > field_amount){
                int minus = current_player.getField().getNumber() - field_amount;
                current_player.getField().removePlayer(current_player);
                current_player.setField(fields.get(field_amount - (roll - (field_amount - current_player.getField().getNumber()))-1));
                current_player.getField().setPlayer(current_player);
                turn++;
            }
            //Print Fields
            System.out.println(output(fields));
        }
        System.out.println("Final state: " + output(fields));
        System.out.println(player.get(turn % number) + " wins!");

    }

    // PRINT OUTPUT

    private static String output(ArrayList<Field> fields){
        String out = "";
        for(Field field : fields){
            if(field.getFree())
                out+="["+field.getTextNumber()+"]";
            else{
                out+="["+field.getTextNumber();
                for(Player play : field.getPlayer()){
                    out+="<"+play.getName()+">";
                }
                out+="]";

            }

        }

        return out;
    }

}

