public class MainRun  {

    public static  void main(String [] args){

        GenerateRandomNumberUsingThread gen=new GenerateRandomNumberUsingThread();
        Thread t1=new Thread(gen);
        t1.start();

        for(int i=0;i<10;i++){
            System.out.println("Main : " +i);
        }
    }
}
