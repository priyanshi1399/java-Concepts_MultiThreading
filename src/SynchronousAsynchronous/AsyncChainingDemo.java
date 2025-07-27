package SynchronousAsynchronous;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class AsyncChainingDemo {

    public static void main(String[] args)  throws InterruptedException{

        List<Integer> employeeIds= IntStream.rangeClosed(1,5).boxed().toList();

        for(Integer id:employeeIds){
                    CompletableFuture.supplyAsync(()->fetchEmployee(id))
                            .thenApplyAsync(employee->  fetchTaxRate(employee))
                            .thenApplyAsync(taxRate->calculateTax(taxRate))
                            .thenAcceptAsync(taxValue->sendEmail(taxValue));
            }

        Thread.sleep(5000);
        System.out.println(ForkJoinPool.commonPool().getParallelism());
        }


    public static  String fetchEmployee(int id){
        simluteDelay("Fetching employee "+id);
        return "Employee "+id;
    }

    public static  double fetchTaxRate(String employee){
        simluteDelay("Fetching tax rate for "+employee);
        return 0.2;
    }

    public static  double calculateTax(Double rate){
        simluteDelay("Fetching tax rate for "+rate);
        return 0.2;
    }

    public static  void sendEmail(Double taxValue){
        simluteDelay("sending Email" +taxValue);
    }

    public static  void simluteDelay(String message){
        try{
            System.out.println(Thread.currentThread().getName() + "-" +message);
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
