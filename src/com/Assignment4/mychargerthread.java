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
            int percentage = robo.batpercentage;
            int time = (100 - percentage) *1000;

            System.out.println("robo coming to base with " +robo.batpercentage +"% battery charge. \nnow charging....");

            while(robo.batpercentage<99){
                Thread.sleep(100);
                time = time - 100;
                robo.batpercentage+=1;
            }
            robo.batpercentage = 100;
            System.out.println("robo is fully charged and ready to use again");
            robo.full = true;
            robo.base = true;
            running = false;
            System.out.println(robo.time);

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
