package SuspendExample;

public class Main {

    public static void main(String[] args) {

        SharedResource resource=new SharedResource();

        System.out.println("Main Thread started");

        Thread th1=new Thread(()->{
            System.out.println("Thread1 calling produce method");
            resource.produce();
        });

        Thread th2=new Thread(()->{
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){

            }
            System.out.println("Thread2 calling produce method");
            resource.produce();
        });

        th1.start();
        th2.start();

        try{
            Thread.sleep(3000);
        }
        catch(Exception e){

        }
        System.out.println("Thread1 is suspended");
        th1.suspend();


        try{
            Thread.sleep(3000);
        }
        catch(Exception e){

        }
        //th1.resume();
        System.out.println("Main Thread is finishing the work");
    }
}
