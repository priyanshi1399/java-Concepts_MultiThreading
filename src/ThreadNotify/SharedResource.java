package ThreadNotify;

public class SharedResource  {

    synchronized void waitHere(){
        try{
            System.out.println(Thread.currentThread().getName() +" is waiting..");
            wait();
            System.out.println(Thread.currentThread().getName() + "resumed");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    synchronized void notifyOne(){
        System.out.println("notify called: "+"-"+"only one thread resumed");
        notify();
    }

    synchronized void notifyAllThread(){
        System.out.println("notifyAll called: "+"-"+"All thread resumed");
        notifyAll();
    }

}
