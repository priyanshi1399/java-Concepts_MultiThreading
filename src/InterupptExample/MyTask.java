package InterupptExample;

public class MyTask implements  Runnable{

    public volatile boolean keepRunning=true;
    @Override
    public void run() {
        System.out.println("thread started");
        while (keepRunning){
            System.out.println("");
        }

        System.out.println("Thread stops");
    }

    //added for checking conditional Timeout
    public void stop() {
        System.out.println("Stop called...");
        keepRunning=false;
    }

}
