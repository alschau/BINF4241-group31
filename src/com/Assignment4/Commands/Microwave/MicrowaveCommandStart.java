package com.Assignment4.Commands.Microwave;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Microwave;

public class MicrowaveCommandStart implements Command {
    Microwave microwave;

    public MicrowaveCommandStart(Microwave m){
        this.microwave = m;
    }

    public void execute(){
        microwave.start();
    }
}
