package com.Assignment4;

public class MyThread implements Runnable{
    private boolean running;
    private int time; //3000

    //Set time
    public MyThread(int time){
        this.time = time;
    }
    public MyThread(){

    }

    @Override
    public void run(){
        try {
            running = true;
            System.out.println("Thread is starting!");

            // Count down time
            while(time>=1000){
                Thread.sleep(1000);
                time = time - 1000;
            }
            running = false;
            System.out.println("Thread is ending!");
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
