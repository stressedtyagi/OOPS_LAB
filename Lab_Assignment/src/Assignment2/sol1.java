/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment2;
class Parent {
    public void printParent() {
        System.out.println("This is parent class");
    }
}
class Child extends Parent {
    public void printChild() {
        System.out.println("This is child class");
    }
}
public class sol1 {
    public static void main(String[] args) {
        Parent p1 = new Parent();
        Child c1 = new Child();
        System.out.println("1. Calling method of parent class by object of parent class");
        p1.printParent();
        System.out.println("2. Calling method of child class by object of child class");
        c1.printChild();
        System.out.println("2. Calling method of parent class by object of child class");
        c1.printParent();
    }
}
