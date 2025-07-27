package SynchronousAsynchronous;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ASynchronousExampleExecutor {

    public static void main(String[] args) {

        List<Integer> employeeIds= IntStream.rangeClosed(1,5).boxed().toList();
        ExecutorService service= Executors.newFixedThreadPool(3);
        for(Integer id:employeeIds){
            service.submit(()->{
                try{
                    String employee=fetchEmployee(id);
                    Double taxRate=fetchTaxRate(employee);
                    Double taxValue=calculateTax(taxRate);
                    sendEmail(taxValue);
                }
                catch(Exception e){

                }
            });

        }
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
