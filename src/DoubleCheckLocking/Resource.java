package DoubleCheckLocking;

public class Resource {
    int field1;

        public Resource(){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            field1=42;

        }
}
class Singleton{
    private static Resource rs=null;

    public static Resource rs(){
        if(rs==null){
            synchronized (Singleton.class) {
                if (rs == null) {
                    rs = new Resource();
                }
            }

        }
        return rs;
    }
}
