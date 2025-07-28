package Phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor=Executors.newFixedThreadPool(4);

        Phaser phaser =new Phaser(3);
        executor.submit(new Task(phaser));
        executor.submit(new Task(phaser));
        executor.submit(new Task(phaser));

        phaser.awaitAdvance(1);

        System.out.println("All dependent service initilaized");



    }

}
