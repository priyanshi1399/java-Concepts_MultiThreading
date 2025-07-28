package ProducerConsumerFinalExample;

import java.util.Queue;

public class Main{
    public static void main(String[] args) throws InterruptedException {


        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(2);

        Thread produce = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("producing element " + i);
                queue.put(i);


            }
        });


        Thread consume = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                Integer take = queue.remove();
                System.out.println("removing element " + take);

            }
        });

        produce.start();
        Thread.sleep(2000);
        consume.start();
    }
}
