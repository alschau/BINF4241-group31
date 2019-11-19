package com.Assignment4.Commands.Oven;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Oven;

public class OvenCommandTemp implements Command {
    Oven oven;
    int temp;

    public OvenCommandTemp(Oven o, int t){
        this.oven = o;
        this.temp = t;
    }

    public void execute(){
        oven.temp(temp);
    }
}
