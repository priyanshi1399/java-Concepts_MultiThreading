package CallableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService service= Executors.newScheduledThreadPool(10);

        List<Future> allFutures=new ArrayList<>();
        for(int i=0;i<100;i++) {
            Future<Integer> future = service.submit(new Task());
            allFutures.add(future);
        }

        //100 future with 100 placeholders

// perform some unrelated operation

       //100 second
          for(int i=0;i<100;i++){
              Future<Integer> future=allFutures.get(i);
              try {
                  Integer result=future.get(1, TimeUnit.SECONDS); //blocking untill this future ready with reeturn value
                  System.out.println("Result of future # "+i + "="+result);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              } catch (ExecutionException e) {
                  throw new RuntimeException(e);
              } catch (TimeoutException e) {
                  throw new RuntimeException(e);
              }
          }
        //1 sec

        System.out.println("Thread Name " +Thread.currentThread().getName());
    }
}


/*other method
//if before the threadpool has started working on it then cancel it and never run on it
future.cancel(false); //if started then depend on interrupterability

future.isCancelled();

future.isDone(); //return true if task is completed successfully or failure

 */