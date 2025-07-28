package ScatterGatherUsingCompletableFuture;

import java.util.Random;
import java.util.Set;

public class Task implements  Runnable{

    private final String url;
    private final int productId;
    private final Set<Integer> prices;

    public Task(String url, int productId, Set<Integer> prices) {
        this.url = url;
        this.productId = productId;
        this.prices = prices;
    }


    @Override
     public void run() {

        int price=fetchPrice(url,productId);
        prices.add(price);
        System.out.println("Price of the products is"+price);
    }

    public int fetchPrice(String url,int productId){
        return 10*new Random().nextInt(50);
    }
}
