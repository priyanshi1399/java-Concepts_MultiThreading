package ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> map=new ConcurrentHashMap<>();

        map.put("Priyanshi",1);
        map.put("Hanuman",10);
        map.put("Liara",80);
        map.put("Krishna",20);

        System.out.println("concurrent map is"+map.toString());

        map.compute("Priyanshi",(k,v)->(v==null?1:v+1));


        map.computeIfAbsent("Hari",k->70);

        System.out.println("New concurrent map is"+map.toString());

        System.out.println(map.get("Priyanshi"));

        try{
            map.computeIfAbsent(null,k->60);

        }
        catch(Exception e){
            System.out.println("Exception: "+e);
        }
    }


}
