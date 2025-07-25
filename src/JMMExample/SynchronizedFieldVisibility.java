package JMMExample;

public class SynchronizedFieldVisibility {

    int x=0;
    int a=0,b=0,c=0;

    public void writerThread(){
        a=1;
        b=1;
        c=1;

        synchronized (this){
            x=1;
        }
    }

    public void readerThread(){

        synchronized (this){
            int r2=x;
        }

        int d1=a;
        int d2=b;
        int d3=c;

        System.out.println("The value of a "+a);
        System.out.println("The value of b "+b);
        System.out.println("The value of c "+c);

    }

}
