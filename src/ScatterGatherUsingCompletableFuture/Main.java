package ScatterGatherUsingCompletableFuture;

import java.util.Set;

public class Main {

    public static void main(String[] args) {


        Set<Integer> price = FetchPrice.getPrices(4);
        System.out.println("prices of the stocks "+price);
    }
}
