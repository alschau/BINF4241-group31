package com.Assignment4.Devices;

import com.Assignment4.MyThread;

public class Oven extends Devices{
    public Boolean on = false;
    public Boolean running = false;
    public String program;
    public MyThread my_oven_thread;
    public Thread oven_thread;


    public Oven(){
    }

    public void on(){
        //TODO if oven on already
        if(!on){
            this.on = true;
            System.out.println("Turning oven on.");
        } else {
            System.out.println("already on");
        }

    }

    public void timer(int t){
        if(on){
            this.my_oven_thread = new MyThread(t*1000);
            System.out.println("Setting oven timer to "+t+" seconds.");
        } else {
            System.out.println("not on");
        }

    }

    public void temp(int t){
        if(on){
            System.out.println("Setting oven temperature to "+t+" degrees.");
        } else {
            System.out.println("not on");
        }
    }

    public void program(String program){
        //TODO check if program is valid program (ventilated, grill, etc)
        if(on){
            this.program = program;
            System.out.println("Setting oven program to "+program+".");
        } else {
            System.out.println("Hmmm, very suspicious owo. The oven doesnt seem to be responding. Come again later. Try switching it on first:");
        }

    }

    public void start(){
        if(on && program!= null){
            this.running = true;
            System.out.println("Starting oven!");
            if(my_oven_thread==null){
                my_oven_thread = new MyThread();
            }
            this.oven_thread = new Thread(my_oven_thread, "OvenThread");
            oven_thread.start();

        } else {
            System.out.println("Choose a program first!");
        }

    }

    public void check_timer(){
        if(running){
            System.out.println(my_oven_thread.getTime());
        }
        System.out.println("Checking timer for oven...");
    }

    public void interrupt(){
        if(running){
            this.running = false;
            my_oven_thread.setTime(0);
            System.out.println("Stop current oven program");
        } else {
            System.out.println("You can't interrupt if its not running");
        }

    }

    public void off(){
        //TODO reset states
        if(!running) {
            this.on = false;
            System.out.println("Turning oven off.");
        }
    }
}
