package com.Assignment5.Part3.uno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game {
    ArrayList<player> players;
    drawstack drawstack;
    middlestack middlestack;
    Boolean uno = false;
    player current_player;
    Scanner scanner = new Scanner(System.in);
    Boolean has_plus= false;
    Boolean top_card_plus = false;

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




        int turncounter = 0;
        Boolean turn_possible = false;
        Boolean already_drew_card = false;
        card input_card = null;
        String input_sign;
        String input_color;
        int draw = 0;

        middlestack.setTopcard(drawstack.get_card(drawstack.getsize()-1));
        drawstack.remove_card(drawstack.getsize()-1);

        //first card is actioncard

        if(middlestack.getTopcard().getSign().equals("+")){
            draw+=2;
        }
        if(middlestack.getTopcard().getSign().equals("r")){
            Collections.reverse(players);
        }
        if(middlestack.getTopcard().getSign().equals("s")){
            turncounter++;
        }



        gameloop:
        while(true){
            turn_possible = false;
            middlestack.print_topcard();
            current_player = players.get(turncounter%players.size());
            current_player.printhand();





            if(draw !=0){
                System.out.println( current_player.getName() + " needs to draw " + draw +" cards and his turn ends");
                for(int i=0;i<draw;i++){
                    drawcard(current_player,drawstack);
                }
                draw = 0;
                turncounter++;
                continue gameloop;
            }




            for(card temp1:current_player.handcards){

                //check if a move is possible
                if(middlestack.getTopcard().getColor().equals(temp1.getColor()) || middlestack.getTopcard().getSign().equals(temp1.getSign()) || temp1.getSign().equals("w") || temp1.getSign().equals("-")){
                    turn_possible = true;
                    break;
                }
            }
            if(!turn_possible){
                if(already_drew_card){
                    System.out.println("there is still no possible turn for you, go next");
                    turncounter++;
                    already_drew_card= false;
                    continue gameloop;
                }
                System.out.println("theres no possible turn for you, draw a card");
                drawcard(current_player,drawstack);
                already_drew_card = true;
                continue gameloop;

            }




            //get input card
            System.out.println("its your turn, " + current_player.getName() +", select a card from your hand above: (type *skip* to skip your turn)");
            String input = scanner.nextLine();
            if(input.equals("skip")){
                drawcard(current_player,drawstack);
                turncounter++;
                continue gameloop;
            }




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
                        drawcard(current_player,drawstack);
                        turncounter++;
                        continue gameloop;
                    }
                }



                // check if card can be placed on middlestack
                input_sign = String.valueOf(input.charAt(0));
                input_color = String.valueOf(input.charAt(1));

                if(middlestack.getTopcard().getColor().equals(input_color) || middlestack.getTopcard().getSign().equals(input_sign) || input_sign.equals("w") || input_sign.equals("-")){

                    //wish a color if w or -
                    if(input_sign.equals("w") ||input_sign.equals("-")){
                        while(true){
                            System.out.println("choose a color of your liking(r,o,b,g) : ");
                            String wish = scanner.nextLine();
                            if(wish.equals("r") ||wish.equals("o") ||wish.equals("b") ||wish.equals("g")){
                                input_card.setColor(wish);
                                break;
                            }else{
                                System.out.println("thats not a color....");
                            }
                        }

                        //check if illegal for -
                        if(input_sign.equals("-")){
                            Boolean illegal = false;
                            for(card temp2:current_player.handcards){
                                if(temp2.getColor().equals(middlestack.getTopcard().getColor())){
                                    illegal = true;
                                }
                            }
                            if(illegal){
                                System.out.println("stop, youve violated the law. Draw four cards or serve your sentence. Your turn is now forfeit");
                                drawcard(current_player,drawstack);
                                drawcard(current_player,drawstack);
                                drawcard(current_player,drawstack);
                                drawcard(current_player,drawstack);
                                illegal = false;
                            }else{
                                draw+=4;
                            }

                        }

                    }
                    middlestack.setTopcard(input_card);
                    current_player.remove_from_hand(input_card);
                    if(current_player.handcards.size() == 0){
                        System.out.println("congrats you won," + current_player.getName());
                        break gameloop;
                    }
                    break turnloop;
                }else{
                    System.out.println("sorry this card doesnt fit on the stack, choose another one (type *skip* to skip your turn): ");
                    input= scanner.nextLine();
                    if(input.equals("skip")){
                        drawcard(current_player,drawstack);
                        turncounter++;
                        continue gameloop;
                    }

                }
            }

            //check for possible effects of cards


            if(input_sign.equals("s")){
                System.out.println("skipcard played");
                turncounter++;
            }
            if(input_sign.equals("+")){
                draw+=2;
            }
            if(input_sign.equals("r")){
                Collections.reverse(players);
                turncounter= players.indexOf(current_player);
            }


            turncounter++;
        }
    }



    public void drawcard(player player, drawstack drawstack){
        player.add_to_hand(drawstack.get_card(drawstack.getsize()-1));
        drawstack.remove_card(drawstack.getsize()-1);
    }

}
