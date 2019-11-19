package com.Assignment4.Commands.WashingMachine;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.WashingMachine;

public class WashingMachineCommandTemp implements Command {
    WashingMachine washing;
    int temp;

    public WashingMachineCommandTemp(WashingMachine w, int t){
        this.washing = w;
        this.temp = t;
    }

    public void execute(){
        washing.temp(temp);
    }
}
