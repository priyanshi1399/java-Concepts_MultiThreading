package LockConditionMet;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        ConditionMetExample conditionMet=new ConditionMetExample();

        Thread t1=new Thread(()->{
            try {
                conditionMet.method1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2=new Thread(()->{
            try {
                conditionMet.method2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

    }
}
