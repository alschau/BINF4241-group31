package com.Assignment4.Devices;

import com.Assignment4.Commands.Oven.*;
import com.Assignment4.MyThread;
import com.Assignment4.Phone;

import java.util.Arrays;
import java.util.List;

public class Oven extends Devices{
    public boolean on = false;
    public boolean running = false;
    public String program;
    public MyThread my_oven_thread;
    public Thread oven_thread;
    private int temp;
    private int timer;


    public Oven(){
    }

    public void on(){
        this.on = true;
        System.out.println("Turning oven on.");
    }

    public void timer(int t){
        System.out.println("Setting oven timer to "+t+" seconds.");
        this.timer = t;
    }

    public void temp(int t){
        this.temp = t;
        System.out.println("Setting oven temperature to "+t+" degrees.");
    }

    public void program(String program){
        this.program = program;
        System.out.println("Program set to "+program+".");
    }

    public void start(){

        if(temp!=0 && timer!= 0 && program!=null){
            if(my_oven_thread==null) {
                // thread not init
                this.my_oven_thread = new MyThread(timer*1000);
                this.oven_thread = new Thread(my_oven_thread, "OvenThread");
            }

            if(!my_oven_thread.isRunning()){

                System.out.println("Starting oven!");
                oven_thread.start();
            }else{
                System.out.println("you started the oven already");
            }
        }else{
            System.out.println("you need to set all parameters first");
        }

    }

    public void check_timer(){
        if(oven_thread!=null){
            System.out.println(my_oven_thread.getTime());
        }else{
            System.out.println("not running");
        }

    }

    public void interrupt(){
        my_oven_thread.setTime(0);
        System.out.println("Stop current oven program");
    }

    public void off(){

        if(oven_thread!=null){
            my_oven_thread.setTime(0);
        }


        System.out.println("interrupting current program.");

        this.on = false;
        System.out.println("Turning oven off.");
    }

    public void menu(Phone p){
        String command2 = "";
        while(!command2.equals("exit")) {
            if (!on) {
                System.out.println("on, exit");
                command2 = scanner.nextLine();

                if (command2.equals("on")) {
                    on = true;
                    OvenCommandOn oven_on = new OvenCommandOn(this);
                    p.setCommand(oven_on);
                }

                else if (command2.equals("exit")) {
                    break;
                }

                else {
                    System.out.println("Please enter a valid command");
                    continue;
                }
                p.pressButton();
                continue;
            }
            System.out.println("timer, temp, program, start, check, interrupt, off, exit");
            command2 = scanner.nextLine();

            if (command2.equals("timer")) {
                System.out.println("How long? enter in seconds: ");
                String command3 = scanner.nextLine();
                OvenCommandTimer oven_timer = new OvenCommandTimer(this, Integer.parseInt(command3));
                p.setCommand(oven_timer);

            }

            else if (command2.equals("temp")) {
                System.out.println("Enter temperature: ");
                String command3 = scanner.nextLine();
                OvenCommandTemp oven_temp = new OvenCommandTemp(this, Integer.parseInt(command3));
                p.setCommand(oven_temp);

            }
            else if (command2.equals("program")) {
                System.out.println("Select a program: \nValid options: fan, grilled, ventilated, plate warming");
                List<String> programs = Arrays.asList("fan", "grilled", "ventilated", "plate warming");
                String command3 = scanner.nextLine();
                if (programs.contains(command3.toLowerCase())){
                    OvenCommandProgram oven_program = new OvenCommandProgram(this, command3);
                    p.setCommand(oven_program);
                } else {
                    System.out.println("The oven doesn't support this program.");
                }

            }

            else if (command2.equals("start")) {
                OvenCommandStart oven_start = new OvenCommandStart(this);
                p.setCommand(oven_start);


            } else if (command2.equals("check")) {
                OvenCommandCheck oven_check = new OvenCommandCheck(this);
                p.setCommand(oven_check);

            }

            else if (command2.equals("interrupt")) {
                if(my_oven_thread != null){
                    OvenCommandInterrupt oven_interrupt = new OvenCommandInterrupt(this);
                    p.setCommand(oven_interrupt);
                } else {
                    System.out.println("The oven isn't running.");
                }
            }

            else if (command2.equals("off")) {

                OvenCommandOff oven_off = new OvenCommandOff(this);
                p.setCommand(oven_off);

                // Reset device states
                this.timer = 0;
                this.temp = 0;
                this.program = null;
                my_oven_thread = null;
            }

            else if (command2.equals("exit")) {
                break;
            }

            else {
                System.out.println("Please enter a valid command");
                continue;
            }
            p.pressButton();
        }
    }

}
