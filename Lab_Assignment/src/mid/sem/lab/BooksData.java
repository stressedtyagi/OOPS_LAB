/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package mid.sem.lab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BooksData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = null;
        Book books[] = new Book[6];
        for(int i = 0; i < 6; i++) {
            String isFiction;
            System.out.print("Name of book: ");
            name= sc.nextLine();
            System.out.print("Enter 'y' or 'Y' for fiction and 'n' or 'N' for non fiction : ");
            isFiction= sc.nextLine();
            if(isFiction.equals("y") || isFiction.equals("Y")) {
                books[i] = new Fiction(name);
            }
            else {
                books[i] = new NonFiction(name);
            }
        }

        // calculating total costs of all books
        double sum = 0;
        for(int i = 0; i < 6; i++) {
            sum += books[i].getPrice();
        }
        System.out.print("Total Cost of all books: " + sum);
        // file handling
        try {
            File myObj = new File("BooksData.txt");
            myObj.createNewFile();
            FileWriter fw = new FileWriter("BooksData.txt",true);
            for(int i = 0; i < 6; i++) {
                fw.write(books[i].getTitle()+" "+books[i].getPrice()+"\n");
                fw.flush();
            }
            fw.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}