package ReentrantExample;

import SuspendExample.SharedResource;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        ReentrantLock lock=new ReentrantLock();

        SharedResources resource1=new SharedResources();
        Thread th1=new Thread(()->{
            resource1.producer(lock);
        });

        SharedResources resource2=new SharedResources();
        Thread th2=new Thread(()->{
            resource2.producer(lock);
        });

        th1.start();
        th2.start();
    }
}
