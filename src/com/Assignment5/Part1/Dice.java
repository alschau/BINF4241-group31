package com.Assignment5.Part1;

import java.util.Random;


public class Dice {

    public int roll(){
        Random rand = new Random();
        return(rand.nextInt(6) + 1);
    }
}