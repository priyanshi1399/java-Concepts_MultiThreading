package ProducerConsumerExample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    private Lock lock = new ReentrantLock();
    private Condition added = lock.newCondition();
    private Condition removed = lock.newCondition();
    private int counter=1;
    Queue<String> buffer = new LinkedList<>();
    int maxSize = 5;

    public  void produce(String item)  {
        lock.lock();
        try {

            while (buffer.size() == maxSize) {
                System.out.println("buffer full.. producer waiting");
                removed.await();
            }
             item="Item"+counter++;
            buffer.add(item);
            System.out.println("produced.." +item);
            added.signal();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }

    }

    public  String consume() {
        lock.lock();
        try {

            while (buffer.isEmpty()) {
                added.await();
            }

            String data = buffer.poll();
            System.out.println("consumed :" +data);
            removed.signal();
            return data;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            lock.unlock();
        }

    }

}
