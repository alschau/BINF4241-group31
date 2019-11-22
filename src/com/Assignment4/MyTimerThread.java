package com.Assignment4;

import com.Assignment4.Devices.CleaningRobot;

public class MyTimerThread implements Runnable{
    private boolean running;
    private CleaningRobot robo;
    private int time;
    public int initial_time;
    public boolean print = true;


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

            // Count percentage of the time that has already been completed
            while(time>=10){
                Thread.sleep(10);
                time = time - 10;
                robo.cleanpercentage = 100 - (time*100/initial_time);
                System.out.println(robo.time);
            }
            robo.mybattery.setTime(0);
            robo.mybattery.print = false;
            robo.base = true;

            running = false;

            //todo terminate other thread if one is done!
            if(print){
                System.out.println("robo is running out of time, returning to base");
                robo.startcharging();
            }




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
