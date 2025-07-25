package Parallelism;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelExecutionDemo {

    public static void main(String[] args) {
        //Simulate 4-core CPU with a thread pool of size 4

        ExecutorService threadPool=Executors.newFixedThreadPool(4);

        for(int i=0;i<=10;i++){
            int taskId=i;

            threadPool.submit(()->{
                String threadName=Thread.currentThread().getName();
                System.out.println(" Task " +taskId +"started on "+threadName);
                try{
                    Thread.sleep(6000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println("Task "+taskId+" finished on "+threadName);
            });
        }
        threadPool.shutdown();

    }
}
