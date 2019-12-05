package com.Assignment5.Part1.company.SnakesandLadder.SnakesandLadders;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Dice dice = new Dice();
        ArrayList<Player> player = new ArrayList<>();
        ArrayList<Field> fields = new ArrayList<>();

        Scanner scanner= new Scanner(System.in);
        int number;
        while(true) {
            try {
                System.out.println("How many players? ");
                number = Integer.parseInt(scanner.nextLine());
                if(number<2 || number>4){
                    System.out.println("This game is only for 2-4 players, please try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format. Could you please input an integer number?");
            }
        }

        int field_amount;
        while(true) {
            try {
                System.out.println("How many Fields (>= 10)? ");
                field_amount = Integer.parseInt(scanner.nextLine());
                if(field_amount<10){
                    System.out.println("The fields need to be greater than 10. Please try again.");
                    continue;
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format. Could you please input an integer number?");
            }
        }

        int start = 1;

        int obj_amount = Math.round(field_amount/4);
        ArrayList<Integer> randoms = new ArrayList<>();
        Random rend = new Random();

        for (int i = 0; i < obj_amount;i++){
            int r = rend.nextInt(field_amount - 8) + 4;
            if (randoms.contains(r)){
                i--;
            }
            randoms.add(r);
        }

        Field starter_field = new NormalField(1);
        fields.add(starter_field);


        for (int i=2; i< field_amount+1; i++) {
            Field f;
            if(randoms.contains(i)){
                if((i%2)==0){
                    f = new LadderField(i);
                }
                else {
                    f = new SnakeField(i);
                }
            }
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
                while(true) {
                    if (current_player.getField() instanceof LadderField) {
                        current_player.getField().removePlayer(current_player);
                        System.out.println("Congratulations, you can climb a ladder here");
                        current_player.setField(fields.get(current_player.getField().getTarget() - 1));
                        current_player.getField().setPlayer(current_player);
                        System.out.println("you are now on Field " + Integer.toString(current_player.getField().getNumber()));
                    } else if (current_player.getField() instanceof SnakeField) {
                        current_player.getField().removePlayer(current_player);
                        System.out.println("Woopsie, down you go");
                        current_player.setField(fields.get(current_player.getField().getTarget() - 1));
                        current_player.getField().setPlayer(current_player);
                        System.out.println("you are now on Field " + Integer.toString(current_player.getField().getNumber()));
                    }
                    if (!(current_player.getField() instanceof LadderField) && !(current_player.getField() instanceof SnakeField)){
                        break;
                    }

                }

                turn++;
            } else if (current_player.getField().getNumber() + roll == field_amount){
                current_player.getField().removePlayer(current_player);
                current_player.setField(fields.get(current_player.getField().getNumber() + roll -1));
                current_player.getField().setPlayer(current_player);
                winner = current_player;
                break;
            } else if (current_player.getField().getNumber() + roll > field_amount){
                current_player.getField().removePlayer(current_player);
                current_player.setField(fields.get(field_amount - (roll - (field_amount - current_player.getField().getNumber()))-1));
                current_player.getField().setPlayer(current_player);

                while(true) {
                    if (current_player.getField() instanceof LadderField) {
                        current_player.getField().removePlayer(current_player);
                        System.out.println("Congratulations, you can climb a ladder here");
                        current_player.setField(fields.get(current_player.getField().getTarget() - 1));
                        current_player.getField().setPlayer(current_player);
                        System.out.println("you are now on Field " + Integer.toString(current_player.getField().getNumber()));
                    } else if (current_player.getField() instanceof SnakeField) {
                        current_player.getField().removePlayer(current_player);
                        System.out.println("Woopsie, down you go");
                        current_player.setField(fields.get(current_player.getField().getTarget() - 1));
                        current_player.getField().setPlayer(current_player);
                        System.out.println("you are now on Field " + Integer.toString(current_player.getField().getNumber()));
                    }
                    if (!(current_player.getField() instanceof LadderField) && !(current_player.getField() instanceof SnakeField)){
                        break;
                    }
                    System.out.println(output(fields));
                }
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

