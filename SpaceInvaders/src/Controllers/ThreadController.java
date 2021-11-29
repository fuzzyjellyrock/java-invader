/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author fuzzyrock
 */
public class ThreadController implements Runnable {
    
    private Thread worker;
    private int interval;
    private AtomicBoolean running = new AtomicBoolean(false);
    private AtomicBoolean stopped = new AtomicBoolean(true);


    public ThreadController(int sleepInterval) {
        interval = sleepInterval;
    }

    public void start(Runnable target) {
        worker = new Thread(target);
        worker.start();
    }

    public void stop() {
        running.set(false);
    }

    public void interrupt() {
        running.set(false);
        worker.interrupt();
    }

    boolean isRunning() {
        return running.get();
    }

    boolean isStopped() {
        return stopped.get();
    }
    
    @Override
    public void run() {
        running.set(true);
        stopped.set(false);
        while (running.get()) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
            	Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted, Failed to complete operation");
	    }
            // do something
        }
        stopped.set(true);
    }
    
}
