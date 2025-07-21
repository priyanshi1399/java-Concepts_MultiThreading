package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Employee {
    private String name;
    private int age;
    public  Employee(String name, int age){
        this.name=name;
        this.age=age;
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
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("John", 38);
        Employee e2 = new Employee("Tim", 33);
        Employee e3 = new Employee("Andrew", 33);
        Employee e4 = new Employee("Peter", 38);
        Employee e5 = new Employee("Nathan", 22);
        Employee e6 = new Employee("George", 23);
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);

       Map<Integer,List<Employee>> groupbyAge=employees.stream().
               collect(Collectors.groupingBy(Employee::getAge));

        groupbyAge.forEach((age,empList)->{
            System.out.println(age);
            empList.forEach(System.out::println);

       });


        List<String> fruits=Arrays.asList("Apple","Banana","Orange","Papaya","Strawberry","Apple","Orange","Orange");
        Map<String,Long> getFruitByFrequency=fruits.stream().collect(Collectors.
                groupingBy(Function.identity(),Collectors.counting()));

        getFruitByFrequency.forEach((name,value)->{
            System.out.println(name +":" +value);
            //System.out.println(value);
        });

    }
}
