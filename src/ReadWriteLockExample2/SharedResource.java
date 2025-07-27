package ReadWriteLockExample2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock=lock.readLock();
    ReentrantReadWriteLock.WriteLock writeLock=lock.writeLock();

    public void readResource(){
        readLock.lock();
        ;
        try{
            System.out.println(Thread.currentThread().getName() +" is reading");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName() +" finished reading");
        }

    }
    public void writeResources(){
        writeLock.lock();
        ;
        try{
            System.out.println(Thread.currentThread().getName() +" is writing");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() +" finished writing");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();

        }

    }



}
