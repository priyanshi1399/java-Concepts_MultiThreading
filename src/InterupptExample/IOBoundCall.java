package InterupptExample;

public class IOBoundCall implements  Runnable {

    public volatile boolean keepRunning1=true;
    @Override
    public void run() {
        System.out.println("thread started");
        while (keepRunning1){
            System.out.println("");
        }

        //trying to simlate jdbc call
        try {
            Thread.sleep(150000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //trying to simulate http
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //we can use jbbc and http client time out libraries which can have timeout for these

        System.out.println("Thread stops");
    }
}
