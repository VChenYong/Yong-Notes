package core.java8.example;



import core.java8.pojos.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yong on 3/13/18.
 */

public class StreamGroupExample {

    public static void main(String[] args) {
        Stream<Person> peopleSteam = Stream.of(new Person("Paul", 24, 20000), new Person("Mark", 30, 30000), new Person("Will", 28, 28000),
                new Person("Will", 28, 18000), new Person("Will", 29, 38000), new Person("William", 28, 28000));

        List<Person> people = peopleSteam.collect(Collectors.toList());


        // group by person's name and then age mapping to list of Person

        Map<String, Map<Integer, List<Person>>> map = people.stream().collect(
                Collectors.groupingBy(Person::getName, Collectors.groupingBy(Person::getAge)));

        System.out.println(map);
        // group by person's age and then name mapping to list of salaries
        Map<Integer, Map<String, List<Double>>> ageNameSalaries = people.stream().collect(
                Collectors.groupingBy(Person::getAge,
                        Collectors.groupingBy(Person::getName, Collectors.mapping((Person p) -> p.getSalary(), Collectors.toList()))));

        // group by person's age and mapping to list of person's name.

        Map<Integer, List<String>> peropleByAge = people.stream().collect(
                Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));

        // group by person's name and sum the total age of person with same name (
        // using reducing)
        Map<String, Integer> sumAgeByName = people.stream().collect(
                Collectors.groupingBy(Person::getName, Collectors.reducing(0, Person::getAge, Integer::sum)));

        // group by person's name and sum the total age of person with same name (
        // using summingInt)
        Map<String, Integer> sumAgeByName002 = people.stream().collect(
                Collectors.groupingBy(Person::getName, Collectors.summingInt(Person::getAge)));

    }

}
