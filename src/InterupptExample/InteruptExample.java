package InterupptExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InteruptExample {

    public static void main(String[] args) {

        ExecutorService threadPool=Executors.newFixedThreadPool(2);

        threadPool.submit(()->{

            System.out.println("Task started");
            while(!Thread.currentThread().isInterrupted()) {
                try{
                    Thread.sleep(1000);

                }
                catch(InterruptedException e){
                    System.out.println("Task Interrupted during sleep");
                    Thread.currentThread().interrupt();
                }


            }
            System.out.println("Task stopped");

                //we dont use if because there can be other task also below task 1 and 2
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("task interupting..");
        threadPool.shutdownNow(); // It calls thread.interrup  internallyt while running the task


    }
}
