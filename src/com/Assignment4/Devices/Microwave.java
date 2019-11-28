package com.Assignment4.Devices;


import com.Assignment4.Commands.Microwave.*;
import com.Assignment4.MyThread;
import com.Assignment4.Phone;

public class Microwave extends Devices {
    public boolean on = false;
    public boolean running = false;
    public MyThread my_micro_thread;
    public Thread micro_thread;
    private int temp;

    public Microwave(){}

    public void on(){
        if(!on){
            this.on = true;
            System.out.println("Turning Microwave on.");
        }
        else {
            System.out.println("already on");
        }

    }

    public void timer(int t){
        if(on){
            this.my_micro_thread = new MyThread(t*1000);
            System.out.println("Setting microwave timer to "+t+" seconds.");
        } else {
            System.out.println("not on");
        }

    }

    public void temp(int t){
        if(on){
            temp = t;
            System.out.println("Setting microwave temperature to "+t+" degrees.");
        } else {
            System.out.println("not on");
        }
    }


    public void start(){
        if(on && my_micro_thread !=null&& temp != 0){
            this.running = true;
            System.out.println("Starting Microwave!");
            this.micro_thread = new Thread(my_micro_thread, "MicroThread");
            micro_thread.start();

        } else {
            System.out.println("before starting you must add all other parameters");
        }

    }

    public void check_timer(){
        if(running){
            System.out.println(my_micro_thread.getTime());
        } else  {
            System.out.println("Microwave not running.");
        }

    }

    public void interrupt(){
        if(running){
            this.running = false;
            my_micro_thread.setTime(0);
            System.out.println("Stop current Microwave program");
        } else {
            System.out.println("You can't interrupt if its not running");
        }

    }

    public void off(){
        //TODO reset states
        if(!running) {
            this.on = false;
            System.out.println("Turning microwave off.");
        }
    }

    public void menu(Phone p){
        String command2 = "";
        while(!command2.equals("exit")) {
            if (!on) {
                System.out.println("on, exit");
                command2 = scanner.nextLine();

                if (command2.equals("on")) {
                    on = true;
                    MicrowaveCommandOn dishwasher_on = new MicrowaveCommandOn(this);
                    p.setCommand(dishwasher_on);
                }
                else if (command2.equals("exit")) {
                    break;
                }
                else {
                    System.out.println("Please enter a valid command");
                    continue;
                }
            }
            System.out.println("on, timer, temp, start, check, interrupt, off, exit");
            command2 = scanner.nextLine();
            if (command2.equals("on")) {
                MicrowaveCommandOn microwave_on = new MicrowaveCommandOn(this);
                p.setCommand(microwave_on);
            } else if (command2.equals("timer")) {
                System.out.println("How long? enter in seconds: ");
                String command3 = scanner.nextLine();
                MicrowaveCommandTimer microwave_timer = new MicrowaveCommandTimer(this, Integer.parseInt(command3));
                p.setCommand(microwave_timer);
            } else if (command2.equals("temp")) {
                System.out.println("Enter temperature: ");
                String command3 = scanner.nextLine();
                MicrowaveCommandTemp microwave_temp = new MicrowaveCommandTemp(this, Integer.parseInt(command3));
                p.setCommand(microwave_temp);
            } else if (command2.equals("start")) {
                MicrowaveCommandStart microwave_start = new MicrowaveCommandStart(this);
                p.setCommand(microwave_start);
            } else if (command2.equals("check")) {
                MicrowaveCommandCheck microwave_check = new MicrowaveCommandCheck(this);
                p.setCommand(microwave_check);
            } else if (command2.equals("interrupt")) {
                MicrowaveCommandInterrupt microwave_interrupt = new MicrowaveCommandInterrupt(this);
                p.setCommand(microwave_interrupt);
            } else if (command2.equals("off")) {
                MicrowaveCommandOff microwave_off = new MicrowaveCommandOff(this);
                p.setCommand(microwave_off);
            } else if (command2.equals("exit")){
                break;
            } else {
                System.out.println("Please enter a valid command");
            }
            p.pressButton();
        }
    }
}
