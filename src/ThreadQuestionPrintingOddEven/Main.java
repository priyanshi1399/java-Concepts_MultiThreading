package ThreadQuestionPrintingOddEven;

public class Main {
    public static void main(String[] args) {


        SharedResource resource=new SharedResource();

        Thread even=new Thread(()->{
                    resource.printEven();
        });


        Thread odd=new Thread(()->{
            resource.printOdd();
        });

        even.start();
        odd.start();

    }
}
