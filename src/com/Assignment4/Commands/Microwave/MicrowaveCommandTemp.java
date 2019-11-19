package com.Assignment4.Commands.Microwave;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Microwave;

public class MicrowaveCommandTemp implements Command {
    Microwave microwave;
    int temp;

    public MicrowaveCommandTemp(Microwave m, int t){
        this.microwave = m;
        this.temp = t;
    }

    public void execute(){
        microwave.temp(temp);
    }
}
