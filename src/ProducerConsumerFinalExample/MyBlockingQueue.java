package ProducerConsumerFinalExample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue <E>{

    ReentrantLock lock=new ReentrantLock();
    private Condition notEmpty=lock.newCondition();
    private Condition notFull=lock.newCondition();

    Queue<E> queue;
    int maxSize;

    public MyBlockingQueue(int maxSize){
        queue=new LinkedList<>();
        this.maxSize=maxSize;
    }

    public void put(E ele){
        lock.lock();
        try{
            while(queue.size()==maxSize){ //it is full
                System.out.println("Queue is FULL. Producer waiting...");
                notFull.await();// waiting to get notFull condition
            }
            queue.add(ele);
            System.out.println("added element"+ele);
            notEmpty.signalAll(); //not empty signal I have added the element
        }
        catch(InterruptedException e){

        }
        finally {
            lock.unlock();
        }
    }

    public E remove(){
        lock.lock();
        try{
            while(queue.isEmpty()){ //it is Empty
                System.out.println("Queue is Empty. Consumer waiting...");
                notEmpty.await();// waiting to get notEmpty condition
            }
            E val= queue.poll();
            System.out.println("removed element..." +val + "Queue size : "+queue.size());
            notFull.signalAll(); //not empty signal I have removed the element
            return val;
        }
        catch(InterruptedException e){
                throw  new RuntimeException();
        }
        finally {
            lock.unlock();
        }
    }


}
