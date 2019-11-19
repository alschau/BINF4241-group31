package com.Assignment4.Commands.Oven;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Oven;

public class OvenCommandTimer implements Command {
    Oven oven;
    int timer;

    public OvenCommandTimer(Oven o, int time){
        this.oven = o;
        this.timer = time;
    }

    public void execute(){
        oven.timer(timer);
    }

}
