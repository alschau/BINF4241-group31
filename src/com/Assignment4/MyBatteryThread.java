package com.Assignment4;

import com.Assignment4.Devices.CleaningRobot;

public class MyBatteryThread implements Runnable{
    private boolean running;
    private CleaningRobot robo;
    private int time = 10000;
    public boolean print = true;


    //Set time
    public MyBatteryThread(CleaningRobot robo){
        this.robo = robo;
    }


    @Override
    public void run(){
        try {
            running = true;

            // Count down time
            while(time>=10){
                robo.batpercentage = time/100;
                Thread.sleep(10);
                time = time - 10;

            }
            robo.mytimer.print = false;
            robo.mytimer.setTime(0);
            robo.base = true;

            running = false;

            //todo terminate other thread if one is done!
            if(print){
                System.out.println("robo is running out of battery, returning to base");
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
