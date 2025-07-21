package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Employeee {

    private String name;
    private int age;

    public Employeee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employeee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employeee employeee)) return false;
        return age == employeee.age && Objects.equals(name, employeee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main(String[] args) {
        List<Employeee> employees= Arrays.asList(new Employeee("Priyanshi",31),
                new Employeee("Shekhar",30),
                new Employeee("Anurag",39),
                new Employeee("Utkrash",39),
                new Employeee("Priya",78),
                new Employeee("Rahul",19),
                new Employeee("Twinkle",30));

        //grouping employee names by their age
        Map<Integer,List<String>> groupEmployeebyAge=employees.
                stream().collect(Collectors.groupingBy(Employeee::getAge,Collectors.mapping(Employeee::getName,Collectors.toList())));

        System.out.println(groupEmployeebyAge);
        groupEmployeebyAge.forEach((age,empName)->{
            System.out.println(age);
            System.out.println(empName);
        });

        Map<Integer,Map<String,List<Employeee>>> groupEmployeeByAge=employees.stream().
                collect(Collectors.groupingBy(
                        Employeee::getAge,Collectors.groupingBy(Employeee::getName)));

        groupEmployeeByAge.forEach((age,empMap)->{
            System.out.println(age);
            empMap.forEach((name,empList)->{
                System.out.println(name);
                empList.forEach(System.out::println);
            });
        });
    }
}
