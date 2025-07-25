package VolatileExample;

public class Main {
    public static void main(String[] args) {

        SharedData data = new SharedData();

        Thread t1=new Thread(()->{
            try{
                Thread.sleep(1000);

            }
            catch(Exception e){

            }
            data.flag=true;
            System.out.println("Writer: flag set to true");
        });

        t1.start();


        Thread t2=new Thread(()->{

            while(!data.flag){
                //busy wait
            }
            System.out.println("Reader detected flag=true");
        });

        t2.start();

    }
}
