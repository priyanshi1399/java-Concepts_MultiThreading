package ThreadLocal;

import java.text.SimpleDateFormat;

public class ThreadSafeFormatter {

    public static ThreadLocal<SimpleDateFormat> dateformatter=new ThreadLocal<SimpleDateFormat>(){


        protected SimpleDateFormat initivalue(){
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override
        public SimpleDateFormat get(){
            return super.get();
        }
    };
}
