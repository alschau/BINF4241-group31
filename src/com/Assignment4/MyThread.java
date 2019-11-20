package com.Assignment4;

public class MyThread implements Runnable{
    private boolean running;
    private int time; //3000

    //Set time
    public MyThread(int time){
        this.time = time;
    }

    @Override
    public void run(){
        try {
            running = true;
            System.out.println("Thread is starting!");

            // Count down time
            while(time>=10){
                Thread.sleep(10);
                time = time - 10;
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
