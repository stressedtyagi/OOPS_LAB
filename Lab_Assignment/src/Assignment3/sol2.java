/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;

class DuplicateIdException extends  Exception{
    DuplicateIdException(String prompt) {
        super(prompt);
    }
}

class EmptyStringException extends Exception {
    EmptyStringException(String prompt) {
        super(prompt);
    }
}

class StudentInfo {

    private String name, depart_name;
    private Integer id;
    static private String college_name;
    public StudentInfo(Integer id,String name, String depart_name) {
        this.id = id;
        this.name = name;
        this.depart_name = depart_name;
    }
    public  String getInfo() {
        return id + "|" + name + "|" + depart_name + "|" + college_name + "|";
    }

    public static void setCollege(String col_name) {
        college_name = col_name;
    }
}
public class sol2 {
    static private HashSet<Integer> idSet = new HashSet<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students : ");
        int n = sc.nextInt();
        System.out.println();
        StudentInfo students[] = new StudentInfo[n];
        try {
            System.out.print("Enter name of college: ");
            String college = sc.nextLine();
            System.out.println();
            StudentInfo.setCollege(college);
            for (int i = 0; i < n; i++) {
                System.out.println();
                System.out.println("Enter info of Student: " + (i+1));
                StudentInfo tempStudent = input();
                students[i] = tempStudent;
            }
        }catch (DuplicateIdException e) {
            System.err.println("Duplicate id exception");
            System.exit(0);
        }catch (EmptyStringException e) {
            System.err.println("Empty id exception");
            System.exit(0);
        }

        FileOutputStream fout;
        BufferedOutputStream buff;

        try {
            fout = new FileOutputStream("students.txt");
            buff = new BufferedOutputStream(fout);
            for (int i = 0; i < n; i++) {
                byte data[] = students[i].getInfo().getBytes(StandardCharsets.UTF_8);
                buff.write(data);
            }
            buff.flush();
            buff.close();
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StudentInfo input() throws DuplicateIdException, EmptyStringException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        Integer id = Integer.parseInt(sc.nextLine());
        if(!idSet.isEmpty() && idSet.contains(id)) {
            throw new DuplicateIdException("Student data already contains id : " + id);
        }else {
            idSet.add(id);
        }
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department name: ");
        String department = sc.nextLine();
        // check if name or department name is empty or not
        if(name.isEmpty() || department.isEmpty()) {
            throw new EmptyStringException("Enter name or department name is empty");
        }
        return new StudentInfo(id,name,department);
    }
}
