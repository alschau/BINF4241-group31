package com.Assignment4;

import com.Assignment4.Commands.CleaningRobot.*;
import com.Assignment4.Commands.Dishwasher.*;
import com.Assignment4.Commands.Microwave.*;
import com.Assignment4.Commands.WashingMachine.*;
import com.Assignment4.Devices.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Phone p = new Phone();

        // INITIALIZING DEVICES
        Oven o = new Oven();
        Microwave m = new Microwave();
        Dishwasher d = new Dishwasher();
        WashingMachine w = new WashingMachine();
        CleaningRobot b = new CleaningRobot();

        // INITIALIZING COMMANDS OVEN
        // In Loop


        // INITIALIZING COMMANDS MICROWAVE



        // INITIALIZING COMMANDS DISHWASHER
        DishwasherCommandOn dishwasher_on = new DishwasherCommandOn(d);
        DishwasherCommandStart dishwasher_start = new DishwasherCommandStart(d);
        DishwasherCommandProgram dishwasher_program = new DishwasherCommandProgram(d,"MYPROGRAM_DISHWASHER");
        DishwasherCommandCheck dishwasher_check = new DishwasherCommandCheck(d);
        DishwasherCommandStop dishwasher_stop = new DishwasherCommandStop(d);
        DishwasherCommandOff dishwasher_off = new DishwasherCommandOff(d);

        // INITIALIZING COMMANDS WASHING MACHINE
        WashingMachineCommandOn washing_on = new WashingMachineCommandOn(w);
        WashingMachineCommandTemp washing_temp = new WashingMachineCommandTemp(w, 60);
        WashingMachineCommandProgram washing_program = new WashingMachineCommandProgram(w, "MYPROGRAM_WASHINGMACHINE");
        WashingMachineCommandStop washing_stop = new WashingMachineCommandStop(w);
        WashingMachineCommandOff washing_off = new WashingMachineCommandOff(w);

        // INITIALIZING COMMANDS CLEANING ROBOT
        CleaningRobotCommandTimer robot_timer = new CleaningRobotCommandTimer(b, 600);
        CleaningRobotCommandStart robot_start = new CleaningRobotCommandStart(b);
        CleaningRobotCommandCheckCleaning robot_check_cleaning = new CleaningRobotCommandCheckCleaning(b);
        CleaningRobotCommandCheckBattery robot_check_battery = new CleaningRobotCommandCheckBattery(b);
        CleaningRobotCommandCheckCharging robot_check_charging = new CleaningRobotCommandCheckCharging(b);
        CleaningRobotCommandComplete robot_complete = new CleaningRobotCommandComplete(b);
        CleaningRobotCommandEnd robot_end = new CleaningRobotCommandEnd(b);



        /*
        ArrayList<Devices> devices = new ArrayList<Devices>(Arrays.asList(o, m, d, w, b));
        ArrayList<Command> oven_commands = new ArrayList<Command>(Arrays.asList(oven_on, oven_timer, oven_temp, oven_program, oven_start, oven_check, oven_interrupt, oven_off));
        ArrayList<Command> microwave_commands = new ArrayList<Command>(Arrays.asList(microwave_on, microwave_timer, microwave_temp, microwave_start, microwave_check, microwave_interrupt, microwave_off));
        ArrayList<Command> dishwasher_commands = new ArrayList<Command>(Arrays.asList(dishwasher_on, dishwasher_start, dishwasher_program, dishwasher_check, dishwasher_stop, dishwasher_off));
        ArrayList<Command> washing_commands = new ArrayList<Command>(Arrays.asList(washing_on, washing_temp, washing_program, washing_stop, washing_off));
        ArrayList<Command> robot_commands = new ArrayList<Command>(Arrays.asList(robot_timer, robot_start, robot_check_cleaning, robot_check_battery,  robot_check_charging, robot_complete, robot_end));
        */


        while(true){
            System.out.println("Which Thread do you want to start?");
            System.out.println("Choice: oven, microwave, dishwasher, washing machine, cleaning robot");
            Scanner scanner = new Scanner(System.in);
            String device = scanner.nextLine();


            if (device.equals("oven")){
                o.menu(p);

            } else if (device.equals("microwave")){
                m.menu(p);

            } else if (device.equals("dishwasher")){
                d.menu(p);

            } else if (device.equals("washing")){
                String command2 = "";
                while(!command2.equals("exit")) {
                    System.out.println("on, temp, program, off, exit");
                    command2 = scanner.nextLine();
                    if (command2.equals("on")) {
                        p.setCommand(washing_on);
                    } else if (command2.equals("temp")) {
                        p.setCommand(washing_temp);
                    } else if (command2.equals("program")) {
                        p.setCommand(washing_program);
                    } else if (command2.equals("off")) {
                        p.setCommand(washing_off);
                    } else if (command2.equals("exit")){
                        break;
                    } else {
                        System.out.println("Please enter a valid command");
                    }
                    p.pressButton();
                }

            } else if (device.equals("cleaning robot")){
                String command2 = "";
                while(!command2.equals("exit")) {
                    System.out.println("timer, start, check cleaning, check battery, check charging, complete, end, exit");
                    command2 = scanner.nextLine();
                    if (command2.equals("timer")) {
                        p.setCommand(robot_timer);
                    } else if (command2.equals("start")) {
                        p.setCommand(robot_start);
                    } else if (command2.equals("check cleaning")) {
                        p.setCommand(robot_check_cleaning);
                    } else if (command2.equals("check battery")) {
                        p.setCommand(robot_check_battery);
                    } else if (command2.equals("check charging")) {
                        p.setCommand(robot_check_charging);
                    } else if (command2.equals("complete")) {
                        p.setCommand(robot_complete);
                    } else if (command2.equals("end")) {
                        p.setCommand(robot_end);
                    } else if (command2.equals("exit")){
                        break;
                    } else {
                        System.out.println("Please enter a valid command");
                        break;
                    }
                    p.pressButton();
                }

            }
            else {
                System.out.println("Please enter a valid device!");
            }

        }



    }

}
