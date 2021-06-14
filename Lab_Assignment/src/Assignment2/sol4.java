/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment2;
/*
Create a class named 'Rectangle' with two data members 'length' and 'breadth' and two methods to print
the area and perimeter of the rectangle respectively. Its constructor having parameters for length and
breadth is used to initialize length and breadth of the rectangle. Let class 'Square' inherit the 'Rectangle'
class with its constructor having a parameter for its side (suppose s) calling the constructor of its parent
class as 'super(s,s)'. Print the area and perimeter of a rectangle and a square.
*/

import java.util.Scanner;

//class Rectangle {
//    Rectangle(int length, int breadth) {
//        this.length = length;
//        this.breadth = breadth;
//    }
//
//    private int length, breadth;
//    public void printArea() {
//        System.out.println("Area : " + length*breadth);
//    }
//    public void printPerimeter() {
//        System.out.println("Perimeter : " + 2*(length+breadth));
//    }
//}
//class Square extends Rectangle {
//    Square(int side) {
//        super(side,side);
//    }
//}
public class sol4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of side of Square : ");
        int side = sc.nextInt();

        Square sq = new Square(side);
        System.out.println("Square :- ");
        sq.printArea();
        sq.printPerimeter();

        System.out.print("Enter Length of Rectangle : ");
        int length = sc.nextInt();
        System.out.print("Enter Height of Rectangle : ");
        int height = sc.nextInt();

        Rectangle rec = new Rectangle(length,height);
        System.out.println("Rectangle :- ");
        rec.printArea();
        rec.printPerimeter();
    }
}
