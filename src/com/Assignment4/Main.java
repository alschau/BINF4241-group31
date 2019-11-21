package com.Assignment4;

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

            } else if (device.equals("washing machine")){
                w.menu(p);

            } else if (device.equals("cleaning robot")){
                b.menu(p);
            }
            else {
                System.out.println("Please enter a valid device!");
            }

        }

    }

}
