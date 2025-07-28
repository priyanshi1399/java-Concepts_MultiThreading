package ScatterGatherpattern;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public  class Task implements Runnable{

    private final CountDownLatch latch;
    private final String url;
    private final int  productId;
    private final Set<Integer> prices;

    public Task(String url, int productId, Set<Integer> prices,CountDownLatch latch) {
        this.url = url;
        this.productId = productId;
        this.prices = prices;
        this.latch=latch;
    }



    @Override
    public void run() {
        int price=fetchPricefromURl(url,productId);
        prices.add(price);
        System.out.println("Price added from url"+price);
        latch.countDown();
    }

    public int fetchPricefromURl(String url,int productId){
        return productId*10+new Random().nextInt(50);
    }
}
