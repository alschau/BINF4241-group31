package com.Assignment4;

import com.Assignment4.Devices.CleaningRobot;

public class MyBatteryThread implements Runnable{
    private boolean running;
    private CleaningRobot robo;
    private int time = 100000;
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
            while(time>1000){
                Thread.sleep(1000);
                time = time - 1000;
                robo.batpercentage = time/1000;

            }

            robo.mytimer.setTime(0);
            System.out.println(robo.time);
            robo.mytimer.print = false;
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
