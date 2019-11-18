package com.Assignment4.Commands.WashingMachine;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.WashingMachine;

public class WashingMachineCommandOn implements Command {
    WashingMachine washing;

    public WashingMachineCommandOn(WashingMachine w){
        this.washing = w;
    }

    public void execute(){
        washing.on();
    }
}
