package com.Assignment4;

import com.Assignment4.Commands.Oven.*;
import com.Assignment4.Devices.Oven;

public class Main {
    public static void main(String[] args) {

        Phone p = new Phone();
        Oven o = new Oven();

        // INITIALIZING COMMANDS
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


        // TESTING COMMANDS FOR OVEN
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

    }
}
