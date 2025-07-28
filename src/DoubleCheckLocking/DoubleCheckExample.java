package DoubleCheckLocking;

public class DoubleCheckExample {

    private static volatile DoubleCheckExample rs;

    public DoubleCheckExample() {
        System.out.println("Expensive constructor called");
    }

    public static DoubleCheckExample rs(){
        if(rs==null){
            synchronized (DoubleCheckExample.class){
                if(rs==null){
                    rs=new DoubleCheckExample();
                }
            }
        }
        return rs;
    }
    public void show(){
        System.out.println("Hello from Singleton");
    }
}
