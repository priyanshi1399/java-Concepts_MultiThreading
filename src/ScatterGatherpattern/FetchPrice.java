package ScatterGatherpattern;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FetchPrice {

    private static ExecutorService threadPool= Executors.newFixedThreadPool(4);

    public static  Set<Integer> getPrices(int productId){

         CountDownLatch latch=new CountDownLatch(3);
        Set<Integer> prices= Collections.synchronizedSet(new HashSet<>());
        threadPool.submit(new Task("url1",productId,prices,latch));
        threadPool.submit(new Task("url2",productId,prices,latch));
        threadPool.submit(new Task("url3",productId,prices,latch));

        try {
            latch.await(5, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return prices;

    }
}
