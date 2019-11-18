package com.Assignment4.Commands.Dishwasher;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Dishwasher;

public class DishwasherCommandStop implements Command {
    Dishwasher dishwasher;

    public DishwasherCommandStop(Dishwasher d){
        this.dishwasher = d;
    }

    public void execute(){
        dishwasher.stop();
    }
}
