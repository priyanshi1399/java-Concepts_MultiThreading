package ReetrantLockExample2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResources {

     ReentrantLock lock=new ReentrantLock();

    public  void accessResource() {
        lock.lock();
        lock.lock();

        try {
            int number = lock.getHoldCount();
            //System.out.println(Thread.currentThread().getName()+ "Thread hold count "+number);
            if(number==2){
                accessResource();
            }
            System.out.println(Thread.currentThread().getName()+ "Thread hold count "+number);
        }

        catch(Exception e){

        }
        finally {
            lock.unlock();
            lock.unlock();
        }
    }
}
