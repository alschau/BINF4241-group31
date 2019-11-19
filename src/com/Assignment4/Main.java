package com.Assignment4;

import com.Assignment4.Commands.CleaningRobot.*;
import com.Assignment4.Commands.Dishwasher.*;
import com.Assignment4.Commands.Microwave.*;
import com.Assignment4.Commands.Oven.*;
import com.Assignment4.Commands.WashingMachine.*;
import com.Assignment4.Devices.*;

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

    }
}
