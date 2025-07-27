package ExecutorService;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        //create the pool
        ExecutorService service= Executors.newFixedThreadPool(10);

        //submit the task for execution
        // fetch next task from queue execute it
        for(int i=0;i<100;i++){
            service.execute(new Task());
        }
        service.shutdown();
        //any task after submit gives exception
       // service.execute(new Task());

        //if shutdown is initiated
        service.isShutdown();

        //service.awaitTermination(10, TimeUnit.SECONDS);

       List<Runnable> runnables=service.shutdownNow();
        System.out.println("Thread Name "+Thread.currentThread().getName());
    }
}
