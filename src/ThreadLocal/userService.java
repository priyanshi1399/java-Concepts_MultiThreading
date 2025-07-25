package ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class userService {

    private static final ExecutorService threadPool= Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws InterruptedException {

        for(int i=0;i<10;i++){
            int id=i;
            Thread t1=new Thread(()->{
                String birthDate=new UserService2().birthDate(id);
                System.out.println("User "+id +":" +birthDate);

            });
            t1.start();
        }

        Thread.sleep(2000);
        threadPool.shutdown();
    }

    /*public static String birthDate(int userId){
        Date birthDate=birthDateFromDB(userId);
        SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
        return df.format(birthDate);
    }
*/

    //by using dateFormatter
    public String birthDate(int userId){
        Date birthDate=birthDateFromDB(userId);
        final SimpleDateFormat df=ThreadSafeFormatter.dateformatter.get();
        return df.format(birthDate);
    }
    private  static Date birthDateFromDB(int userId) {
        // Just simulate fetching different birth dates based on userId
        Calendar cal = Calendar.getInstance();
        cal.set(1990 + userId, Calendar.JANUARY, 1); // user 0 = 1990-01-01, etc.
        return cal.getTime();
    }
}
