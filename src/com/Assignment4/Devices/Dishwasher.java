package com.Assignment4.Devices;
import com.Assignment4.Commands.Dishwasher.*;
import com.Assignment4.Devices.Devices;
import com.Assignment4.MyThread;
import com.Assignment4.Phone;

public class Dishwasher extends Devices {
    public Dishwasher(){}
    public Boolean on = false;
    public Boolean running = false;
    public String program;
    public MyThread my_dishwasher_thread;
    public Thread dishwasher_thread;

    public void on(){
        if(!on){
            this.on = true;
            System.out.println("Turning dishwasher on.");
        } else {
            System.out.println("already on");
        }
    }

    public void start(){
        if(on && program!= null){
            this.running = true;
            System.out.println("Starting dishwasher!");
            if(my_dishwasher_thread==null){
                my_dishwasher_thread = new MyThread();
            }
            this.dishwasher_thread = new Thread(my_dishwasher_thread, "DishwasherThread");
            dishwasher_thread.start();

        } else {
            System.out.println("Choose a program first!");
        }
    }

    public void program(String program){
        this.program = program;
        if (this.program.equals("Glasses")){
            timer(60, program);
        }
        else if (this.program.equals("Plates")) {
            timer(60, program);
        }
        else if (this.program.equals("Pans")) {
            timer(60, program);
        }
        else if (this.program.equals("Mixed")) {
            timer(60, program);
        }
        System.out.println("Setting dishwasher program to "+program+".");
    }


    public void check_timer(){
        if(running){
            System.out.println(my_dishwasher_thread.getTime());
        } else  {
            System.out.println("Dishwasher not running.");
        }
    }

    public void timer(int t, String prog){
        this.my_dishwasher_thread = new MyThread(t*1000);
        System.out.println("The program "+prog+" will run " +t+" seconds.");

    }

    public void stop(){
        if(running){
            this.running = false;
            my_dishwasher_thread.setTime(0);
            System.out.println("Stop current dishwasher program");
        } else {
            System.out.println("You can't interrupt if it's not running");
        }
    }

    public void off(){
        if(!running) {
            this.on = false;
            System.out.println("Turning dishwasher off.");
        }
    }

    public void menu(Phone p){
        String command2 = "";
        while(!command2.equals("exit")) {
            System.out.println("on, timer, program, start, check, stop, off, exit");
            command2 = scanner.nextLine();
            if (command2.equals("on")) {
                DishwasherCommandOn dishwasher_on = new DishwasherCommandOn(this);
                p.setCommand(dishwasher_on);
            }
            else if (command2.equals("program")) {
                System.out.println("Enter program: Glasses, Plates, Pans, Mixed");
                String command3 = scanner.nextLine();
                DishwasherCommandProgram dishwasher_program = new DishwasherCommandProgram(this, command3);
                p.setCommand(dishwasher_program);

            } else if (command2.equals("start")) {
                DishwasherCommandStart dishwasher_start = new DishwasherCommandStart(this);
                p.setCommand(dishwasher_start);

            } else if (command2.equals("check")) {
                DishwasherCommandCheck dishwasher_check = new DishwasherCommandCheck(this);
                p.setCommand(dishwasher_check);

            } else if (command2.equals("stop")) {
                DishwasherCommandStop dishwasher_stop = new DishwasherCommandStop(this);
                p.setCommand(dishwasher_stop);

            } else if (command2.equals("off")) {
                DishwasherCommandOff dishwasher_off = new DishwasherCommandOff(this);
                p.setCommand(dishwasher_off);

            } else if (command2.equals("exit")) {
                break;

            } else {
                System.out.println("Please enter a valid command");
            }
            p.pressButton();
        }
    }



}
