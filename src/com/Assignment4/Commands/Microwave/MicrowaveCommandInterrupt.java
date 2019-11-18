package com.Assignment4.Commands.Microwave;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Microwave;

public class MicrowaveCommandInterrupt implements Command {
    Microwave microwave;

    public MicrowaveCommandInterrupt(Microwave m){
        this.microwave = m;
    }

    public void execute(){
        microwave.interrupt();
    }
}
