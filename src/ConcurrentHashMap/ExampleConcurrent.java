package ConcurrentHashMap;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ExampleConcurrent {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,Integer> map=new ConcurrentHashMap<>();
        Set<Integer> set=map.keySet();
        map.put(1,2);
        map.put(2,3);

        Iterator<Integer> it=map.keySet().iterator();
        while(it.hasNext()){
             int val=it.next();
             map.put(3,5);

        }

        set.forEach(System.out::println);


    }
}
