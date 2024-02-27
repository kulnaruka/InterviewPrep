package basicprogramsforinterview.designpattern.builderDesignPatternDog.entities;

import org.jetbrains.annotations.NotNull;

public class Dog {
    private String name; //Optional
    private String gender; //Cannot change
    private String breed; //Cannot change
    private double price;

    public Dog(@NotNull DogBuilder dogBuilder) {
        this.breed = dogBuilder.getBreed();
        this.gender = dogBuilder.getGender();
        this.name = dogBuilder.getName();
        this.price = dogBuilder.getPrice();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", breed='" + breed + '\'' +
                ", price=" + price +
                '}';
    }

    private void setName(String name) {
        this.name = name;
    }
    private void setPrice(double price) {
        this.price = price;
    }
    private void setGender(String gender) {
        this.gender = gender;
    }
    private void setBreed(String breed) {
        this.breed = breed;
    }
    public String getGender() {
        return gender;
    }
    public String getName() {
        return name;
    }
    public String getBreed() {
        return breed;
    }
    public double getPrice() {
        return price;
    }


    //Inner class
    public static class DogBuilder {
        public String name; //Optional
        private String gender; //Cannot change
        private String breed; //Cannot change
        private double price;

        public DogBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public DogBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public DogBuilder setBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public DogBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public String getName() {
            return name;
        }
        public String getGender() {
            return gender;
        }
        public String getBreed() {
            return breed;
        }
        public double getPrice() {
            return price;
        }
        public Dog build() {
            return new Dog(this);
        }
    }
}
