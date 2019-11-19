package com.Assignment4.Commands.Dishwasher;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Dishwasher;

public class DishwasherCommandOn implements Command {
    Dishwasher dishwasher;

    public DishwasherCommandOn(Dishwasher d){
        this.dishwasher = d;
    }

    public void execute(){
        dishwasher.on();
    }
}
