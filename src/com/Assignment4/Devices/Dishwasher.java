package com.Assignment4.Devices;
import com.Assignment4.Commands.Dishwasher.*;
import com.Assignment4.Devices.Devices;
import com.Assignment4.MyThread;
import com.Assignment4.Phone;

public class Dishwasher extends Devices {
    public Dishwasher(){}
    public boolean on = false;
    public boolean running = false;
    public String program = "null";
    public MyThread my_dishwasher_thread;
    public Thread dishwasher_thread;

    public void on(){
        if(!on){
            this.on = true;
            System.out.println("Turning dishwasher on.");
        }
        /*else {
            System.out.println("already on");
        } */
    }

    public void start(){
        if(on && program!= null && program!= "null"){
            this.running = true;
            System.out.println("Starting dishwasher!");
            if(my_dishwasher_thread==null){
                my_dishwasher_thread = new MyThread(0);
            }
            this.dishwasher_thread = new Thread(my_dishwasher_thread, "DishwasherThread");
            dishwasher_thread.start();
            program = "null";

        }
        else if (program.equals("null") || !(program.equals("glasses") || program.equals("plates") || program.equals("pans")  || program.equals("mixed"))){
            System.out.println("Choose a program first!");
        }
        else {
            System.out.println("Please turn the dishwasher on first.");
        }
    }

    public void program(String program){
        while (true) {
            if (program.equals("glasses")){
                timer(6, program);
                break;
            }
            else if (program.equals("plates")) {
                timer(12, program);
                break;
            }
            else if (program.equals("pans")) {
                timer(18, program);
                break;
            }
            else if (program.equals("mixed")) {
                timer(30, program);
                break;
            }
            else if (program.equals("exit")) {
                break;
            }
            System.out.println("Please enter a valid program: glasses, plates, pans, mixed");
            program = scanner.nextLine();
    }
        if (!program.equals("exit")) {
            this.program = program;
        }

    }


    public void check_timer(){
        if(running){
            System.out.println(my_dishwasher_thread.getTime());
        }
        else if (program.equals("null"))  {
            System.out.println("No program chosen.");
        }
        else if (program.equals("glasses")){
            System.out.println("The glasses program will run for 6 seconds.");
        }
        else if (program.equals("plates")) {
            System.out.println("The plates program will run for 12 seconds.");
        }
        else if (program.equals("pans")) {
            System.out.println("The pans program will run for 18 seconds.");
        }
        else if (program.equals("mixed")) {
            System.out.println("The mixed program will run for 30 seconds.");
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
            this.program = "null";
        } else {
            System.out.println("You can't interrupt if it's not running");
        }
    }

    public void off(){
        if(!running && on) {
            this.on = false;
            System.out.println("Turning dishwasher off.");
        }
        else if (running) {
            System.out.println("Dishwasher is currently running, it might be damaged if turned off.");
        }
        else if (!running && !on) {
            System.out.println("Dishwasher is already turned off.");
        }
    }

    public void menu(Phone p){
        String command2 = "";
        while(!command2.equals("exit")) {
            //System.out.println(on);
            if (!on) {
                System.out.println("on, exit");
                command2 = scanner.nextLine();

                if (command2.equals("on")) {
                    on = true;
                    DishwasherCommandOn dishwasher_on = new DishwasherCommandOn(this);
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
            System.out.println("Make your choice: program, start, check stop, off, exit");
            command2 = scanner.nextLine();
            if (command2.equals("program")) {
                System.out.println("Enter program or type exit: glasses, plates, pans, mixed");
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
                continue;
            }
            p.pressButton();
        }
    }



}
