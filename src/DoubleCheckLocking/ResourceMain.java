package DoubleCheckLocking;

public class ResourceMain {
    public static void main(String[] args) {

        Runnable task=()->{
           Resource r= Singleton.rs();
            System.out.println(Thread.currentThread().getName() +" got field "+r.field1);
        };

       for(int i=0;i<=10000;i++){
           Thread t=new Thread(task, "Thread-"+i);
           t.start();
       }
    }
}
