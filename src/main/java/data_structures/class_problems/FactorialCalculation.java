package data_structures.class_problems;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialCalculation {
    public static BigInteger factorial(int number) {
        if (number < 0) throw new IllegalArgumentException("Factorial is undefined for negative values.");
        BigInteger result = BigInteger.ONE;
        for (int factor = 2; factor <= number; factor++) result = result.multiply(BigInteger.valueOf(factor));
        return result;
    }

    public static void main(String[] args) {
        int number = new Scanner(System.in).nextInt();
        System.out.println(factorial(number));
    }
}
