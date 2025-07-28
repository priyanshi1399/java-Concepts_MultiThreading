package ScatterGatherpattern;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> result=FetchPrice.getPrices(5);
        System.out.println("Collected price"+result);

    }
}
