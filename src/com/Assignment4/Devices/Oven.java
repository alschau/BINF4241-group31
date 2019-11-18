package com.Assignment4.Devices;

public class Oven {

    public Oven(){
    }

    public void on(){
        System.out.println("Turning oven on.");
    }

    public void timer(int t){
        System.out.println("Setting oven timer to "+t+" minutes.");
    }

    public void temp(int t){
        System.out.println("Setting oven temperature to "+t+" degrees.");
    }

    public void program(String program){
        System.out.println("Setting oven program to "+program+".");
    }

    public void start(){
        //only if parameters are set
        System.out.println("Starting oven!");
    }

    public void check_timer(){
        //only if oven is running
        System.out.println("Checking timer for Oven...");
    }

    public void interrupt(){
        //only if oven is in operation
        System.out.println("Stops current program");
    }

    public void off(){
        System.out.println("Turning oven off.");
    }
}
