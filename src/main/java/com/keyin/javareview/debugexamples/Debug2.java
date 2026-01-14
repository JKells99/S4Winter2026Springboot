package com.keyin.javareview.debugexamples;

public class Debug2 {
    public static void main(String[] args) {
        int[] values = {2, 4, 6, 8, 10};
        for (int i = 0; i < values.length; i++) {
            // BUG: Accidentally printing the index instead of the value
            System.out.println("Processing value: " + i); // Should be values[i]
        }
        // Try setting a breakpoint inside the loop and inspect 'i' and 'values[i]'.
        // Use the debugger to step through each iteration and notice the output is not as expected.
        // Can you spot the bug by watching the variables?
    }
}
