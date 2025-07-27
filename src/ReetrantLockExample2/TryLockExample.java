package ReetrantLockExample2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {


    ReentrantLock lock=new ReentrantLock();

    public void accessResourceExample(String threadName){
        try {
            System.out.println(threadName +"is trying to acquire the lock");
            boolean lockAcquired = lock.tryLock(5, TimeUnit.SECONDS);
            if(lockAcquired){
                try{
                System.out.println(threadName +"acquired the lock");
                Thread.sleep(7000);
            } finally {
                   lock.unlock();
                }
            }
            else{
                System.out.println("not acquired  doing something else");
            }
        }
        catch(InterruptedException e){

        }
    }
}
