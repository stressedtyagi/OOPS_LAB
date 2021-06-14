/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment1;

import java.util.Scanner;

// Write a java program to determine whether a given matrix is sparse matrix or not.
// Sparse Matrix condition : no. of zeroes should exceed (r*c)/2
public class sol2 {
    public static void Input(int[][] mat) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
    }
    public static void Print(int[][] mat) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean SparseCheck(int[][] mat,int r, int c) {
        int zeros = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(mat[i][j] == 0) zeros++;
            }
        }
        return (zeros >= (r*c)/2 ? true : false);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows of matrix : ");
        int r = sc.nextInt();
        System.out.print("Enter number of columns of matrix : ");
        int c = sc.nextInt();

        int mat[][] = new int[r][c];
        Input(mat);
        System.out.println("Matrix : ");
        Print(mat);

        if(SparseCheck(mat,r,c)) {
            System.out.println("This is a sparse matrix");
        }else {
            System.out.println("This is not a sparse matrix");
        }

    }
}
