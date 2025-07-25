package ConcurrentHashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ExampleCopyOnWrite {
    public static void main(String[] args) {

        //List<String> list = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        for (String s : list) {
            list.add("C");
        }
    }
}
