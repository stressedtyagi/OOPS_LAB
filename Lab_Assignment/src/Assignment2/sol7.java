/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment2;
class CounterTest {
    static int count = 0;
    {
        count++;
    }
    CounterTest() {
        if(count > 5) {
            System.out.println("Cannot create more than 5 Objects");
        }else {
            System.out.println("Object number : " + count + " Created Successfully");
        }
    }
}
public class sol7 {
    public static void main(String[] args) {
        CounterTest c1 = new CounterTest();
        CounterTest c2 = new CounterTest();
        CounterTest c3 = new CounterTest();
        CounterTest c4 = new CounterTest();
        CounterTest c5 = new CounterTest();
        CounterTest c6 = new CounterTest();
        CounterTest c7 = new CounterTest();
    }
}
