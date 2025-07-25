package JMMExample;

public class FieldVisibility {

       volatile int x=0;
        int a=0,b=0,c=0;

    public void writerThread(){
        a=1;
        b=1;
        c=1;

        x=1;

    }

    public void readerThread(){
        int r2=x;

        int d1=a;
        int d2=b;
        int d3=c;

        /*if(r2==0){
            System.out.println("Reader saw 0");
        }
        else{
            System.out.println("Reader saw 1");
        }*/
        //System.out.println("Read x: " +r2);


        System.out.println("The value of a "+a);
        System.out.println("The value of b "+b);
        System.out.println("The value of c "+c);


    }
}
