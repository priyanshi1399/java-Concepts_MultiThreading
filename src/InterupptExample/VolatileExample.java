package InterupptExample;

public class VolatileExample {

    public static void main(String[] args) {

        MyTask task=new MyTask();
        Thread t1=new Thread(task);
        t1.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        task.keepRunning=false;


        IOBoundCall task1=new IOBoundCall();
        Thread t2=new Thread(task1);
        t2.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        task1.keepRunning1=false;
    }



}
