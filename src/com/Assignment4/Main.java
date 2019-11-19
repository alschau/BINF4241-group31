package com.Assignment4;

import com.Assignment4.Commands.CleaningRobot.*;
import com.Assignment4.Commands.Command;
import com.Assignment4.Commands.Dishwasher.*;
import com.Assignment4.Commands.Microwave.*;
import com.Assignment4.Commands.Oven.*;
import com.Assignment4.Commands.WashingMachine.*;
import com.Assignment4.Devices.*;

import java.util.ArrayList;
import java.util.Arrays;
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
        MicrowaveCommandOn microwave_on = new MicrowaveCommandOn(m);
        MicrowaveCommandTimer microwave_timer = new MicrowaveCommandTimer(m, 30);
        MicrowaveCommandTemp microwave_temp = new MicrowaveCommandTemp(m, 220);
        MicrowaveCommandStart microwave_start = new MicrowaveCommandStart(m);
        MicrowaveCommandCheck microwave_check = new MicrowaveCommandCheck(m);
        MicrowaveCommandInterrupt microwave_interrupt = new MicrowaveCommandInterrupt(m);
        MicrowaveCommandOff microwave_off = new MicrowaveCommandOff(m);

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

        //##############################################################################################################

        // testing_threads(p, o, m, d, w, b);

        //##############################################################################################################

        // INITIALIZING THREAD
        MyThread T_one = new MyThread();
        MyThread T_two = new MyThread(1000);

        Thread one = new Thread(T_one, "FirstThread");
        //one.start();


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
            String command = scanner.nextLine();

            if (command.equals("oven")){
                //TODO Create a function that does this
                String command2 = "";
                while(!command2.equals("exit")) {
                    System.out.println("on, timer, temp, program, start, check, interrupt, off, exit");
                    command2 = scanner.nextLine();
                    if (command2.equals("on")) {
                        OvenCommandOn oven_on = new OvenCommandOn(o);
                        p.setCommand(oven_on);
                    } else if (command2.equals("timer")) {
                        System.out.println("How long? enter in seconds: ");
                        String command3 = scanner.nextLine();
                        OvenCommandTimer oven_timer = new OvenCommandTimer(o, Integer.parseInt(command3));
                        p.setCommand(oven_timer);
                    } else if (command2.equals("temp")) {
                        System.out.println("Enter temperature: ");
                        String command3 = scanner.nextLine();
                        OvenCommandTemp oven_temp = new OvenCommandTemp(o, Integer.parseInt(command3));
                        p.setCommand(oven_temp);
                    } else if (command2.equals("program")) {
                        System.out.println("Enter program: ");
                        String command3 = scanner.nextLine();
                        OvenCommandProgram oven_program = new OvenCommandProgram(o, command3);
                        p.setCommand(oven_program);
                    } else if (command2.equals("start")) {
                        OvenCommandStart oven_start = new OvenCommandStart(o);
                        p.setCommand(oven_start);
                    } else if (command2.equals("check")) {
                        OvenCommandCheck oven_check = new OvenCommandCheck(o);
                        p.setCommand(oven_check);
                    } else if (command2.equals("interrupt")) {
                        OvenCommandInterrupt oven_interrupt = new OvenCommandInterrupt(o);
                        p.setCommand(oven_interrupt);
                    } else if (command2.equals("off")) {
                        OvenCommandOff oven_off = new OvenCommandOff(o);
                        p.setCommand(oven_off);
                    } else if (command2.equals("exit")){
                        break;
                    } else {
                        System.out.println("Please enter a valid command");
                    }
                    p.pressButton();
                }

            } else if (command.equals("microwave")){
                String command2 = "";
                while(!command2.equals("exit")) {
                    System.out.println("on, timer, temp, start, check, interrupt, off, exit");
                    command2 = scanner.nextLine();
                    if (command2.equals("on")) {
                        p.setCommand(microwave_on);
                    } else if (command2.equals("timer")) {
                        p.setCommand(microwave_timer);
                    } else if (command2.equals("temp")) {
                        p.setCommand(microwave_temp);
                    } else if (command2.equals("start")) {
                        p.setCommand(microwave_start);
                    } else if (command2.equals("check")) {
                        p.setCommand(microwave_check);
                    } else if (command2.equals("interrupt")) {
                        p.setCommand(microwave_interrupt);
                    } else if (command2.equals("off")) {
                        p.setCommand(microwave_off);
                    } else if (command2.equals("exit")){
                        break;
                    } else {
                        System.out.println("Please enter a valid command");
                    }
                    p.pressButton();
                }

            } else if (command.equals("dishwasher")){
                String command2 = "";
                while(!command2.equals("exit")) {
                    System.out.println("on, start, program, , check, stop, off, exit");
                    command2 = scanner.nextLine();
                    if (command2.equals("on")) {
                        p.setCommand(dishwasher_on);
                    } else if (command2.equals("start")) {
                        p.setCommand(dishwasher_start);
                    } else if (command2.equals("program")) {
                        p.setCommand(dishwasher_program);
                    } else if (command2.equals("check")) {
                        p.setCommand(dishwasher_check);
                    } else if (command2.equals("stop")) {
                        p.setCommand(dishwasher_stop);
                    } else if (command2.equals("off")) {
                        p.setCommand(dishwasher_off);
                    } else if (command2.equals("exit")){
                        break;
                    } else {
                        System.out.println("Please enter a valid command");
                    }
                    p.pressButton();
                }

            } else if (command.equals("washing")){
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

            } else if (command.equals("cleaning robot")){
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
                    }
                    p.pressButton();
                }

            }
            else {
                System.out.println("Please enter a valid device!");
            }

        }



    }

    public static ArrayList testing_threads(Phone p, Oven o, Microwave m, Dishwasher d, WashingMachine w, CleaningRobot b){

        // INITIALIZING COMMANDS OVEN
        OvenCommandOn oven_on = new OvenCommandOn(o);
        //TODO wie chan in d Ziit/Temp erst später mitgeh?
        OvenCommandTimer oven_timer = new OvenCommandTimer(o, 20);
        OvenCommandTemp oven_temp = new OvenCommandTemp(o, 180);
        //TODO string später mitgeh?
        OvenCommandProgram oven_program = new OvenCommandProgram(o, "MYPROGRAM_OVEN");
        OvenCommandStart oven_start = new OvenCommandStart(o);
        OvenCommandCheck oven_check = new OvenCommandCheck(o);
        OvenCommandInterrupt oven_interrupt = new OvenCommandInterrupt(o);
        OvenCommandOff oven_off = new OvenCommandOff(o);

        // INITIALIZING COMMANDS MICROWAVE
        MicrowaveCommandOn microwave_on = new MicrowaveCommandOn(m);
        MicrowaveCommandTimer microwave_timer = new MicrowaveCommandTimer(m, 30);
        MicrowaveCommandTemp microwave_temp = new MicrowaveCommandTemp(m, 220);
        MicrowaveCommandStart microwave_start = new MicrowaveCommandStart(m);
        MicrowaveCommandCheck microwave_check = new MicrowaveCommandCheck(m);
        MicrowaveCommandInterrupt microwave_interrupt = new MicrowaveCommandInterrupt(m);
        MicrowaveCommandOff microwave_off = new MicrowaveCommandOff(m);

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

        ArrayList<Command> command_list = new ArrayList<Command>(
                Arrays.asList(oven_on, oven_timer));


        // TESTING COMMANDS FOR OVEN
        System.out.println("TESTS FOR OVEN");
        p.setCommand(oven_on);
        p.pressButton();
        p.setCommand(oven_timer);
        p.pressButton();
        p.setCommand(oven_temp);
        p.pressButton();
        p.setCommand(oven_program);
        p.pressButton();
        p.setCommand(oven_start);
        p.pressButton();
        p.setCommand(oven_check);
        p.pressButton();
        p.setCommand(oven_interrupt);
        p.pressButton();
        p.setCommand(oven_off);
        p.pressButton();

        // TESTING COMMANDS FOR MICROWAVE
        System.out.println("\nTESTS FOR MICROWAVE");
        p.setCommand(microwave_on);
        p.pressButton();
        p.setCommand(microwave_timer);
        p.pressButton();
        p.setCommand(microwave_temp);
        p.pressButton();
        p.setCommand(microwave_start);
        p.pressButton();
        p.setCommand(microwave_check);
        p.pressButton();
        p.setCommand(microwave_interrupt);
        p.pressButton();
        p.setCommand(microwave_off);
        p.pressButton();

        // TESTING COMMANDS FOR DISHWASHER
        System.out.println("\nTESTS FOR DISHWASHER");
        p.setCommand(dishwasher_on);
        p.pressButton();
        p.setCommand(dishwasher_start);
        p.pressButton();
        p.setCommand(dishwasher_program);
        p.pressButton();
        p.setCommand(dishwasher_check);
        p.pressButton();
        p.setCommand(dishwasher_stop);
        p.pressButton();
        p.setCommand(dishwasher_off);
        p.pressButton();

        // TESTING COMMANDS FOR WASHING MACHINE
        System.out.println("\nTESTS FOR WASHING MACHINE");
        p.setCommand(washing_on);
        p.pressButton();
        p.setCommand(washing_temp);
        p.pressButton();
        p.setCommand(washing_program);
        p.pressButton();
        p.setCommand(washing_stop);
        p.pressButton();
        p.setCommand(washing_off);
        p.pressButton();

        // TESTING COMMANDS FOR CLEANING ROBOT
        System.out.println("\nTESTS FOR CLEANING ROBOT");
        p.setCommand(robot_timer);
        p.pressButton();
        p.setCommand(robot_start);
        p.pressButton();
        p.setCommand(robot_check_cleaning);
        p.pressButton();
        p.setCommand(robot_check_battery);
        p.pressButton();
        p.setCommand(robot_check_charging);
        p.pressButton();
        p.setCommand(robot_complete);
        p.pressButton();
        p.setCommand(robot_end);
        p.pressButton();

        return command_list;
    }
}
