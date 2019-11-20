package com.Assignment4.Devices;

import com.Assignment4.Commands.WashingMachine.*;
import com.Assignment4.MyThread;
import com.Assignment4.Phone;

import java.util.Arrays;
import java.util.List;

public class WashingMachine extends Devices {
    private Boolean on = false;
    private String program;
    private MyThread my_washing_thread;
    private Thread washing_thread;
    private int temperature;

    public WashingMachine(){}

    public void on(){
        if(!on){
            this.on = true;
            System.out.println("Turning washing machine on.");
        } else {
            System.out.println("already on");
        }
    }

    public void temp(int t){
        if(on){
            this.temperature = t;
            System.out.println("Setting washing machine temperature to "+t+" degrees.");
        } else {
            System.out.println("not on");
        }
    }

    public void program(String program){
        List<String> programs = Arrays.asList("double rinse", "intense", "quick", "spin");
        List<Integer> times = Arrays.asList(40, 60, 15, 30);
        if(on){
            if(my_washing_thread==null || !my_washing_thread.isRunning()){
                if(programs.contains(program.toLowerCase())){
                    this.program = program;
                    System.out.println("Setting washing machine program to "+program+".");

                    // Auto Start after selecting program
                    int i =programs.indexOf(program);
                    int time = times.get(i);
                    this.my_washing_thread = new MyThread(time*1000);
                    this.washing_thread = new Thread(my_washing_thread, "WashingThread");
                    washing_thread.start();
                }else{
                    System.out.println("sorry, the washing machine does not support this program, try another one");
                }
            } else {
                System.out.println("Washing machine is already running!");
            }

        } else {
            System.out.println("Hmmm, very suspicious owo. The washing machine doesnt seem to be responding. Come again later. Try switching it on first:");
        }
    }

    public void timer(){
        if(my_washing_thread.isRunning()){
            System.out.println(my_washing_thread.getTime());
        } else  {
            System.out.println("Washing machine not running.");
        }
    }

    public void stop(){
        if(my_washing_thread.isRunning()){
            System.out.println("The washing machine is still running and will automatically turn off when finished.");
        } else {
            System.out.println("You cant stop the washing machine because its not running.");
        }
    }

    public void off(){
        if(on){
            if(my_washing_thread.isRunning()) {
                my_washing_thread.setTime(0);
            }
            this.on = false;
            this.program = null;
            System.out.println("Turning washing machine off.");
        }else{
            System.out.println("nothing seems to be happening");
        }
    }

    public void menu(Phone p) {
        String command2 = "";
        while (!command2.equals("exit")) {
            System.out.println("on, temp, program, stop, off, exit");
            command2 = scanner.nextLine();
            if (command2.equals("on")) {
                WashingMachineCommandOn washing_on = new WashingMachineCommandOn(this);
                p.setCommand(washing_on);
            } else if (command2.equals("temp")) {
                System.out.println("Enter temperature: ");
                String command3 = scanner.nextLine();
                WashingMachineCommandTemp washing_temp = new WashingMachineCommandTemp(this, Integer.parseInt(command3));
                p.setCommand(washing_temp);
            } else if (command2.equals("program")) {
                System.out.println("Enter program: ");
                String command3 = scanner.nextLine();
                WashingMachineCommandProgram washing_program = new WashingMachineCommandProgram(this, command3);
                p.setCommand(washing_program);
            } else if (command2.equals("timer")) {
                WashingMachineCommandTimer washing_timer = new WashingMachineCommandTimer(this);
                p.setCommand(washing_timer);
            } else if (command2.equals("stop")) {
                WashingMachineCommandStop washing_stop = new WashingMachineCommandStop(this);
                p.setCommand(washing_stop);
            } else if (command2.equals("off")) {
                WashingMachineCommandOff washing_off = new WashingMachineCommandOff(this);
                p.setCommand(washing_off);
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
