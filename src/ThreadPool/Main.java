package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Main {

    public static void main(String[] args) {

       /* cached Thread Pool
       ExecutorService service = Executors.newCachedThreadPool();


        for (int i = 0; i < 100; i++) {
            service.execute(new Task());
        }
        */


        /* Scheduled Thread Pool */

        ScheduledExecutorService service=Executors.newScheduledThreadPool(10);

        //task to run after 10 second delay
        service.schedule(new Task(), 10,SECONDS);

        //task to run repeatedly every 10 seconds
        service.scheduleAtFixedRate(new Task(), 15,10,SECONDS);

        //task to run repeatedly 10 seconds after previous task completes

        service.scheduleWithFixedDelay(new Task(), 15,10, SECONDS);
    }
}
