package Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamQuestion {
    public static void main(String[] args) {
        //List of even number
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> numberList = numbers.stream().filter(x -> x % 2 == 0).peek(System.out::println).collect(Collectors.toList());

        // numberList.forEach(System.out::println);
        System.out.println("------------------------------------------------------");
        List<Integer> nums = List.of(1, 2, 3, 7, 5, 8, 6, 4);
        int target = 10;
        //all pairs that sum to a given Number

        List<List<Integer>> pairs = nums.stream().flatMap(i -> nums.stream().filter(j -> i < j && i + j == target)
                .map(j -> List.of(i, j))).collect(Collectors.toList());

        System.out.println(pairs);

        System.out.println("________________________________________________________");
        //find first String that starts with letter "C"

        List<String> names = List.of("Alice", "Bob", "Charlie", "Priyanshi", "Charu");

        Optional<String> firstNameStartsWithC=names.stream().filter(name->name.startsWith("C")).findFirst();

        firstNameStartsWithC.ifPresent(System.out::println);

        System.out.println("---------------------------------------------------------------");

        //Find the sum of Squares of number in the list
        List<Integer> number=List.of(1,2,3,4);

        //int sumOfSquares=number.stream().map(x->x*x).reduce(0,(a,b)->a+b);
        int sumOfSquares=number.stream().map(x->x*x).reduce(0,Integer::sum);

        System.out.println(sumOfSquares);

        System.out.println("--------------------------------------------------------------------------");

        //sort a List into descending Order (reverse Alphabetical Order)

        List<String> fruits=List.of("banana","apple","papaya","strawberry");

        List<String> fruit=fruits.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println(fruit);

        System.out.println("--------------------------------------------------------");

        //Group word by their length

        List<String> words=List.of("one","two","three","four","five");
        Map<Integer,List<String>> groupBywordLength=words.stream().collect(Collectors.groupingBy(String::length));

        System.out.println(groupBywordLength);
        groupBywordLength.forEach((key,value)-> System.out.println(key +": " +value));

        System.out.println("----------------------------------------------------------------");
        //find the maximum number in the List
        List<Integer>  numbersList=List.of(10,20,5,80,40,90);

        //Optional<Integer> maxNumber=numbersList.stream().max(Comparator.naturalOrder());

        Optional<Integer> maxNumber=numbersList.stream().max(Integer::compare);

       maxNumber.ifPresent(System.out::println);

        System.out.println("--------------------------------------------------------");
        //how many String starts with "A"

        List<String> nameList=List.of("Anjali","Priyanshi","Shekhar","Utkarsh","Antara","Adi");

      //  Long countStratWithA=nameList.stream().filter(name->name.startsWith("A")).collect(Collectors.counting());

        Long countStratWithA=nameList.stream().filter(name->name.startsWith("A")).count();
        System.out.println(countStratWithA);

        System.out.println("------------------------------------------------------------------------------");
        //group them by Anagram Set

        List<String> wordsList=List.of("listen","silent","enlist","rat","tar","art");
        Map<String,List<String>> groupByAnagram=wordsList.stream().collect(Collectors.
                groupingBy(word->word.chars().
                        sorted().
                        mapToObj(c->String.valueOf((char)c))
                        .collect(Collectors.joining())));

        System.out.println(groupByAnagram);

        System.out.println("-------------------------------------------------------------");
        //convert a list of list into a Single list

        List<List<String>> nestedList=List.of(List.of("a","b"),
                List.of("c","d"),
                List.of("e","f"));
        List<String> flatList=nestedList.stream().
                flatMap(Collection::stream).
                collect(Collectors.toList());
        System.out.println(flatList);

        System.out.println("------------------------------------------------");

        //return List of the string "even" or "odd" depending on whether the number is even or odd.
        List<Integer> numberLists=List.of(1,2,3,4,5);

        List<String> numList=numberLists.stream().map(x->x%2==0?"even":"odd").collect(Collectors.toList());

        System.out.println(numList);

        System.out.println("-----------------------------------------------------------------");

        //list of sentences count the frequency of each word(case -insensitive)
        List<String>  sentences=List.of("Java is fun","Streams are Powerful","Java is Powerful");
        Map<String,Long> wordFreq=sentences.stream()
                .flatMap(sentence->Arrays.stream(sentence.toLowerCase()
                        .split("\\s+")))
                .collect(Collectors.groupingBy(word->word,Collectors.counting()));

      //  wordFreq.forEach((word, count) -> System.out.println(word + ": " + count));





    }
}
