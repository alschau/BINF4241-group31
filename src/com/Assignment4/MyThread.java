package com.Assignment4;

public class MyThread implements Runnable{
    private boolean running;
    private int time;

    //Set time
    public MyThread(int time){
        this.time = time;
    }

    //Default
    public MyThread(){
        this.time = 5000;
    }

    @Override
    public void run(){
        try {
            running = true;
            System.out.println("Thread is starting!");
            Thread.sleep(time);
            running = false;
            System.out.println("Thread is ending!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isRunning(){
        return running;
    }

}
