package Streams;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Itemm {

    private String name;
    private int qty;
    private BigDecimal price;

    public Itemm(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {

        List<Itemm> items = Arrays.asList(new Itemm("apple", 10, new BigDecimal("9.99")),
                new Itemm("banana", 20, new BigDecimal("19.99")),
                new Itemm("orange", 10, new BigDecimal("29.99")),
                new Itemm("watermelon", 10, new BigDecimal("29.99")),
                new Itemm("papaya", 20, new BigDecimal("9.99")),
                new Itemm("apple", 10, new BigDecimal("9.99")),
                new Itemm("banana", 10, new BigDecimal("19.99")),
                new Itemm("apple", 20, new BigDecimal("9.99"))
        );

        Map<String, Integer> itemNameGroupByQty = items.stream().
                collect(Collectors.groupingBy(Itemm::getName, Collectors.summingInt(Itemm::getQty)));

        itemNameGroupByQty.forEach((name,Qty)->{
            System.out.println(name +" :" +Qty);

        });

        //with function,supplier,collector
        Map<BigDecimal, Set<String>>  sortedItemsByPrice=items.stream().
                collect(Collectors.groupingBy(Itemm::getPrice,TreeMap::new,Collectors.mapping(Itemm::getName,Collectors.toSet())));

        System.out.println(sortedItemsByPrice);
    }
    
}
