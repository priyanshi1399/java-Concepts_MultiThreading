package RaceCondition;

import java.util.concurrent.locks.ReentrantLock;

public class AtomicExample {

    private  static int counter=0;
    private static ReentrantLock lock=new ReentrantLock();

    public static void main(String[] args) {

        Thread t1=new Thread(()->{

            for(int i=0;i<1000;i++) {
                lock.lock();
                try {
                    counter++;
                } finally {
                    lock.unlock();
                }
            }

        });

        Thread t2=new Thread(()->{

            for(int i=0;i<1000;i++) {
            lock.lock();
            try {
                counter++;
            } finally {
                lock.unlock();
            }
        }

    });


        t1.start();

        t2.start();

       try{
           t1.join();
           t2.join();
       }
       catch(InterruptedException e){
       }

        System.out.println("Counter value is upadted by "+Thread.currentThread().getName() + "value is "+counter);
    }
}
