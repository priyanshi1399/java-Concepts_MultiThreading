package InterupptExample;

import java.util.concurrent.*;

public class CancelWithFuture {

    public static void main(String[] args) {

        ExecutorService threadPool=Executors.newFixedThreadPool(2);
        MyTask2 task = new MyTask2();


        Future<?> future= threadPool.submit(task);

        try{
            future.get(10, TimeUnit.MINUTES);
        }
        catch(TimeoutException | InterruptedException | ExecutionException e){
            future.cancel(true);
            task.stop();

        }
        threadPool.shutdown();

    }
}
