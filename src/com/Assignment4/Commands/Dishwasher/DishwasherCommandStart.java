package com.Assignment4.Commands.Dishwasher;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Dishwasher;

public class DishwasherCommandStart implements Command {
    Dishwasher dishwasher;

    public DishwasherCommandStart(Dishwasher d){
        this.dishwasher = d;
    }

    public void execute(){
        dishwasher.start();
    }
}
