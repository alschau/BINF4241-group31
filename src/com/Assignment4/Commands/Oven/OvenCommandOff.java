package com.Assignment4.Commands.Oven;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Oven;

public class OvenCommandOff implements Command {
    Oven oven;

    public OvenCommandOff(Oven o){
        this.oven = o;
    }

    public void execute(){
        oven.off();
    }
}
