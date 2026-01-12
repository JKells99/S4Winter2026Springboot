package com.keyin.javareview;


/*
* this
* Is
* MultiLine
* */
public class Animal {
     //  POJO: Fields - > Constructors -> get/set -> Methods - > ToString
    private String name;
    private int age;
    private String color;
    private String countryOfOrigin;

    // Constructor
    public Animal(String name, int age, String color, String countryOfOrigin) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.countryOfOrigin = countryOfOrigin;
    }

    public Animal() {
    }
    // Getters and Setters
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public void makeNoise(){
        System.out.println("Animal makes noise");
    }
    // ToString Method
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                '}';
    }
}
