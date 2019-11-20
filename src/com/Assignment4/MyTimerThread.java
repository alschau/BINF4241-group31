package com.Assignment4;

import com.Assignment4.Devices.CleaningRobot;

public class MyTimerThread implements Runnable{
    private boolean running;
    private CleaningRobot robo;
    private int time;
    public int initial_time;


    //Set time

    public MyTimerThread(CleaningRobot robo, int time){
        this.robo = robo;
        this.time = time;
        this.initial_time = time;
    }

    @Override
    public void run(){
        try {
            running = true;

            // Count down time
            while(time>=1000){
                Thread.sleep(1000);
                time = time - 1000;
                robo.cleanpercentage = (time*100/initial_time);
            }
            robo.mybattery.setTime(0);
            robo.base = true;
            running = false;

            //todo terminate other thread if one is done!

            System.out.println("robo is running out of time, returning to base");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isRunning(){
        return running;
    }

    public int getTime(){
        return time/1000;
    }

    public void setTime(int i){
        time = i;
    }

}
