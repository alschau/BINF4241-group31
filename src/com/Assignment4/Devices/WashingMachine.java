package com.Assignment4.Devices;

public class WashingMachine {
    public WashingMachine(){}

    public void on(){
        System.out.println("Turning washing machine on.");
    }

    public void temp(int t){
        System.out.println("Setting washing machine temperature to "+t+" degrees.");
    }

    public void program(String program){
        System.out.println("Setting washing machine program to "+program+".");
    }

    public void timer(){
        //Automatically depending on the current program!!
        System.out.println(":)");
    }

    public void stop(){
        System.out.println("Stop washing machine");
    }

    public void off(){
        System.out.println("Turning washing machine off.");
    }
}
