/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class MoreThanKException extends Exception {
    MoreThanKException(String str) {
        super(str);
    }
}
public class sol3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Value of K: ");
        int k = sc.nextInt();
        try {
            FileInputStream fin = new FileInputStream("readFile.txt");
            BufferedInputStream bin = new BufferedInputStream(fin);
            if(bin.available() > 0) {
                byte[] bts = bin.readAllBytes();
                if(bts.length > k)
                    throw new MoreThanKException("Number of characters in file are <" + bts.length + "> i.e more than K");

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MoreThanKException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
