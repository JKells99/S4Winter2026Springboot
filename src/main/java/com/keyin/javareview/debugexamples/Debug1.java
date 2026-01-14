package com.keyin.javareview.debugexamples;

public class Debug1 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 5; i++) {
            // BUG: Accidentally double-counting when i == 3
            if (i == 3) {
                sum += i;
            }
            sum += i;  // Place a breakpoint here
            System.out.println("Sum after adding " + i + " is: " + sum);
        }

        // Use the debugger to inspect 'sum' after each iteration.
        System.out.println("Final Sum: " + sum);
    }
}
