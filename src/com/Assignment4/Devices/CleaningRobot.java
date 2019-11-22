package com.Assignment4.Devices;

import com.Assignment4.MyBatteryThread;
import com.Assignment4.MyTimerThread;
import com.Assignment4.mychargerthread;

public class CleaningRobot extends Devices {
    public Boolean full = true;
    public Boolean base = true;
    public int time;
    private final int chargetime = 10000;
    private final int runtime = 100000;
    public MyTimerThread mytimer;
    public MyBatteryThread mybattery;
    public mychargerthread mycharger;
    public Thread timer;
    public Thread battery;
    public Thread charger;
    public int batpercentage;
    public int cleanpercentage;



    public CleaningRobot(){
    }



    public void timer(int t){
        time =t;
        //wait until its fully charged

        if(full){

            base = false;
            // Start (starting 2 threads)

            mybattery = new MyBatteryThread(this);
            mytimer = new MyTimerThread(this, time);
            battery = new Thread(mybattery);
            timer = new Thread(mytimer);
            battery.start();
            timer.start();

        }else{
            System.out.println("sorry the robot is still charging, currently at" + batpercentage + "%");
        }
    }

    public void check_battery(){
        if(base){
            System.out.println("100%");
        }else{
            System.out.println(batpercentage + "%");
        }

    }

    public void startcharging(){
        mychargerthread mycharger = new mychargerthread(this);
        Thread charger = new Thread(mycharger);
        charger.start();
    }



    public void check_charging(){
        if(base){
            System.out.println("robot is in base with " + batpercentage + "% batterylife");
        }
        else{
            System.out.println("sry the robot is currently not home");
        }


    }

    public void check_cleaning(){
        if(base){
            System.out.println("robo in base");
        }else{
            System.out.println(cleanpercentage + "%");
        }

    }
    public void complete_cleaning(){


    }
    public void end_cleaning(){

        if(!base){
            if(cleanpercentage < 100){
                mytimer.setTime(0);
            }else{
                mybattery.setTime(0);
            }
        }



    }




    public void start(){

    }

    public void menu(){

    }

}
