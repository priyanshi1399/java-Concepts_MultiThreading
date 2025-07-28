package Phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicInteger;

public class DependentService implements  Runnable{
    private static AtomicInteger counter=new AtomicInteger(0);
    private Phaser phaser;

    public DependentService(Phaser phaser) {
        this.phaser = phaser;

    }

    @Override
    public void run() {

        phaser.register(); //allowsthreads to register themselves
        System.out.println("registering itself");
        phaser.arrive();
        /* //phase as cycle barrier
        while(true) {
            phaser.arriveAndAwaitAdvance(); //says I have arrived wait for other
            System.out.println("All service have arrived");
        }
        */

    }

}
