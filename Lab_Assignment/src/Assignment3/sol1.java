/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment3;

public class sol1 {
    public static void main(String[] args) {
        System.out.println("Null pointer Exception");

        try {
            System.out.println("1. Invoking a method from a null object");
            String str = null;
            String str1 = "hello";
            if(str.equals(str1)) {
                System.out.println("Str equals to hello");
            }else {
                System.out.println("Str not eqal to hello");
            }
        }catch (NullPointerException exp) {
            System.out.println("NullPointerException : Case 1");
        }
        System.out.println("---------------------------------------");
        try {
            System.out.println("2. Accessing or modifying a null object’s field");
            Integer x = null;
            x++;
            System.out.println("New Value of x is : " + x);
        }catch (NullPointerException exp) {
            System.out.println("NullPointerException : Case 2");
        }
        System.out.println("---------------------------------------");
        try {
            System.out.println("3. Taking the length of null, as if it were an array");
            int arr[] = null;
            System.out.println("Length of array is : " + arr.length);
        }catch (NullPointerException exp) {
            System.out.println("NullPointerException : Case 3");
        }
        System.out.println("---------------------------------------");
        try {
            System.out.println("4. Throwing null, as if it were a Throwable value");
            throw null;
        }catch (NullPointerException exp) {
            System.out.println("NullPointerException : Case 4");
        }
    }
}
