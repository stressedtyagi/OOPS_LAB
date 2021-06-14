/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package MIDSEM;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class SortedArrayException extends Exception {
    SortedArrayException(String str) {
        super(str);
    }
}

class DuplicateValue extends Exception {
    DuplicateValue(String str) {
        super(str);
    }
}
public class q1 {
    private static HashMap<Integer,Integer> mp = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n ");
        int n = sc.nextInt();
        FileWriter writer = null;
        try {
            writer = new FileWriter("output.txt");
            if(n < 3) {
                System.out.println("Value of N less than 3");
                System.exit(0);
            }
            ArrayList<Integer> arrayList = new ArrayList<Integer>(n*n);

            boolean duplicate = true;
            for (int i = 0; i < n*n; i++) {
                int x = sc.nextInt();
                arrayList.add(x);
            }
            boolean check = false;
            boolean inc = true;
            if(arrayList.get(0) > arrayList.get(1)) {
                inc = false;
            }
            for (int i = 1; i < n*n; i++) {
                if(inc) {
                    if(arrayList.get(i-1) > arrayList.get(i)) {
                        check = true;
                        break;
                    }
                }else {
                    if(arrayList.get(i-1) < arrayList.get(i)) {
                        check = true;
                        break;
                    }
                }
                if(arrayList.get(i-1) != arrayList.get(i))
                    duplicate = false;
            }

            if(!check)  {
                throw new SortedArrayException("Array is Sorted");
            }
            if(duplicate) {
                throw new DuplicateValue("All values are same");
            }
            for (int i = 0; i < n*n; i++) {
                writer.write(arrayList.get(i) + " ");
            }
            writer.close();
        }catch (IOException | SortedArrayException | DuplicateValue e) {
            e.printStackTrace();
        }

        FileReader fileReader = null;
        BufferedReader buff = null;
        int[][] matrix = new int[n][n];
        try {
            fileReader = new FileReader("output.txt");
            buff = new BufferedReader(fileReader);
            String str = buff.readLine();
            String[] arr = str.split(" ");

            int index = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(arr[index++]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        printMazePaths(0,0,n-1,n-1,matrix[0][0],matrix);
        boolean isUnique = true;
        try {
            FileWriter file = new FileWriter("result.txt");
            for (Integer key:
                    mp.keySet()) {
                if(mp.get(key) > 1) {
                    isUnique = true;
                    file.write(key + " " + mp.get(key) + "\n");
                }
            }
            if(isUnique == false) {
                file.write(-1 + "");
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void printMazePaths(int sr, int sc, int dr, int dc, int csf,int[][] matrix) {
        if(sr == dr && sc == dc){
            if(mp.containsKey(csf)) {
                mp.put(csf,mp.get(csf)+1);
            }else {
                mp.put(csf,1);
            }
            return;
        }
        if(sc+1 <= dc) {
            printMazePaths(sr, sc + 1, dr, dc, csf + matrix[sr][sc+1],matrix);
        }
        if(sr+1 <= dr) {
            printMazePaths(sr + 1, sc, dr, dc, csf + matrix[sr+1][sc],matrix);
        }
    }
}
