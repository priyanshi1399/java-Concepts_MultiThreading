import java.util.concurrent.atomic.AtomicInteger;

public class CompareSet {

    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(100);

        boolean isSuccess=atomicInteger.compareAndSet(100,110);

        System.out.println(isSuccess);

        isSuccess=atomicInteger.compareAndSet(100,120);

        System.out.println(isSuccess);
    }
}
