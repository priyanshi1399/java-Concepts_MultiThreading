package Phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserBarrierMain {

    public static void main(String[] args) {

        ExecutorService executor= Executors.newFixedThreadPool(4);

        Phaser phaser =new Phaser(1); //self-register


       // executor.submit(new DependentService(phaser));
        executor.submit(new DependentService(phaser));
        executor.submit(new DependentService(phaser));

        phaser.arriveAndAwaitAdvance();
        phaser.bulkRegister(4); //bulk register later

        /* //used in phaser as a cycle barrier
        try {
            Thread.sleep(10000); //main thread will sleep
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        //System.out.println("Main thread goes to sleep");
    }
}
