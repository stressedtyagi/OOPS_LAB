/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment2;

import java.util.Scanner;

class Rectangle {
    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    private int length, breadth;
    public void printArea() {
        System.out.println("Area : " + length*breadth);
    }
    public void printPerimeter() {
        System.out.println("Perimeter : " + 2*(length+breadth));
    }
}
class Square extends Rectangle {
    Square(int side) {
        super(side,side);
    }
}
public class sol5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Square[] sq = new Square[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("--------------------------------------------");
            System.out.print("Enter length of side of Square " + (i+1) + " : ");
            int side = sc.nextInt();
            sq[i] = new Square(side);
            sq[i].printArea();
            sq[i].printPerimeter();
            System.out.println("--------------------------------------------");
        }
    }
}
