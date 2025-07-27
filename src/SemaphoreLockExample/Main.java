package SemaphoreLockExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore=new Semaphore(3);


        ExecutorService service= Executors.newFixedThreadPool(50);
        IntStream.range(0,30).forEach(i->service.execute(new Task(semaphore,i)));

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
    }

}
