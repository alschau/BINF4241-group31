package com.Assignment4.Commands.WashingMachine;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.WashingMachine;

public class WashingMachineCommandProgram implements Command {
    WashingMachine washing;
    String program;

    public WashingMachineCommandProgram(WashingMachine w, String p){
        this.washing = w;
        this.program = p;
    }

    public void execute(){
        washing.program(program);
    }
}
