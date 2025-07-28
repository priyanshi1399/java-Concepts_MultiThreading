package ScatterGatherUsingCompletableFuture;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public   class FetchPrice {

    public static Set<Integer> getPrices(int productId) {
        Set<Integer> price = Collections.synchronizedSet(new HashSet<>());

        CompletableFuture<Void> task1 = CompletableFuture.runAsync(new Task("url", productId, price));
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(new Task("url", productId, price));
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(new Task("url", productId, price));



        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
        try {
            allTasks.get(3, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }

        return price;
    }
}
