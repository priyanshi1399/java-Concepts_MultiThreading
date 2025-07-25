package JoinExample;

import SuspendExample.SharedResource;

public class Main {
    public static void main(String[] args) {

        SuspendExample.SharedResource resource=new SharedResource();

        System.out.println("Main Thread started");

        Thread th1=new Thread(()->{
            System.out.println("Thread1 calling produce method");
            resource.produce();
        });

     //if I want other thread to compelete first then I can wait this is join..
        /*
        th1.start();
        try{
            System.out.println("Main thread is waiting for thread 1to finish");
            th1.join();//it activates agian  main thread
        }
        catch(Exception e){

        }

*/

         th1.setDaemon(true);
         th1.start();
        System.out.println("Main Thread is finishing its work");


    }
}
