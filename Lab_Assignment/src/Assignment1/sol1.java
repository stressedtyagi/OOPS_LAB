/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment1;
import java.util.Scanner;

/*
Write a java program to implement the following. Create two user defined arrays
with different sizes (unsorted) then sort these arrays and finally merge them
*/
public class sol1 {
    public static void Sort(int a[]) {
        for(int i = 1; i < a.length; i++) {
            int j = i-1;
            int ele = a[i];
            while(j >= 0) {
                if(a[j] > ele) {
                    a[j+1] = a[j];
                }else {
                    break;
                }
                j--;
            }
            a[j+1] = ele;
        }
    }
    public static void Print(int a[]) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void Input(int a[]) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of first Array : ");
        int n = sc.nextInt();
        int a[] = new int[n];
        Input(a);

        System.out.print("Enter Size of second Array : ");
        int m = sc.nextInt();
        int b[] = new int[m];
        Input(b);

        Sort(a);
        Sort(b);
        System.out.println("Sorted Array 1 : ");
        Print(a);
        System.out.println("Sorted Array 2 : ");
        Print(b);

        // Merging of arrays
        int r[] = new int[n+m];
        int i = 0, j = 0, k = 0;
        while(i < n && j < m) {
            if(a[i] < b[j]) {
                r[k++] = a[i++];
            }else {
                r[k++] = b[j++];
            }
        }
        while(i < n) {
            r[k++] = a[i++];
        }
        while(j < m) {
            r[k++] = b[j++];
        }
        System.out.println("Final Merged Sorted Array : ");
        Print(r);
    }
}
