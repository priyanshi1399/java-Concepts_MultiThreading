package PubSubExample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

    Queue<E> queue;
    int maxSize;

    public MyBlockingQueue(int maxSize){
        queue=new LinkedList<>();
        this. maxSize=maxSize;
    }

    public void put(E element){
        synchronized (this) {

            try {
                while (queue.size() == maxSize) {
                    System.out.println("Queue size is full..waiting for producer");
                    wait();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            queue.add(element);
            notifyAll();
            System.out.println("Added the element"+element);
        }
    }


    public E remove() {
        synchronized (this) {
            try {
                while (queue.isEmpty()) {
                    System.out.println("Queue is empty ..waiting for consumer");
                    wait();
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException();

            }
            E val = queue.poll();
            notifyAll();
            System.out.println("removed element "+val);
            return val;
        }
    }
}
