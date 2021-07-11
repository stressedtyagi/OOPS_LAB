/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package ENDSEM;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class SameAddressDifferentSubException extends Exception {
    SameAddressDifferentSubException(String s) {
        super(s);
    }
}

abstract class NewsPaperSubscriber {
    String street_address;
    double subscription_rate;

    public String get_address() {
        return this.street_address;
    }

    public double get_rate() {
        return this.subscription_rate;
    }

    public void set_address(String s) {
        this.street_address = s;
    }

    abstract public void set_rate(double x);

    public static boolean equals(String a, String b) {
        if (a.equals(b)) {
            return true;
        } else {
            return false;
        }
    }
}

class SevenDaySubscriber extends NewsPaperSubscriber {
    SevenDaySubscriber(String s) {
        set_address(s);
        set_rate(200);
    }

    public void set_rate(double x) {
        this.subscription_rate = x;
    }

    public String toString() {
        return this.street_address + " " + this.subscription_rate + " user is seven day subscriber";
    }
}

class WeekDaySubscriber extends NewsPaperSubscriber {
    WeekDaySubscriber(String s) {
        set_address(s);
        set_rate(150);
    }

    public void set_rate(double x) {
        this.subscription_rate = x;
    }

    public String toString() {
        return this.street_address + " " + this.subscription_rate + " user is week day subscriber";
    }
}

class WeekEndSubscriber extends NewsPaperSubscriber {
    WeekEndSubscriber(String s) {
        set_address(s);
        set_rate(50);
    }

    public void set_rate(double x) {
        this.subscription_rate = x;
    }

    public String toString() {
        return this.street_address + " " + this.subscription_rate + " user is week end subscriber";
    }
}

public class Subscribers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String address;
        int days;
        ArrayList<NewsPaperSubscriber> subscribers = new ArrayList<>();

        while (true) {
            try {
                System.out.println("-------------------------------------------------");
                System.out.print("Enter street address of subscriber: ");
                address = sc.nextLine();
                System.out.println("Enter type of subscription required: \n" +
                                    "1. Seven day subscription \n" +
                                    "2. Weekday subscription\n" +
                                    "3. Weekend subscription\n" +
                                    "4. EXIT");
                days = sc.nextInt();
                sc.nextLine();
                NewsPaperSubscriber sub = null;
                switch (days) {
                    case 1: {
                        for (int i = 0; i < subscribers.size(); i++) {
                            if(NewsPaperSubscriber.equals(subscribers.get(i).street_address,address) && subscribers.get(i).subscription_rate != 200)
                                throw new SameAddressDifferentSubException("Same User Different Subscription " +
                                        "Exception");
                        }
                        sub = new SevenDaySubscriber(address);
                        subscribers.add(sub);
                        System.out.println(sub.toString());
                        break;
                    }
                    case 2:{
                        for (int i = 0; i < subscribers.size(); i++) {
                            if(NewsPaperSubscriber.equals(subscribers.get(i).street_address,address) && subscribers.get(i).subscription_rate != 150)
                                throw new SameAddressDifferentSubException("Same User Different Subscription " +
                                        "Exception");
                        }
                        sub = new WeekDaySubscriber(address);
                        subscribers.add(sub);
                        System.out.println(sub.toString());
                        break;
                    }

                    case 3: {
                        for (int i = 0; i < subscribers.size(); i++) {
                            if(NewsPaperSubscriber.equals(subscribers.get(i).street_address,address) && subscribers.get(i).subscription_rate != 50)
                                throw new SameAddressDifferentSubException("Same User Different Subscription " +
                                        "Exception");
                        }
                        sub = new WeekEndSubscriber(address);
                        subscribers.add(sub);
                        System.out.println(sub.toString());
                        break;
                    }

                    case 4:
                        System.exit(0);
                    default:
                        break;
                }
            } catch (SameAddressDifferentSubException e) {
                e.printStackTrace();
            }
        }
    }
}
