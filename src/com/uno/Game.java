package com.uno;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    ArrayList<player> players;
    drawstack drawstack;
    middlestack middlestack;
    Boolean uno = false;
    player current_player;
    Scanner scanner = new Scanner(System.in);

    public Game(ArrayList<player> players){
        this.players = players;
        this.drawstack = new drawstack();
        this.middlestack = new middlestack();
    }



    public void start(){
        Random random = new Random();
        int bound = 108;

        //players draw cards
        for(player temp: players){
            for(int i = 0; i<7;i++){
                int r = random.nextInt(bound);
                bound--;
                temp.handcards.add(drawstack.get_card(r));
                drawstack.getStack().remove(r);
            }
        }


        middlestack.setTopcard(drawstack.get_card(drawstack.getsize()-1));
        drawstack.remove_card(drawstack.getsize()-1);

        int turncounter = 0;
        while(!uno){

            middlestack.print_topcard();
            current_player = players.get(turncounter%players.size());
            current_player.printhand();
            System.out.println("its your turn, " + current_player.getName() +", select a card from your hand above: (type *skip* to skip your turn)");
            String input = scanner.nextLine();
            if(input.equals("skip")){
                turncounter++;
                continue;
            }

            Boolean valid_input = false;
            card input_card = null;

            turnloop:
            while(true){

                //check if card is in hand
                checkloop:
                while (true) {
                    for(card temp:current_player.handcards){
                        if(temp.getRepr().equals(input)){
                            input_card = temp;
                            break checkloop;
                        }
                    }

                    System.out.println("sorry this card is not in your hand, please choose another one (type *skip* to skip your turn): ");
                    input = scanner.nextLine();
                    if(input.equals("skip")){
                        break turnloop;
                    }
                }

                // check if card can be placed on middlestack
                String input_sign = String.valueOf(input.charAt(0));
                String input_color = String.valueOf(input.charAt(1));

                if(middlestack.getTopcard().getColor().equals(input_color) || middlestack.getTopcard().getSign().equals(input_sign)){
                    middlestack.setTopcard(input_card);
                    current_player.remove_from_hand(input_card);
                    break turnloop;
                }else{
                    System.out.println("sorry this card doesnt fit on the stack, choose another one (type *skip* to skip your turn): ");
                    input= scanner.nextLine();
                    if(input.equals("skip")){
                        break turnloop;
                    }
                }
            }
            turncounter++;












        }


    }
}
