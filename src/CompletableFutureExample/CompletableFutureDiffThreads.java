package CompletableFutureExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDiffThreads {

    public static void main(String[] args) {

        ExecutorService cpuIntensivetask= Executors.newFixedThreadPool(4);
        ExecutorService ioBound=Executors.newCachedThreadPool();

        for(int i=0;i<100;i++){
            int orderId=i;

            List<CompletableFuture<Void>> futures=new ArrayList<>();
            CompletableFuture<Void> future=CompletableFuture.supplyAsync(() -> getOrder(orderId),cpuIntensivetask)
                    .thenApplyAsync((order) -> enrichOrder(order),ioBound)
                    .thenApplyAsync((order) -> payment(order),cpuIntensivetask)
                    .thenApplyAsync((order) -> dispatchOrder(order))
                    .thenAcceptAsync((order) -> sendEmail(order));

            futures.add(future);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cpuIntensivetask.shutdown();
        ioBound.shutdown();
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

