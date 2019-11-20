package com.Assignment4.Commands.WashingMachine;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.WashingMachine;

public class WashingMachineCommandTimer implements Command {
    WashingMachine washing;

    public WashingMachineCommandTimer(WashingMachine w){
        this.washing = w;
    }

    public void execute(){
        washing.timer();
    }
}
