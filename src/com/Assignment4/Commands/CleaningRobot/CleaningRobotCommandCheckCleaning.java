package com.Assignment4.Commands.CleaningRobot;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.CleaningRobot;

public class CleaningRobotCommandCheckCleaning implements Command {
    CleaningRobot bot;

    public CleaningRobotCommandCheckCleaning(CleaningRobot b){
        this.bot = b;
    }

    public void execute(){
        bot.check_cleaning();
    }

}
