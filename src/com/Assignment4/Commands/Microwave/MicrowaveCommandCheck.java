package com.Assignment4.Commands.Microwave;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Microwave;

public class MicrowaveCommandCheck implements Command {
    Microwave microwave;

    public MicrowaveCommandCheck(Microwave m){
        this.microwave = m;
    }

    public void execute(){
        microwave.check_timer();
    }
}
