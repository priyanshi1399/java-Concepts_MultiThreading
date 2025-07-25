package AtomicIntegerExample;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

   AtomicInteger count=new AtomicInteger(0);
   // int count=0;
    void increment(){
       count.incrementAndGet();
       // count++;
    }

    int getCount(){
        return count.get();
       // return count;
    }
}
