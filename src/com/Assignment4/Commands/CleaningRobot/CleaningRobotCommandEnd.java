package com.Assignment4.Commands.CleaningRobot;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.CleaningRobot;

public class CleaningRobotCommandEnd implements Command {
    CleaningRobot bot;

    public CleaningRobotCommandEnd(CleaningRobot b){
        this.bot = b;
    }

    public void execute(){
        bot.end_cleaning();
    }

}
