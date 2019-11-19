package com.Assignment4.Commands.WashingMachine;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.WashingMachine;

public class WashingMachineCommandStop implements Command {
    WashingMachine washing;

    public WashingMachineCommandStop(WashingMachine w){
        this.washing = w;
    }

    public void execute(){
        washing.stop();
    }
}
