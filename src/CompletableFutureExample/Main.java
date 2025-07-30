package CompletableFutureExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CalculateAsync calculateAsync = new CalculateAsync();
        System.out.println("The value of calculateAsync : " + calculateAsync.calculateAsync().get());

        System.out.println(calculateAsync.future);


        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> System.out.println("Hello Priyanshi Mam"));

//return a completablefuture value
        CompletableFuture<String> future2 =
                CompletableFuture.supplyAsync(() -> "I am Learning");
        System.out.println(future2.get());

//it transforms the values and then return into new completable future
        CompletableFuture<String> future3 = CompletableFuture.
                supplyAsync(() -> "priyanshi").thenApply(s -> s + "is a good girl");
        System.out.println(future3.get());


        //it consumes the result

        CompletableFuture<Void> future4 = CompletableFuture.
                supplyAsync(() -> "priyanshi").thenAccept(s -> System.out.println("computation returned : " + s));
        System.out.println(future4.get());

        //runs a task when previous stage is completed but dosent access the result
        CompletableFuture<Void> future5 = CompletableFuture.
                supplyAsync(() -> "priyanshi").thenRun(() -> System.out.println("computation returned"));
        System.out.println(future5.get());

        /*CompletableFuture<String> future6=CompletableFuture.supplyAsync(()->"Hello")
                .thenCompose(s->CompletableFuture.supplyAsync(()->s +" Priyanshi How are you"));

        System.out.println(future6.get());*/


        CompletableFuture<String> future6 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " Priyanshi How are you"));

        System.out.println(future6.get());

        CompletableFuture<String> future7 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " Priyanshi How are you"));

        System.out.println(future7.get());


        CompletableFuture<String> future8 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(() -> "World"), (s1, s2) -> s1 + s2);
        System.out.println(future8.get());


        CompletableFuture<Void> future9 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> "Singh"), (s1, s2) -> System.out.println(s1 + s2));
        System.out.println(future9.get());


        CompletableFuture<Integer> result =
                CompletableFuture.supplyAsync(() -> 10)
                        .thenApply(i -> i + 1);  // adds 1
        System.out.println(result.get());


        CompletableFuture<Integer> result1 =
                CompletableFuture.supplyAsync(()->10).thenCompose(i->CompletableFuture.supplyAsync(()->i+20));  // adds 1
        System.out.println(result1.get());
    }
         CompletableFuture<Integer> computeAnother (Integer i){
            return CompletableFuture.supplyAsync(() -> i + 10);
        }

        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> 5)
                .thenCompose(i -> computeAnother(i));



}

