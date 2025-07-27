package FutureExampleWithoutAsync;

import java.util.Random;
import java.util.concurrent.Callable;

public class Task implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(5000);
        return new Random().nextInt();
    }
}
