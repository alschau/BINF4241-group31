package com.Assignment4.Commands.CleaningRobot;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.CleaningRobot;

public class CleaningRobotCommandStart implements Command {
    CleaningRobot bot;

    public CleaningRobotCommandStart(CleaningRobot b){
        this.bot = b;
    }

    public void execute(){
        bot.start();
    }

}
