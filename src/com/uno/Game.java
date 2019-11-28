package com.uno;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    ArrayList<player> players;
    drawstack drawstack;
    middlestack middlestack;
    Boolean uno = false;
    player current_player;

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
        while(!uno){
            current_player = players.get(turncounter%players.size());
            System.out.println("its your turn" + current_player.);



        }

        players.get(0).printhand();

    }
}
