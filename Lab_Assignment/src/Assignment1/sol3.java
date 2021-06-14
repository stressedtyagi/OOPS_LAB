/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment1;
import java.util.Scanner;
/*
Write a java program to left and right rotate the array by a given number of positions.
(Number of positions to shift must be read from the console.)
Testcases:
    1)  Array: 9 5 7 2 6 3 8    Positions: 3
        Output:
            Left rotate: 2 6 3 8 9 5 7
            Right rotate: 6 3 8 9 5 7 2
*/
public class sol3 {
    public static void Print(int[] a) {
        for (int j : a) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public static void Input(int[] a) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
    }
    public static void LeftRotate(int[] a, int pos) {
        int n = a.length;
        int[] aux = new int[n];
        pos %= n;
        for(int i = 0; i < n; i++) {
            if(pos+i < n)
                aux[i] = a[pos+i];
            else
                aux[i] = a[pos+i-n];
        }
        for(int i = 0; i < n; i++)
            a[i] = aux[i];
    }
    public static void rightRotate(int[] a, int pos) {
        int n = a.length;
        int[] aux = new int[n];
        pos %= n;
        for(int i = 0; i < n; i++) {
            if(n-(pos-i) < n)
                aux[i] = a[n-(pos-i)];
            else
                aux[i] = a[n-(pos-i)-n];
        }
        for(int i = 0; i < n; i++)
            a[i] = aux[i];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array : ");
        int n = sc.nextInt();
        int[] a = new int[n];
        Input(a);

        System.out.print("Enter rotation amount : ");
        int RT = sc.nextInt();

        System.out.println("Left Rotated Array : ");
        LeftRotate(a,RT);
        Print(a);

        System.out.println("Right Rotated Array : ");
        rightRotate(a,2*RT);
        Print(a);
    }
}
