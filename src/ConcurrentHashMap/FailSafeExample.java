package ConcurrentHashMap;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> map=new ConcurrentHashMap<>();

        map.put("Priyanshi",1);
        map.put("Hanuman",10);
        map.put("Liara",80);
        map.put("Krishna",20);
        int count=0;
        Iterator<String> itr=map.keys().asIterator();
        while(itr.hasNext()){
            String key = itr.next();
            map.put("Hari", 50);
            count++;
        }
        System.out.println(count);
    }


}
