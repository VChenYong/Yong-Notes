package core.java8.stream.collectingandthen;

import core.java8.pojos.Person;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

/**
 * Created by yong on 5/4/18.
 */
public class CollectingAndThenExample {

    static List<Person> employeeList
            = Arrays.asList(new Person("Tom Jones", 45, 15000.00),
            new Person("Ethan Hardy", 65, 8000.00),
            new Person("Deborah Sprightly", 29, 9000.00));

    public static void main(String[] args) {

        // finding the person wo has the highest salary
        String maxSalaryEmp = employeeList.stream().collect(
                collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Person::getSalary)),
                        (Optional<Person> emp) -> emp.map(Person::getName).orElse("none")));
        System.out.println("Max salaried employee's name: " + maxSalaryEmp);


        // find the average salary
        String avgSalary = employeeList.stream().collect(
                collectingAndThen(
                        Collectors.averagingDouble(Person::getSalary),
                        averageSalary -> new DecimalFormat("'$'0.00").format(averageSalary)));
        System.out.println("Average salary in $: " + avgSalary);

        //List<String> result = employeeList.stream().collect(collectingAndThen(toList(), ImmutableList::copyOf))
    }
}


    /*Definition of Collectors.collectingAndThen() method
        Collectors.collectingAndThen() method is defined with the following signature –
       public static<T,A,R,RR> Collector<T,A,RR>
        collectingAndThen(Collector<T,A,R> downstream, Function<R,RR> finisher)

        Where,
        – 1st input parameter is downstream which is an instance of a Collector<T,A,R>
           i.e. the standard definition of a collector. In other words, any collector can be used here.
        – 2nd input parameter is finisher which needs to be an instance of a
           Function<R,RR> functional interface.
           This function instance takes as input an object of type R which is the output from downstream
           collector, and it returns an output of type RR which is the final return type of collectingAndThen
            collector as well.

        – output is a Collector with finisher(return type) of type RR.

        How the Collectors.collectingAndThen() method works
        CollectingAndThen() method first collects the elements of type T of Stream<T> using the Collector<T,A,R>
        passed to it as the first parameter. As a result of applying the collector,
        stream elements are collected into an object of type R. Using the Function<R,RR>
        instance passed as the second parameter, the collected object of type R is then transformed
        to an object of type RR. This object of type RR is the final object/value returned by the
        collectingAndThen collector.

        Thus, when there is a scenario where the stream elements need to be collected and then the collected
        object needs to be transformed using a given rule\function, then using the collectingAndThen collector
         both these tasks of collection and transformation can be specified and executed together.*/

    //https://www.javabrahman.com/java-8/java-8-how-to-use-collectors-collectingandthen-method-with-examples/