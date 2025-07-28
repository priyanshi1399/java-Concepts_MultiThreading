package InterupptExample;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyTask2  implements Callable {
    public boolean isRunning =true;

    @Override
    public Object call() throws Exception {
        System.out.println("Thread started");
        while(isRunning==true){
            System.out.println("");
        }
        return null;
    }

    public void stop(){
        isRunning=false;
        System.out.println("Stop called...");
    }
}
