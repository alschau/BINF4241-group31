package com.uno;

import java.util.ArrayList;

public class drawstack {
    ArrayList<card> stack = new ArrayList<card>();

    public drawstack(){

        //fill stack with every card
        for(int i = 0; i < 56; i++){
            String a = Integer.toString(i % 14);

            if(a.equals(Integer.toString(10))){
                a = "stop";
            }else if(a.equals(Integer.toString(11))){
                a = "reverse";
            }else if(a.equals(Integer.toString(12))){
                a = "+2";
            }else if(a.equals(Integer.toString(13))){
                a = "+4";
            }



            card x = new card(null,a);
            stack.add(x);

            if(!a.equals(Integer.toString(0))){
                card y = new card(null, a);
                stack.add(y);
            }

        }

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

        stack.get(26).setSign("wish");
        stack.get(53).setSign("wish");
        stack.get(80).setSign("wish");
        stack.get(107).setSign("wish");

    }

    public card get_card(int i){
        return stack.get(i);
    }

    public ArrayList<card> getStack() {
        return stack;
    }
}
