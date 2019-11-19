package com.Assignment4.Devices;

import com.Assignment4.Commands.Oven.*;
import com.Assignment4.MyThread;
import com.Assignment4.Phone;

public class Oven extends Devices{
    public Boolean on = false;
    public Boolean running = false;
    public String program;
    public MyThread my_oven_thread;
    public Thread oven_thread;


    public Oven(){
    }

    public void on(){
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
        if(on && program!= null && my_oven_thread !=null){
            this.running = true;
            System.out.println("Starting oven!");
            this.oven_thread = new Thread(my_oven_thread, "OvenThread");
            oven_thread.start();

        } else {
            System.out.println("before starting you must add all other parameters");
        }

    }

    public void check_timer(){
        if(running){
            System.out.println(my_oven_thread.getTime());
        } else  {
            System.out.println("Oven not running.");
        }

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

    public void menu(Phone p){
        String command2 = "";
        while(!command2.equals("exit")) {
            System.out.println("on, timer, temp, program, start, check, interrupt, off, exit");
            command2 = scanner.nextLine();
            if (command2.equals("on")) {
                OvenCommandOn oven_on = new OvenCommandOn(this);
                p.setCommand(oven_on);
            } else if (command2.equals("timer")) {
                System.out.println("How long? enter in seconds: ");
                String command3 = scanner.nextLine();
                OvenCommandTimer oven_timer = new OvenCommandTimer(this, Integer.parseInt(command3));
                p.setCommand(oven_timer);
            } else if (command2.equals("temp")) {
                System.out.println("Enter temperature: ");
                String command3 = scanner.nextLine();
                OvenCommandTemp oven_temp = new OvenCommandTemp(this, Integer.parseInt(command3));
                p.setCommand(oven_temp);
            } else if (command2.equals("program")) {
                System.out.println("Enter program: ");
                String command3 = scanner.nextLine();
                OvenCommandProgram oven_program = new OvenCommandProgram(this, command3);
                p.setCommand(oven_program);
            } else if (command2.equals("start")) {
                OvenCommandStart oven_start = new OvenCommandStart(this);
                p.setCommand(oven_start);
            } else if (command2.equals("check")) {
                OvenCommandCheck oven_check = new OvenCommandCheck(this);
                p.setCommand(oven_check);
            } else if (command2.equals("interrupt")) {
                OvenCommandInterrupt oven_interrupt = new OvenCommandInterrupt(this);
                p.setCommand(oven_interrupt);
            } else if (command2.equals("off")) {
                OvenCommandOff oven_off = new OvenCommandOff(this);
                p.setCommand(oven_off);
            } else if (command2.equals("exit")) {
                break;
            } else {
                System.out.println("Please enter a valid command");
            }
            p.pressButton();
        }
    }

}
