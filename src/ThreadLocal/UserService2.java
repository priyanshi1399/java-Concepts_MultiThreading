package ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserService2 {

    //ThreadLocal to make SimpleDateFormat thread safe

    private static  final ThreadLocal<SimpleDateFormat> threadLocalFormatter=
            ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd"));

    public String birthDate(int userId){
        Date birthDate=birthDateFromDB(userId);
        return threadLocalFormatter.get().format(birthDate);
    }

    private Date birthDateFromDB(int userId) {
        Calendar cal = Calendar.getInstance();
        cal.set(1990 + userId, Calendar.JANUARY, 1);
        return cal.getTime();
    }
}
