package ThreadNotify;

public class NotifyExample {
    public static void main(String[] args)  throws InterruptedException {
        SharedResource sc = new SharedResource();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                sc.waitHere();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
        //give them time to start and wait
        Thread.sleep(1000);
        synchronized (sc) {
            sc.waitHere();
        }
        //and will pauseall
        //sc.notifyOne();
      sc.notifyAllThread();
        Thread.sleep(1000);

    }
}
