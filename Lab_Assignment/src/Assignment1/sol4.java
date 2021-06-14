/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment1;
/*
Write a java program to implement the following :
    Create a class called as Department, inside this create an instance variable
called as course name and static variable called as department name and now one
function for course details inside this function local variables for number of students
enrolled, faculty name, and credits of that course. Now from another class create
object for department class and print the relevant data specified above.
*/
class Department {
    public String course_name;
    public static String department_name;

    Department(String cn) {
        course_name = cn;
        department_name = "CSE : MCA";
    }

    public void course_details() {
        int num_of_studs = 56;
        int credit = 26;
        String faculty_name = "Sai Santosh Ambati";
        System.out.println(num_of_studs + " " + faculty_name + " " + credit);
    }
};
public class sol4 {
    public static void main(String[] args) {
        Department myDept = new Department("OOPS Programing Using Java");
        System.out.println(myDept.course_name);
        System.out.println(Department.department_name);
        myDept.course_details();
    }
}
