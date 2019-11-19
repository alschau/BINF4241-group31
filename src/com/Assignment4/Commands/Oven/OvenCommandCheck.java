package com.Assignment4.Commands.Oven;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Oven;

public class OvenCommandCheck implements Command {
    Oven oven;

    public OvenCommandCheck(Oven o){
        this.oven = o;
    }

    public void execute(){
        oven.check_timer();
    }
}
