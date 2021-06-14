/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package mid.sem.lab;

import java.util.Scanner;
class TimeLimitCrossed extends Exception {
    TimeLimitCrossed(String str) {
        super(str);
    }
}
public class q2 {
    private static class Clock{
        private int hrs,mins,secs;

        Clock(int hrs,int mins,int secs){
            this.hrs = hrs;
            this.mins = mins;
            this.secs = secs;
        }

        public Clock add(Clock o) throws TimeLimitCrossed {
            int secs = this.secs + o.secs;
            int carry = secs / 60;
            secs = secs % 60;

            int mins = this.mins + o.mins+carry;
            carry = mins / 60;
            mins = mins % 60;

            int hrs = this.hrs + o.hrs + carry;
            if(hrs > 23 || mins > 59 || secs > 59)
                throw new TimeLimitCrossed("Incorrect time : time limit Exceeded");

            return new Clock(hrs,mins,secs);
        }
        public String toString(){
            return String.format("%02d", hrs)+":"+String.format("%02d", mins)+":"+String.format("%02d", secs);
        }
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        try {
            System.out.print("Enter hrs min sec for first clock object : ");
            int hr1 = scn.nextInt(), min1=scn.nextInt() , sec1 =scn.nextInt();
            System.out.print("Enter hrs min sec for second clock object : ");
            int hr2 =scn.nextInt(),min2 =scn.nextInt(), sec2 =scn.nextInt();
            if(hr1 > 23 || min1 > 59 || sec1 > 59)
                throw new TimeLimitCrossed("Incorrect time : time format incorrect");
            if(hr2 > 23 || min2 > 59 || sec2 > 59)
                throw new TimeLimitCrossed("Incorrect time : time format incorrect");
            Clock c1 = new Clock(hr1,min1,sec1);
            Clock c2 = new Clock(hr2,min2,sec2);
            Clock c3 = c1.add(c2);
            System.out.println("Time 1 " + c1);
            System.out.println("Time 2 " + c2);
            System.out.println("Output after addition: " + c3);
        }catch (TimeLimitCrossed e) {
            e.printStackTrace();
        }

    }
}
