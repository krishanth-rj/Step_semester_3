package data_structures.class_problems;

import java.util.Scanner;

public class DigitSumAndNumberReversal {
    public static long[] sumAndReverse(long number) {
        long remaining = number, sum = 0, reversed = 0;
        while (remaining > 0) {
            long digit = remaining % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            remaining /= 10;
        }
        return new long[] {sum, reversed};
    }

    public static void main(String[] args) {
        long number = new Scanner(System.in).nextLong();
        long[] result = sumAndReverse(number);
        System.out.println("Sum of digits: " + result[0]);
        System.out.println("Reverse: " + result[1]);
    }
}
