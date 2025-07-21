public class ThreadMain {

    public static void main(String [] args){

        IntThread t1=new IntThread("My first thread with P : 10" );

        //t1.setPriority(10);
       // t1.start();
        t1.run();
        IntThread t2=new IntThread("My second thread");
        t2.setDaemon(true); //low priority background task
        t2.start();

        System.out.println("Thread Name: "+t2.getName());
        System.out.println("Thread ID :"+t2.getId());

        for(int i=0;i<10;i++){
            System.out.println("Int Thread" +i);
        }
        //t2.start(); cannot do
    }

}
