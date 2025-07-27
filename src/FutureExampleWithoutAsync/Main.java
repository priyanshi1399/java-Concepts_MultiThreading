package FutureExampleWithoutAsync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

        ExecutorService service= Executors.newFixedThreadPool(10);

        Future<Integer> f=service.submit(new Task());

        try{
            System.out.println("Main thread before get()");
            Integer result = f.get(); // will wait here

            System.out.println("Main thread after get()");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
