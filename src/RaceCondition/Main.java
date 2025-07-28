package RaceCondition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock=new ReentrantLock();
        HashMap<String,String> map=new HashMap<String,String>();


       // lock.lock();
        Thread t1=new Thread(()-> {

            if (!map.containsKey("book 1")) {
                lock.lock();
                try {
                    Thread.sleep(100);
                    map.put("book1", "Thread-1");
                    System.out.println("value changed by " +Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                finally {
                    lock.unlock();
                }

            }
        });
       // lock.unlock();


        Thread t2=new Thread(()-> {

            if (!map.containsKey("book 1")) {
                lock.lock();
                try {
                    Thread.sleep(100);
                    map.put("book1", "Thread-2");
                    System.out.println("Vlaue upodated by "+Thread.currentThread().getName());

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                finally {
                    lock.unlock();
                }



            }
        });


        t1.start();
        t2.start();
        t1.join();
        t2.join();



        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(Thread.currentThread().getName() +"upadated the value");
            System.out.println(entry.getKey() +": " +entry.getValue());
        }


    }
}
