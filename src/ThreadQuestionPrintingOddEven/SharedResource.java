package ThreadQuestionPrintingOddEven;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    private int counter = 1;
    private final int maxVal = 10;
    ReentrantLock lock = new ReentrantLock();
    Condition evenVal = lock.newCondition();
    Condition oddVal = lock.newCondition();


    public void printEven() {
        while (counter <= maxVal) {
            lock.lock();
            try {
                while (counter % 2 != 0) {
                    evenVal.await();
                }
                if (counter <= maxVal) {
                    System.out.println(counter + "is printed by "+Thread.currentThread().getName());
                    counter++;
                    oddVal.signalAll();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

        public void printOdd(){
            while (counter <= maxVal) {
                lock.lock();
                try {
                    while (counter % 2 == 0) {
                        oddVal.await();
                    }
                    if (counter <= maxVal) {
                        System.out.println(counter + " is printed by " +Thread.currentThread().getName() );
                        counter++;
                        evenVal.signalAll();
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

