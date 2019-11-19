package com.Assignment4.Commands.Oven;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Oven;

public class OvenCommandOn implements Command {
    Oven oven;

    public OvenCommandOn(Oven o){
        this.oven = o;
    }

    public void execute(){
        oven.on();
    }
}
