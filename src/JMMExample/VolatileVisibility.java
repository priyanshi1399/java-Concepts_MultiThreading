package JMMExample;

public class VolatileVisibility {

   volatile boolean flag=false;
    //int counter=0;
    public void writerThread(){
        flag=true;
    }

    public void readerThread(){
        while(!flag){
            //wait
        }

        //System.out.println("reader executed ");

    }
}
