package basicprogramsforinterview.designpattern.builderDesignPatternDog;

import basicprogramsforinterview.designpattern.builderDesignPatternDog.entities.Dog;

/**
 * The Builder Design Pattern is a creational design pattern used to construct complex objects step by step.
 * It aims to solve the problem of telescoping constructors, where the number of constructor parameters grows rapidly,
 * making it difficult to understand and use the class.
 * Instead of using multiple constructors with different parameter combinations,
 * the Builder pattern provides a separate builder class responsible for constructing the object with a
 * more fluent and readable interface.
 *
 * -> Why to use and benefits of using builder design patterns:
 *
 * This make easier for the clients(Classes where the Dog Class is required) to construct the objects depending on the
 * parameters they want to pass inorder to construct it.
 * All post creating of Dog class and the usage of this dog object by clients, it makes the addition of any new variable
 * convenient
 */

public class BuilderDesignPattern {

    public static void main(String[] args) {

        Dog dog1 = new Dog.DogBuilder().setName("Kuldeep").build();
        Dog dog2 = new Dog.DogBuilder().setName("Kuldeep").setBreed("Human").build();
        Dog dog3 = new Dog.DogBuilder().setName("Kuldeep").setBreed("Human").setGender("M").build();
        Dog dog4 = new Dog.DogBuilder().setName("Kuldeep").setBreed("Human").setGender("M").setPrice(17).build();

        System.out.println (dog1);
        System.out.println (dog2);
        System.out.println (dog3);
        System.out.println (dog4);
    }
}
