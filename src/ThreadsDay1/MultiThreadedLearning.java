package ThreadsDay1;

public class MultiThreadedLearning implements Runnable{

    @Override
    public void run() {
        System.out.println("Code executed by thread" +Thread.currentThread().getName());
    }
}
