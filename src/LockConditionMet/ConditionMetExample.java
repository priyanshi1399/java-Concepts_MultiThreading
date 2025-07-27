package LockConditionMet;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionMetExample {

    private Lock lock=new ReentrantLock();

    private Condition conditionMet=lock.newCondition();

    public void method1() throws InterruptedException{
        lock.lock();
        try{
            Thread.sleep(2000);
            System.out.println("Thread1  waiting...");
            conditionMet.await(); //suspend here
            System.out.println("After condition t1 resume here..");
        }
        catch(Exception e){

        }
        finally {
            lock.unlock();
        }
    }

    public void method2() throws InterruptedException{
        lock.lock();
        try{
            Thread.sleep(2000);  // Simulate work before signaling
            System.out.println("Thread 2 doing some work and signaling...");
            conditionMet.signal(); //suspend here
        }
        catch(Exception e){

        }
        finally {
            lock.unlock();
        }
    }
}
