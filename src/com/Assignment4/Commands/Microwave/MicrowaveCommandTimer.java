package com.Assignment4.Commands.Microwave;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Microwave;

public class MicrowaveCommandTimer implements Command {
    Microwave microwave;
    int timer;

    public MicrowaveCommandTimer(Microwave m, int time){
        this.microwave = m;
        this.timer = time;
    }

    public void execute(){
        microwave.timer(timer);
    }
}
