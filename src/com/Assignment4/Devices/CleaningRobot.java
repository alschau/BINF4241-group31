package com.Assignment4.Devices;

import com.Assignment4.Commands.CleaningRobot.*;
import com.Assignment4.MyBatteryThread;
import com.Assignment4.MyTimerThread;
import com.Assignment4.Phone;
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
        time =t*1000;
        //wait until its fully charged

    }


    public void start(){
        if(full && base && time!=0){

            base = false;
            System.out.println("robo is starting");
            // Start (starting 2 threads)

            mybattery = new MyBatteryThread(this);
            mytimer = new MyTimerThread(this, time);
            battery = new Thread(mybattery);
            timer = new Thread(mytimer);
            battery.start();
            timer.start();

        }else{
            System.out.println("the robot is currently unavailabe (either cleaning already or charging)");
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
        while(time>0){
            if(full){
                start();
            }

        }
        //System.out.println("nigger");


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






    public void menu(Phone p){

        String command2 = "";
        while(!command2.equals("exit")) {
            System.out.println("timer, start, check cleaning, check battery, check charging, complete, end, exit");
            command2 = scanner.nextLine();
            if (command2.equals("timer")) {
                System.out.println("enter a time");
                String command3 = scanner.nextLine();
                CleaningRobotCommandTimer robot_timer = new CleaningRobotCommandTimer(this, Integer.parseInt(command3));
                p.setCommand(robot_timer);
            } else if (command2.equals("start")) {
                CleaningRobotCommandStart robot_start = new CleaningRobotCommandStart(this);
                p.setCommand(robot_start);
            } else if (command2.equals("check cleaning")) {
                CleaningRobotCommandCheckCleaning robot_check_cleaning = new CleaningRobotCommandCheckCleaning(this);
                p.setCommand(robot_check_cleaning);
            } else if (command2.equals("check battery")) {
                CleaningRobotCommandCheckBattery robot_check_battery = new CleaningRobotCommandCheckBattery(this);
                p.setCommand(robot_check_battery);
            } else if (command2.equals("check charging")) {
                CleaningRobotCommandCheckCharging robot_check_charging = new CleaningRobotCommandCheckCharging(this);
                p.setCommand(robot_check_charging);
            } else if (command2.equals("complete")) {
                CleaningRobotCommandComplete robot_complete = new CleaningRobotCommandComplete(this);
                p.setCommand(robot_complete);
            } else if (command2.equals("end")) {
                CleaningRobotCommandEnd robot_end = new CleaningRobotCommandEnd(this);
                p.setCommand(robot_end);
            } else if (command2.equals("exit")){
                break;
            } else {
                System.out.println("Please enter a valid command");
                continue;
            }
            p.pressButton();
        }

    }

}
