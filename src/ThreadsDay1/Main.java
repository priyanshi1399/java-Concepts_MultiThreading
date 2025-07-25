package ThreadsDay1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Going Inside main method " + Thread.currentThread().getName());
        MultiThreadedLearning runnableObj=new MultiThreadedLearning();
        Thread t1=new Thread(runnableObj); //pass this object
        t1.start();
        System.out.println("Finish main Method" + Thread.currentThread().getName());
    }
}
