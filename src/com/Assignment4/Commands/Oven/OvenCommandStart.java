package com.Assignment4.Commands.Oven;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Oven;

public class OvenCommandStart implements Command {
    Oven oven;

    public OvenCommandStart(Oven o){
        this.oven = o;
    }

    public void execute(){
        oven.start();
    }
}
