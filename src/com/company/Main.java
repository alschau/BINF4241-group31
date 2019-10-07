package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

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
                if(number<2 || number>4){
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

        //amount of snakes & ladders
        double field_amount_double = field_amount;
        int ladder_amount = (int) Math.floor(field_amount_double/8);
        int snake_amount = (int) Math.floor(field_amount_double/7);
        System.out.println(ladder_amount);
        System.out.println(snake_amount);
        Random r = new Random();

        int k = 0;
        int [] ladder_positions = new int[ladder_amount];
        int [] snake_positions = new int[snake_amount];
        int x;
        while (k < ladder_amount) {
            x = r.nextInt(field_amount +2);
            int l = 0;
            while (l < ladder_amount) {
                if (x == ladder_positions[l]) {
                    k--;
                    break;
                }
                l++;
            }
            ladder_positions[k] = x;
            k++;
        }

        int u = 0;
        while (u < snake_amount) {
            x = r.nextInt(field_amount + 3) ;
            int l = 0;

            while (l < snake_amount) {
                if (x == snake_positions[l]) {
                    u--;
                    break;
                } else if (x == ladder_positions[l]) {
                    u--;
                    break;
                }

                l++;
            }
            snake_positions[u] = x;
            u++;
        }

        for (int i = 2; i < field_amount + 1; i++) {
            Field f;
            int controlf = 0;
            for (int h = 0; h < snake_amount; h++) {
                if (ladder_positions[h] == i) {
                    f = new LadderField(i);
                    controlf = 1;
                    fields.add(f);
                } else if (snake_positions[h] == i) {
                    f = new SnakeField(i);
                    controlf = 1;
                    fields.add(f);
                }
            }

            if (controlf == 0) {
                f = new NormalField(i);
                fields.add(f);
            }

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
        System.out.println(player.get(turn % number).getName() + " wins!");

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

