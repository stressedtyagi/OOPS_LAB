/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment2.sol6;
import Assignment2.sol6.addition.*;
import Assignment2.sol6.division.divide;
import Assignment2.sol6.multiplication.*;
import Assignment2.sol6.subtraction.*;

import java.util.Scanner;

public class sol6 extends divide {
    public static void main(String[] args) {
        Double num1, num2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1st number : ");
        num1 = sc.nextDouble();
        System.out.print("Enter 2nd number : ");
        num2 = sc.nextDouble();

        System.out.println("!! Select Operation !!");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        int option;
        option = sc.nextInt();

        switch (option) {
            case 1: {
                System.out.println("Addition of both is : " + new add(num1,num2).getResult());
                break;
            }
            case 2: {
                System.out.println("Subtraction of both is : " + new sub(num1,num2).getResult());
                break;
            }
            case 3: {
                System.out.println("Multiplication of both is : " + new mul(num1,num2).getResult());
                break;
            }
            case 4: {
                System.out.println("Division of both is : " + new sol6().getResult(num1,num2));
                break;
            }
            default: {
                System.out.println("Incorrect choice");
                break;
            }
        }
    }

    @Override
    public Double getResult(Double n1, Double n2) {
        return n1/n2;
    }
}
