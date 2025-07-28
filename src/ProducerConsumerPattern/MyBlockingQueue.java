package ProducerConsumerPattern;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {
    ReentrantLock lock=new ReentrantLock(true);
    private Condition notFull=lock.newCondition();
    private Condition notEmpty=lock.newCondition();

    Queue<E> queue;
    int maxSize;

    public MyBlockingQueue(int maxSize){
        queue=new LinkedList<>();
       this. maxSize=maxSize;
    }

    public void put(E element){
        lock.lock();
        try{
            while(queue.size()==maxSize){
                notFull.await();
            }
            queue.add(element);
            notEmpty.signalAll();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }


    public E remove(){
        lock.lock();
        try{
            while(queue.isEmpty()){
                notEmpty.await();
            }
            E val= queue.poll();
            notFull.signalAll();
            return val;
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            throw new RuntimeException();

        }
        finally {
            lock.unlock();
        }
    }
}
