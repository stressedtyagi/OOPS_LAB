/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment2;

import javax.crypto.spec.PSource;
import java.util.Scanner;

/*
Create a class named 'Member' having the following members: Data members
    1 - Name
    2 - Age
    3 - Phone number
    4 - Address
    5 - Salary
It also has a method named 'printSalary' which prints the salary of the members. Two classes 'Employee'
and 'Manager' inherits the 'Member' class. The 'Employee' and 'Manager' classes have data members
'specialization' and 'department' respectively. Now, assign name, age, phone number, address and salary to
an employee and a manager by making an object of both of these classes and print the same.
*/
class Member {
    public String Name;
    public Integer Age;
    public String PhoneNumber;
    public String Address;
    public Integer Salary;

    public void printSalary() {
        System.out.println("Salary of Member is : " + Salary);
    }
}

class Employee extends Member {
    private String specialization, department;
    public void printEmployeeDetails() {
        System.out.println("-------------------------------------------------");
        System.out.println("Employee Details : ");
        System.out.println("Name : " + this.Name);
        System.out.println("Age : " + this.Age);
        System.out.println("Ph No. : " + this.PhoneNumber);
        System.out.println("Address : " + this.Address);
        this.printSalary();
        System.out.println("Specialization : " + this.specialization);
        System.out.println("Department: " + this.department);
        System.out.println("-------------------------------------------------");
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name : " );
        this.Name = sc.nextLine();
        System.out.print("Age : " );
        this.Age = Integer.parseInt(sc.nextLine());
        System.out.print("Ph No. : " );
        this.PhoneNumber = sc.nextLine();
        System.out.print("Address : ");
        this.Address = sc.nextLine();
        System.out.print("Salary : ");
        this.Salary = Integer.parseInt(sc.nextLine());
        System.out.print("Specialization : ");
        this.specialization = sc.nextLine();
        System.out.print("Department: ");
        this.department = sc.nextLine();
    }
}
class Manager extends Member {
    private String specialization, department;
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name : " );
        this.Name = sc.nextLine();
        System.out.print("Age : " );
        this.Age = Integer.parseInt(sc.nextLine());
        System.out.print("Ph No. : " );
        this.PhoneNumber = sc.nextLine();
        System.out.print("Address : ");
        this.Address = sc.nextLine();
        System.out.print("Salary : ");
        this.Salary = Integer.parseInt(sc.nextLine());
        System.out.print("Specialization : ");
        this.specialization = sc.nextLine();
        System.out.print("Department: ");
        this.department = sc.nextLine();
    }
    public void printManagerDetails() {
        System.out.println("-------------------------------------------------");
        System.out.println("Manager Details : ");
        System.out.println("Name : " + this.Name);
        System.out.println("Age : " + this.Age);
        System.out.println("Ph No. : " + this.PhoneNumber);
        System.out.println("Address : " + this.Address);
        this.printSalary();
        System.out.println("Specialization : " + this.specialization);
        System.out.println("Department: " + this.department);
        System.out.println("-------------------------------------------------");
    }
}
public class sol3 {


    public static void main(String[] args) {
        System.out.println("Enter Employee Details : ");
        Employee emp = new Employee();
        emp.input();
        emp.printEmployeeDetails();

        System.out.println("Enter Manager Details : ");
        Manager mag = new Manager();
        mag.input();
        mag.printManagerDetails();
    }
}
