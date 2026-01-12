package com.keyin.javareview;

import java.util.Arrays;

public class TwoDemArrays {
    public static void main(String[] args) {
        int [][] numbers = new int[5][5];
        for (int[] number : numbers) {
            Arrays.fill(number, 0);
        }
        numbers[2][3] = 5;
        // Access a specific element
//        System.out.println(numbers[1][2]);

        // Changing a specific element
//        numbers[1][2] = 8;
//        System.out.println(numbers[1][2]);
//        System.out.println("Rows" + numbers.length);
//        System.out.println("Columns" + numbers[0].length);
//        System.out.println("Columns" + numbers[1].length);
        for(int[] row : numbers){
            for(int num : row){
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
