package Phaser;

import java.util.concurrent.Phaser;

public class Task implements  Runnable{
    private Phaser phaser;

    public Task(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        phaser.arrive();

    }
}
