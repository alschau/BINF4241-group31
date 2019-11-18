package com.Assignment4.Devices;

public class Dishwasher {
    public Dishwasher(){}

    public void timer(int t){
        System.out.println("Setting cleaning robot timer to "+t+" seconds.");
    }

    public void auto_return_time(){
        System.out.println("Going back to base when time expires");
    }

    public void start(){
        System.out.println("Starting cleaning robot!");
    }

    public void check_cleaning(){
        System.out.println("Check cleaning percentage of cleaning robot");
    }

    public void check_battery(){
        System.out.println("Check battery of cleaning robot");
    }

    public void check_time(){
        System.out.println("Check timer for cleaning robot...");
    }

    public void complete_cleaning(){
        System.out.println("Cleaning robot completes outstanding cleaning");
    }

    public void end_cleaning(){
        System.out.println("Cleaning robot end cleaning and returns to base");
    }

}
