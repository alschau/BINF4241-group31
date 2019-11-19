package com.Assignment4.Commands.WashingMachine;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.WashingMachine;

public class WashingMachineCommandOff implements Command {
    WashingMachine washing;

    public WashingMachineCommandOff(WashingMachine w){
        this.washing = w;
    }

    public void execute(){
        washing.off();
    }
}
