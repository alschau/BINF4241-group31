package com.Assignment4.Commands.CleaningRobot;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.CleaningRobot;

public class CleaningRobotCommandCheckCharging implements Command {
    CleaningRobot bot;

    public CleaningRobotCommandCheckCharging(CleaningRobot b){
        this.bot = b;
    }

    public void execute(){
        bot.check_charging();
    }

}
