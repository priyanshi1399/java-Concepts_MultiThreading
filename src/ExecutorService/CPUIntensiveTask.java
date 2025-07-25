package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main1 {
    public static void main(String[] args) {
    //get the count of available cores
        int coreCount=Runtime.getRuntime().availableProcessors();
        ExecutorService service= Executors.newFixedThreadPool(coreCount);

        for(int i=0;i<100;i++){
            service.execute(new CPUIntensiveTask());
        }
    }
}

public class CPUIntensiveTask implements  Runnable{
    @Override
    public void run() {
        //cpu intensive operation
      //  System.out.println("Thread Name "+Thread.currentThread().getName());
    }
}
