package InterupptExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConditionalTimeoutExample {
    public static void main(String[] args) {

            MyTask task = new MyTask();

            Thread th1 = new Thread(task);
            th1.start();

            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

            scheduler.schedule(() -> {
                task.stop();
            }, 10, TimeUnit.MICROSECONDS);

            try {
            th1.join();

        }catch(InterruptedException e){
                e.printStackTrace();
            }

            scheduler.shutdown();
    }
}

