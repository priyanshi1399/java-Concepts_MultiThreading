package ConcurrentModificationExample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyThread  extends  Thread{

    static List<String> l1=new ArrayList<>();

    public void run(){
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
        System.out.println("Child thread is trying to update the collection");
        l1.add("D");
    }
    public static void main(String[] args) throws InterruptedException {
        l1.add("A");
        l1.add("B");
        l1.add("C");

        MyThread t1=new MyThread();
        t1.start();

        Iterator itr=l1.iterator();
        while(itr.hasNext()){
            String s1=(String)itr.next();
            System.out.println("Main thread ierating and child thread is updating");
            Thread.sleep(2000);
        }
        System.out.println();
    }
}
