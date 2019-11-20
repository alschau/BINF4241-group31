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

            System.out.println("robo coming to base with" +robo.batpercentage +"% battery charge. \n now charging....");

            while(robo.batpercentage<90){
                Thread.sleep(100);
                time = time - 100;
                robo.batpercentage+=10;
            }
            robo.batpercentage = 100;
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
