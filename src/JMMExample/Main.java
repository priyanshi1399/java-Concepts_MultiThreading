package JMMExample;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        // FieldVisibility obj = new FieldVisibility();
        // SynchronizedFieldVisibility obj=new SynchronizedFieldVisibility();

        //LockVisibility obj=new LockVisibility();
        //for (int i = 0; i < 1_000_0; i++) {
            VolatileVisibility obj = new VolatileVisibility();
            Thread writer = new Thread(() -> {
                obj.writerThread();
            });
            Thread reader = new Thread(() -> {
              /*remove in case of volatile Visibility
                try {
                    Thread.sleep(4000); // Let writerThread run first
                } catch (InterruptedException e) {
                }*/
                obj.readerThread();
            });

            writer.start();
            //writer.join();


            reader.start();
           // reader.join();

       // }
    }
}
