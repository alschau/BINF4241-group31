package com.Assignment4;

import com.Assignment4.Commands.Microwave.*;
import com.Assignment4.Commands.Oven.*;
import com.Assignment4.Devices.Microwave;
import com.Assignment4.Devices.Oven;

public class Main {
    public static void main(String[] args) {

        Phone p = new Phone();

        // INITIALIZING DEVICES
        Oven o = new Oven();
        Microwave m = new Microwave();

        // INITIALIZING COMMANDS OVEN
        OvenCommandOn oven_on = new OvenCommandOn(o);
        //TODO wie chan in d Ziit/Temp erst später mitgeh?
        OvenCommandTimer oven_timer = new OvenCommandTimer(o, 20);
        OvenCommandTemp oven_temp = new OvenCommandTemp(o, 180);
        //TODO string später mitgeh?
        OvenCommandProgram oven_program = new OvenCommandProgram(o, "MYPROGRAM");
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

    }
}
