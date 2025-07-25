package Parallelism;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentExample {

    private static int isTicketAvaialble=1;
    private static ReentrantLock lock=new ReentrantLock();

    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            lock.lock();
            try {
                if (isTicketAvaialble > 0) {
                    bookTicket();
                }
                isTicketAvaialble--;
            }
            catch(Exception e){

            }
            finally{
                lock.unlock();
            }
        });

        Thread t2=new Thread(()->{
            lock.lock();
            try {
                if (isTicketAvaialble > 0) {
                    bookTicket();
                }
                isTicketAvaialble--;
            }
            catch(Exception e){

            }
            finally{
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
    }

        public static void bookTicket() {
            System.out.println("Ticket booked by " + Thread.currentThread().getName());
        }
    }

