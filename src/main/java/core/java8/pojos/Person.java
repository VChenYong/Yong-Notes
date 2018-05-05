package core.java8.pojos;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by yong on 5/4/18.
 */
public class Person {

    private String name;

    private int age;

    private double salary;


    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("age", age)
                .append("salary", salary)
                .toString();
    }
}
