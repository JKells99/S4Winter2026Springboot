package com.keyin.javareview.errorhandling;

import java.util.Objects;

public class ErrorhandlingExamples {

    // No Error Handling
    public int divide(int a, int b){
        try {
            return a/b;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // Error handling
    public void divideWithErrorHandling(int a, int b){
        try {
            if(b == 0){
                throw new IllegalArgumentException("Cannot divide by zero");
            }
            int result = a/b;
            System.out.println("Result is " + result);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Finally block executed");
        }

    }
    // No Error Handling
    public int getValue(int[] numbers, int index){
        return numbers[index];
    }
    // Error Handling
    public int getValueWithErrorHandling(int[] numbers, int index){
        Objects.requireNonNull(numbers, "Array cannot be null");
        try {
            if(index <0 || index >= numbers.length){
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for array of length " + numbers.length);
            }
            return numbers[index];
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }
    // No Error Handling
    public int getusernameLength(String username){
        return username.length();
    }
    // Error Handling
    public int getusernameLengthWithErrorHandling(String username){
        Objects.requireNonNull(username, "Username cannot be null");
        try {
            if(username.isBlank()){
                throw new IllegalArgumentException("Username cannot be blank");
            }
            return username.length();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
    // No Error Handling
    public double parsePrice(String input){
        return Double.parseDouble(input);
    }
    // Error Handling
    public double parsePriceWithErrorHandling(String input){
        Objects.requireNonNull(input,"Price cannot be null");
        try{
            double price = Double.parseDouble(input);
            if(price < 0){
                throw new IllegalArgumentException("Price cannot be negative");
            }
            return price;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid price format");
        }
    }
    public static void main(String[] args) {
        ErrorhandlingExamples errorhandlingExamples = new ErrorhandlingExamples();
    }
}
