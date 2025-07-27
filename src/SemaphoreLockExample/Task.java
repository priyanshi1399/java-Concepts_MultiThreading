package SemaphoreLockExample;

import java.util.concurrent.Semaphore;

public class Task  implements  Runnable{

    private Semaphore semaphore;
    private int id;

    public Task( Semaphore semaphore,int id){
        this.semaphore=semaphore;
        this.id=id;
    }

    @Override
    public void run() {

        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + id + "acquiring permit");
            System.out.println("Available permits after acquiring: " + semaphore.availablePermits());
            Thread.sleep(4000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName()+ id + " releasing permit");
            System.out.println("Available permits after releasing: " + semaphore.availablePermits());
        }



    }
}
