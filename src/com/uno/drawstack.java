package com.uno;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class drawstack implements stack{
    ArrayList<card> stack = new ArrayList<card>();

    public drawstack(){

        //fill stack with every card
        for(int i = 0; i < 56; i++){
            String a = Integer.toString(i % 14);

            //skip, reverse, +2 and +4 card
            if(a.equals(Integer.toString(10))){
                a = "s";
            }else if(a.equals(Integer.toString(11))){
                a = "r";
            }else if(a.equals(Integer.toString(12))){
                a = "+";
            }else if(a.equals(Integer.toString(13))){
                a = "-";
            }



            card x = new card(null,a);
            stack.add(x);

            if(!a.equals(Integer.toString(0))){
                card y = new card(null, a);
                stack.add(y);
            }

        }


        //colors
        for(int i = 0; i<27;i++){
            stack.get(i).setColor("r");
        }
        for(int i = 27; i<54;i++){
            stack.get(i).setColor("o");
        }
        for(int i = 54; i<81;i++){
            stack.get(i).setColor("g");
        }
        for(int i = 81; i<108;i++){
            stack.get(i).setColor("b");
        }
        //wish card
        stack.get(26).setSign("w");
        stack.get(53).setSign("w");
        stack.get(80).setSign("w");
        stack.get(107).setSign("w");

        Collections.shuffle(stack);

    }

    public card get_card(int i){
        return stack.get(i);
    }

    public ArrayList<card> getStack() {
        return stack;
    }
    public int getsize(){
        return stack.size();
    }
    public void remove_card(int i){
        stack.remove(i);
    }
}
