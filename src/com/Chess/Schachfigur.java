package com.Chess;

public abstract class Schachfigur {
    int alive; //if it still exists or not
    String color;

   public void which_color(int player) {
       if (player == 1) {
           this.color = "W";
       }
       else {
           this.color = "B";
       }
   }


}
