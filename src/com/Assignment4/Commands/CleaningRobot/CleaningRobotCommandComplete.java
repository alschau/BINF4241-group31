package com.Assignment4.Commands.CleaningRobot;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.CleaningRobot;

public class CleaningRobotCommandComplete implements Command {
    CleaningRobot bot;

    public CleaningRobotCommandComplete(CleaningRobot b){
        this.bot = b;
    }

    public void execute(){
        bot.complete_cleaning();
    }

}
