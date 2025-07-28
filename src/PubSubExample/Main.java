package PubSubExample;

import PubSubExample.MyBlockingQueue;

public class Main {
    public static void main(String[] args) {


        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(2);
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Producing item  " + i);
                    queue.put(i);

                    Thread.sleep(100); // slow down producer

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                  //  Thread.sleep(100); // slower consumer
                    Integer take = queue.remove();
                    System.out.println("Item removed " + take);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        producer.start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        consumer.start();
    }
}

