package InterupptExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InterruptWithFuture {

    public static void main(String[] args) {

        ExecutorService threadPool= Executors.newFixedThreadPool(3);



            Future<?> future=threadPool.submit(()->{
                System.out.println("Thread started");
                while(!Thread.currentThread().isInterrupted()){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    Thread.currentThread().interrupt();
                    System.out.println("thread interuppted");
                }
                System.out.println("Thread stopped");
            });


        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("thread is interuppting");
        future.cancel(true); //may InterruptIfRunning It calls thread.interrup  internallyt while running the task


    }
}
