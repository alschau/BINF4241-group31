package com.Assignment4.Devices;

import com.Assignment4.MyThread;

import java.util.Arrays;
import java.util.List;

public class CleaningRobot extends Devices {
    public Boolean full = true;
    public Boolean base = true;
    public int time;
    private final int chargetime = 10000;
    private final int runtime = 100000;
    public MyThread my_timer_thread;
    public Thread timer_thread;
    public MyThread my_charging_thread;
    public Thread charging_thread;
    private int temp;


    public CleaningRobot(){
    }

    public void timer(int t){
        //wait until its fully charged
        time = t;
        while(!full){
            Thread wait = new Thread(new MyThread( 1000));
            wait.start();
        }

        if(full){
            System.out.println("there he gooooooes");
            full = false;
            my_timer_thread = new MyThread(t*1000);
            timer_thread = new Thread(my_timer_thread);
            timer_thread.start();

        }
    }

    public void check_battery(){

    }



    public void check_charging(){

    }

    public void check_cleaning(){
        System.out.println("the robot is to " + my_timer_thread.getTime()/runtime + "% done");

    }
    public void complete_cleaning(){

    }
    public void end_cleaning(){

    }




    public void start(){

    }

}
