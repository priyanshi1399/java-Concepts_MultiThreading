package Streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamQuestions {
    public static void main(String[] args) {

        List<Integer> number=List.of(1,2,3,4,6,8,10);
        Optional<Integer> evenNumberSum=number.stream().filter(num->num%2==0).reduce(Integer::sum);
        evenNumberSum.ifPresent(System.out::println);


    }
}
