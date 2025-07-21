package ThreadNotify;

public class NotifyALlExample {
    public static void main(String[] args) throws InterruptedException {
        SharedResource shared = new SharedResource();

        // Create 3 threads that will wait on shared
        Runnable task = () -> {
            shared.waitHere();
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        // Start all threads
        t1.start();
        t2.start();
        t3.start();

        // Wait a little to ensure all threads go into waiting state
        Thread.sleep(1000);

        // Wake up all waiting threads
        synchronized (shared) {
            System.out.println("Main thread is calling notifyAll...");
            shared.notifyOne();
           // shared.notifyAll();  // Wakes up all 3 waiting threads
        }
    }
}
