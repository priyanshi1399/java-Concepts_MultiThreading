package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main2 {
    public static void main(String[] args) {

        ExecutorService service= Executors.newFixedThreadPool(100);

        for(int i=0;i<100;i++){
            service.execute(new IOIntensiveOperation());
        }
    }
}

public class IOIntensiveOperation implements  Runnable {
    @Override
    public void run() {
        //IO intensive operation
        //  System.out.println("Thread Name "+Thread.currentThread().getName());
    }
}
