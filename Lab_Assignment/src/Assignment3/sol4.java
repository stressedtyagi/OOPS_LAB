/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment3;

import java.util.Scanner;

class OutOfBounds extends Exception {
    OutOfBounds(String str) {
        super(str);
    }
}
public class sol4 {
    public static long factorial(long x) throws OutOfBounds, IllegalAccessException {
        if(x < 0)
            throw new IllegalAccessException("Value of x is too small");
        if(x > 20)
            throw new OutOfBounds("Result will overflow");
        long fact = 1;
        for(int i = 2; i <= x; i++) {
            fact *= i;
        }
        return fact;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Value of X: ");
        int x = sc.nextInt();
        try {
            System.out.println("Factorial: " + factorial(x));
        }catch (OutOfBounds | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
