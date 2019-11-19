package com.Assignment4.Commands.Dishwasher;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.Dishwasher;

public class DishwasherCommandCheck implements Command {
    Dishwasher dishwasher;

    public DishwasherCommandCheck(Dishwasher d){
        this.dishwasher = d;
    }

    public void execute(){
        dishwasher.check_timer();
    }
}
