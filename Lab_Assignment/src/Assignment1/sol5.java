/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment1;

import java.util.Scanner;

class Shape {
    public String name;
    public String getName() {
        return name;
    }
};

class Circle extends Shape{
    public Double radius;
    Circle () {
       name = "Circle";
    }
    public void calculate() {
        Double area = Math.PI*Math.pow(radius,2);
        System.out.println("Area of " + new Circle().getName() + ": " + String.format("%.2f",area));
    }
};

class Cylinder extends Circle {
    private Double height;
    Cylinder (Double radius, Double height) {
        name = "Cylinder";
        this.radius = radius;
        this.height = height;
    }
    public void calculate() {
        super.calculate();
        Double area = 2*Math.PI*radius*(height+radius);
        System.out.println("Area of " + this.getName() + ": " + String.format("%.2f", area
        ));
    }
};

public class sol5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Radius: ");
        Double r = sc.nextDouble();
        System.out.print("Height: ");
        Double h = sc.nextDouble();
        Cylinder C = new Cylinder(r,h);
        C.calculate();
    }
}
