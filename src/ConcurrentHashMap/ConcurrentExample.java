package ConcurrentHashMap;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentExample {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer,Integer> newConcurrentHashMap=new ConcurrentHashMap<>();
        Set<Integer> threadSafeSet= ConcurrentHashMap.newKeySet();
        threadSafeSet.add(1);
        threadSafeSet.add(2);

        Iterator<Integer> iterator=threadSafeSet.iterator() ;
           while(iterator.hasNext()){
               int val=iterator.next();
               if(val==1){
                   threadSafeSet.add(9);
               }
           }

            

        threadSafeSet.forEach(System.out::println);
    }
}
