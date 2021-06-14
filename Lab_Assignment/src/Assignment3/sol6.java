/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment3;
/*
Write a java program to write name and phone numbers of 15 people inside a file
each line contains name and phone number. Now enter user defined variable called
phone number, you need to match (compare) this phone number against all the
phone numbers in the file, if matches then print corresponding name on to the
screen, if not present then throw a custom exception.
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class ElementNotFoundException extends Exception {
    ElementNotFoundException(String str) {
        super(str);
    }
}

public class sol6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileOutputStream fout = null;
        BufferedOutputStream buff = null;
        try {
            fout = new FileOutputStream("phoneDir.txt");
            buff = new BufferedOutputStream(fout);
            for (int i = 0; i < 3; i++) {
                System.out.println("Person : " + (i+1));
                String phoneNumber;
                String name;
                System.out.print("Name: ");
                name = sc.nextLine();
                name += " ";
                System.out.print("Phone Number: ");
                phoneNumber = sc.nextLine();
                byte bt[] = name.getBytes(StandardCharsets.UTF_8);
                buff.write(bt);
                bt = phoneNumber.getBytes(StandardCharsets.UTF_8);
                buff.write(bt);
                buff.write(System.getProperty("line.separator").getBytes());
            }
            buff.flush();
            buff.close();
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        String ph = null;
        System.out.print("Enter mobile number to search: ");
        ph = sc.nextLine();
        search(ph);
    }

    static void search(String phoneNumber) {
        boolean found = false;
        FileInputStream fout = null;
        DataInputStream in = null;
        BufferedReader br = null;
        try {
            fout = new FileInputStream("phoneDir.txt");
            in = new DataInputStream(fout);
            br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null)   {
                String[] tokens = strLine.split(" ");
                String phNo = null;
                if(tokens.length == 2) {
                    phNo = tokens[1];
                    if(phoneNumber.equals(phNo)) {
                        System.out.println("Corresponding name for Phone No " + phoneNumber + " this is : " + tokens[0]);
                        found = true;
                        break;
                    }
                }
                else if(tokens.length == 3) {
                    phNo = tokens[2];
                    if(phoneNumber.equals(phNo)) {
                        System.out.println("Corresponding name for Phone No " + phoneNumber + " this is : " + tokens[0] + " " + tokens[1]);
                        found = true;
                        break;
                    }
                }
            }
            br.close();
            in.close();
            fout.close();
            if(!found) {
                throw new ElementNotFoundException("Phone Number <" + phoneNumber + "> not found in record");
            }
        }catch (IOException | ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
