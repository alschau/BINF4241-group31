package com.Assignment4.Devices;

public class Microwave extends Devices {
    public Microwave(){}

    public void on(){
        System.out.println("Turning microwave on.");
    }

    public void timer(int t){
        System.out.println("Setting microwave timer to "+t+" seconds.");
    }

    public void temp(int t){
        System.out.println("Setting microwave temperature to "+t+" degrees.");
    }

    public void start(){
        //only if parameters are set
        System.out.println("Starting microwave!");
    }

    public void check_timer(){
        //only if microwave is running
        System.out.println("Checking timer for microwave...");
    }

    public void interrupt(){
        //only if microwave is in operation
        System.out.println("Stop current microwave program");
    }

    public void off(){
        System.out.println("Turning microwave off.");
    }
}
