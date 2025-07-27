package ReadWriteLockExample2;

public class Main {
    public static void main(String[] args) {
    SharedResource resource=new SharedResource();

    Thread t1=new Thread(()->{
        resource.readResource();
    });

        Thread t2=new Thread(()->{
            resource.readResource();
        });

        Thread t3=new Thread(()->{
            resource.writeResources();
        });

        Thread t4=new Thread(()->{
            resource.writeResources();
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
