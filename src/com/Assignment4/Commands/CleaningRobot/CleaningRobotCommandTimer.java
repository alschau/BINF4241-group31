package com.Assignment4.Commands.CleaningRobot;

import com.Assignment4.Commands.Command;
import com.Assignment4.Devices.CleaningRobot;

public class CleaningRobotCommandTimer implements Command {
    CleaningRobot bot;
    int timer;

    public CleaningRobotCommandTimer(CleaningRobot b, int time){
        this.bot = b;
        this.timer = time;
    }

    public void execute(){
        bot.timer(timer);
    }

}
