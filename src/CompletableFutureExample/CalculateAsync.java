package CompletableFutureExample;

import java.util.concurrent.*;

public class CalculateAsync {


    public CompletableFuture<String> calculateAsync(){
        CompletableFuture<String> completableFuture=new CompletableFuture<>();
        ExecutorService executor=Executors.newCachedThreadPool();

        executor.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            completableFuture.complete("Hello Priyanshi");

        });
        return completableFuture;
    }
    Future<String > future=CompletableFuture.completedFuture("I am Priyanshi");


}