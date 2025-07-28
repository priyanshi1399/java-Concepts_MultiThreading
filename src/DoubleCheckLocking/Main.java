package DoubleCheckLocking;

public class Main {

    public static void main(String[] args) {

        Runnable task=()->{
            DoubleCheckExample obj=DoubleCheckExample.rs();
            obj.show();
        };

        Thread t1=new Thread(task);
        Thread t2=new Thread(task);
        Thread t3=new Thread(task);

        t1.start();
        t2.start();
        t3.start();
    }
}
