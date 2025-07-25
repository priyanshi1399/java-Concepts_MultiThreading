package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        //create the pool
        ExecutorService service= Executors.newFixedThreadPool(10);

        //submit the task for execution
        // fetch next task from queue execute it
        for(int i=0;i<100;i++){
            service.execute(new Task());
        }
        System.out.println("Thread Name "+Thread.currentThread().getName());
    }
}
