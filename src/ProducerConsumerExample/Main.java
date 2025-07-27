package ProducerConsumerExample;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args)  {

    SharedResource resource=new SharedResource();

    Thread produce=new Thread(()->{
       int i=1;
       while(i<=10){
           try {
               resource.produce("item" +i);
               Thread.sleep(1000);
               i++;
           }
           catch(Exception e){

           }
       }
    });

        Thread consume=new Thread(()->{
            int i=1;
            while(i<=10){
                try {
                    resource.consume();
                    i++;
                }
                catch(Exception e){

                }
            }
        });

        produce.start();
        consume.start();
    }
}
