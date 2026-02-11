package com.keyin.javareview.testclasses;

public class Dog extends Animal{
    String breed;
    String size;

    public Dog(String name, int age, String color, String countryOfOrigin, String breed, String size) {
        super(name, age, color, countryOfOrigin);
        this.breed = breed;
        this.size = size;
    }

    public Dog() {
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    // Methods
    @Override
    public void makeNoise() {
        System.out.println("Woof!");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", size='" + size + '\'' +
                "} " + super.toString();
    }
}
