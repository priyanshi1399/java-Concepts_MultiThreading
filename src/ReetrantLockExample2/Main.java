package ReetrantLockExample2;

public class Main {

    public static void main(String[] args) throws InterruptedException {
       /* SharedResources resources=new SharedResources();

        Thread t1=new Thread(()->{
            resources.accessResource();
        });
//
//        Thread t2=new Thread(()->{
//            resources.accessResource();
//        });

        t1.start();
       // t2.start();
*/
        TryLockExample res=new TryLockExample();

        Thread th1=new Thread(()-> {

            res.accessResourceExample("Thread-1");
        });

        Thread th2=new Thread(()-> {
            res.accessResourceExample("Thread-2");
        });


        th1.start();
        Thread.sleep(100);
        th2.start();
    }
}
