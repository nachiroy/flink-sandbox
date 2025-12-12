package org.example.pojoflinkjob;

public class Person {
    public String name;
    public Integer age;

    // Default constructor
    public Person() {}

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Person{name='" + this.name + "', age=" + this.age + "}";
    }
}
