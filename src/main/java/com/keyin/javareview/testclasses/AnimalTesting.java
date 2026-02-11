package com.keyin.javareview.testclasses;

public class AnimalTesting  {
    // Dependency Injection Example
    private static AnimalDAO animalDAO = new AnimalDAO();

    public static void main(String[] args) {
        Animal animal = new Animal("Dog", 5, "Black", "USA");
//        System.out.println(animal);
//        animal.makeNoise();
//        System.out.println();
//        System.out.println();
//        Dog dog = new Dog("Fido", 3, "Black", "USA", "Labrador", "Large");
//        System.out.println(dog);
//        dog.makeNoise();

//        ArrayList<String> list = new ArrayList<>();
//        list.add("Hello");
//        list.add("World");
//        for(String word : list) {
//            System.out.println(word);
//        }
//        animalDAO.addAnimal(new Animal());

        // Conditional Statements
        int age = 30;
// If else Statement
//        if(age >= 18){
//            System.out.println("You can vote");
//        } else if (age >= 16) {
//            System.out.println("You can drive");
//        } else if (age > 18) {
//            System.out.println("You can vote and drive");
//        } else {
//            System.out.println("You are too young to vote or drive");
//
//        }
    // Switch Statement
//        switch (age){
//            case 16:
//                System.out.println("You can drive");
//                break;
//
//            case 18:
//                System.out.println("You can vote and drive");
//                break;
//
//            case 30:
//                System.out.println("You can drink alcohol");
//                break;
//            default:
//                System.out.println("Age not recognized");
//        }

//        Array [] array = new Array[10];
        animalDAO.addAnimal(animal);




    }


}
