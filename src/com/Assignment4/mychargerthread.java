package com.Assignment4;

import com.Assignment4.Devices.CleaningRobot;

public class mychargerthread implements Runnable{
    private boolean running;
    private CleaningRobot robo;

    //Set time
    public mychargerthread(CleaningRobot robo){
        this.robo = robo;
    }


    @Override
    public void run(){
        try {
            running = true;
            int percentage = (robo.time - robo.mybattery.getTime())/100000;
            int time = (1 - percentage) *1000;

            while(time>=1000){
                Thread.sleep(1000);
                time = time - 1000;
            }
            robo.full = true;
            running = false;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isRunning(){
        return running;
    }

    public int getTime(){
        return robo.time/1000;
    }

    public void setTime(int i){
        robo.time = i;
    }

}
