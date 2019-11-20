package com.Assignment4.Commands.Dishwasher;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Dishwasher;

public class DishwasherCommandProgram implements Command {
    Dishwasher dishwasher;
    String program;


    public DishwasherCommandProgram(Dishwasher d, String p){
        this.dishwasher = d;
        this.program = p;
    }

    public void execute(){
        dishwasher.program(program);
    }
}
