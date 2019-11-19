package com.Assignment4.Commands.CleaningRobot;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.CleaningRobot;

public class CleaningRobotCommandCheckBattery implements Command {
    CleaningRobot bot;

    public CleaningRobotCommandCheckBattery(CleaningRobot b){
        this.bot = b;
    }

    public void execute(){
        bot.check_battery();
    }

}
