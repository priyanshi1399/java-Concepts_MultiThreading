package CompletableFutureExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    public static void main(String[] args) {
        List<CompletableFuture<Void>> futures=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int orderId = i;

            CompletableFuture<Void> future=CompletableFuture.supplyAsync(() -> getOrder(orderId))
                    .thenApply((order) -> enrichOrder(order))
                    .thenApply((order) -> payment(order))
                    .thenApply((order) -> dispatchOrder(order))
                    .thenAccept((order) -> sendEmail(order));

            futures.add(future);
        }
        futures.forEach(CompletableFuture::join);

    }
    public static String getOrder(int id ){
        String order="order" +id;
        System.out.println(Thread.currentThread().getName() + "-" +"fetched" +order);
        return order;

    }

    public static String enrichOrder(String order ){

        System.out.println(Thread.currentThread().getName() + "-" +"enriched" +order);
        return order +"enriched";

    }

    public static String payment(String order ){

        System.out.println(Thread.currentThread().getName() + "-" +"payment completed for " +order);
        return order +"payment done";

    }

    public static String dispatchOrder(String order ){

        System.out.println(Thread.currentThread().getName() + "-" +"dispached " +order);
        return order +"dispached";

    }

    public static void sendEmail(String order ){

        System.out.println(Thread.currentThread().getName() + "-" +"email sent for " +order);


    }
}
