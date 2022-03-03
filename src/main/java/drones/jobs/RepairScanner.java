package drones.jobs;

import drones.beans.Drones;

import java.util.Date;
import java.util.Set;

public class RepairScanner implements Runnable {
    //two types of parameters
    //by value -> primitive types (String, boolean, int, double, float, etc...)
    //by reference -> instances -> heap

    private Set<Drones> drones;
    private boolean isRunning;

    public RepairScanner(Set<Drones> drones) {
        this.drones = drones;
        this.isRunning = true;
    }

    @Override
    public void run() {
        while (true) {
            for (Drones item : drones) {
                if (!item.isPoped()) {
                    //check date
                   if (item.getEta().before(new Date(System.currentTimeMillis()))) {
                        item.setPoped(true);
                        System.out.println("Drone is ready!!!  \n==============\n");
                        //anonymous thread
                         new Thread(new Runnable() {
                             @Override
                             public void run() {
                                 for (int counter = 0; counter < 3; counter++) {
                                     try{Thread.sleep(30_000);}catch (Exception e){}
                                     System.out.println("Dude, the drone is ready!!!");
                                 }
                             }
                        }).start();
                    }
                }
            }
            try {
                Thread.sleep(1000 * 60 * 60 * 24);
            } catch (InterruptedException err) {
                err.printStackTrace();
            }
        }
    }

    public void stopScanner() {
        this.isRunning = false;
    }
}
