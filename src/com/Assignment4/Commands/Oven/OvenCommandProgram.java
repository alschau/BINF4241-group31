package com.Assignment4.Commands.Oven;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Oven;

public class OvenCommandProgram implements Command {
    Oven oven;
    String prog;

    public OvenCommandProgram(Oven o, String p){
        this.oven = o;
        this.prog = p;
    }

    public void execute(){
        oven.program(prog);
    }
}