package com.Assignment4.Devices;

public class Dishwasher extends Devices{
    public Dishwasher(){}

    public void on(){
        System.out.println("Turning dishwasher on.");
    }

    public void start(){
        //only if parameters are set
        System.out.println("Starting dishwasher!");
    }

    public void program(String program){
        System.out.println("Setting dishwasher program to "+program+".");
    }

    public void timer(){
        //Automatically depending on the current program!!
        System.out.println(":)");
    }

    public void check_timer(){
        //only if dishwasher is running
        System.out.println("Checking timer for dishwasher...");
    }

    public void stop(){
        //only if microwave is in operation
        System.out.println("Stop current dishwasher program");
    }

    public void off(){
        System.out.println("Turning dishwasher off.");
    }



}
