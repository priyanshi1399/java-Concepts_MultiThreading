package JMMExample;

import java.util.concurrent.locks.ReentrantLock;

public class LockVisibility {

    ReentrantLock lock=new ReentrantLock();
    int x=0;
    int a=0,b=0,c=0;

    public void writerThread(){
        lock.lock();
        a=1;
        b=1;
        c=1;

        x=1;
        lock.unlock();

    }

    public void readerThread(){

        lock.lock();
        int r2=x;
        int d1=a;
        int d2=b;
        int d3=c;

        lock.unlock();
        System.out.println("The value of a "+a);
        System.out.println("The value of b "+b);
        System.out.println("The value of c "+c);

    }
}
